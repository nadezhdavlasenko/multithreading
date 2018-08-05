package com.company;

public class Customer implements Runnable{

    private String name;
    private Barbershop barbershop;

    public Customer(String name, Barbershop barbershop){
        this.name = name;
        this.barbershop = barbershop;
    }

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

}
