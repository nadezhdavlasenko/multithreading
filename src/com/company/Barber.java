package com.company;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Barber implements Runnable{
    private Barbershop barbershop;

    @Override
    public void run() {
        while (true){
            if (barbershop.noCustomers()){
                System.out.println("Barber sleeps");
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                cut(barbershop.nextCustomer());
            }
        }
    }
//
//    private Customer customer;
//
    public Barber(Barbershop theShop){
        barbershop = theShop;
    }
//    public void run(){
//        while (true) {
//            try {
//                customer = barbershop.nextCustomer();
//                cut();
//                barbershop.showOut(customer);
//            } catch (InterruptedException e){}
//        }
//    }
    private void cut(Customer customer){
        try {
            System.out.println("barber cuts " + customer.getCustomerName());
            Thread.sleep((int)(Math.random() * 100));
        } catch (InterruptedException e) {}
    }
}
