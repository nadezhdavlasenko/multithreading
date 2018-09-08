package com.company;

import java.util.concurrent.Callable;

public class Customer implements Runnable, Callable<Customer>{

    private String name;
    private Barbershop barbershop;

    public Customer(String name, Barbershop barbershop){
        this.name = name;
        this.barbershop = barbershop;
    }

    @Override
    public void run(){
            for(int i = 0; i < barbershop.waitingRoom.length; i++){
                if (barbershop.waitingRoom[i] == null){
                    System.out.println(this.name +" seats in waiting room");
                    barbershop.waitingRoom[i] = this;

                    return;
                }
            }
            System.out.println(this.name +" goes away");
    }

    public String getCustomerName(){
        return name;
    }

    @Override
    public Customer call() throws Exception {
        synchronized (barbershop.waitingRoom) {
            for (int i = 0; i < barbershop.waitingRoom.length; i++) {
                if (barbershop.waitingRoom[i] == null) {
                    System.out.println(this.name + " seats in waiting room");
                    barbershop.waitingRoom[i] = this;

                    return this;
                }
            }
        }
        System.out.println(this.name +" goes away");
        return null;
    }
}
