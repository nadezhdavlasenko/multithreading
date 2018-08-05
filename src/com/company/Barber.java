package com.company;

import java.util.concurrent.TimeUnit;

public class Barber implements Runnable{
    private Barbershop barbershop;

    @Override
    public void run() {
        while (true){
            if (barbershop.noCustomers()){
                System.out.println("Barber sleeps");
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                cut(barbershop.nextCustomer());
            }
        }
    }

    public Barber(Barbershop theShop){
        barbershop = theShop;
    }

    private void cut(Customer customer){
        try {
            System.out.println("barber cuts " + customer.getCustomerName());
            Thread.sleep((int)(Math.random() * 10));
        } catch (Exception e) {}
    }
}
