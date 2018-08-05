package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int NR_OF_CUSTOMERS = 10;

    public static void main(String[] args) {
        Barbershop barbershop = new Barbershop();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Barber(barbershop));
        ExecutorService customersService = Executors.newCachedThreadPool();
        for (int i = 0; i < 30; i++) {
            executorService.execute(new Customer("Name" + i, barbershop));
        }
//        ExecutorService waitingRoomService = Executors.newFixedThreadPool(3);
//        for (int i = NR_OF_CUSTOMERS; i > 0 ; i--) {
//            waitingRoomService.execute(new Customer("Name" + i));
//        }
//        waitingRoomService.shutdown();
        //barberService.shutdown();
//        Barbershop barbershop = new Barbershop();
//        Thread [] customer;
//        Thread barber;
//        customer = new Thread[NR_OF_CUSTOMERS];
//
//        for(int i = 0; i<NR_OF_CUSTOMERS; i++){
//            customer[i] = new Customer ("c"+i, barbershop);
//            customer[i].start();
//        }
//        barber = new Barber(barbershop);
//        barber.start();
    }
}
