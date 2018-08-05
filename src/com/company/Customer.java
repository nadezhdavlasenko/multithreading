package com.company;

public class Customer implements Runnable{
    private String name;

    private Barbershop barbershop;
//    private String name;
    public Customer(String name, Barbershop barbershop){
        this.name = name;
        this.barbershop = barbershop;
    }
//
    public void run(){

            for(int i = 0; i < barbershop.waitingRoom.length; i++){
                if (barbershop.waitingRoom[i] == null){
                    barbershop.waitingRoom[i] = this;
                    System.out.println(this.name +" seats in waiting room");
                    return;
                }
            }
            System.out.println(this.name +" goes away");


//            try{
//                justLive();
//                barbershop.getHaircut();
//            } catch (InterruptedException e){};

    }
//
//    private void justLive(){
//        try {
//            System.out.println(name + " living");
//            Thread.sleep((int)(Math.random() * 1000));
//        } catch (InterruptedException e) {}
//
//    }
//
    public String getCustomerName(){
        return name;
    }
}
