package com.company;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Barbershop barbershop = new Barbershop();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Barber(barbershop));
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Customer("Name" + i, barbershop));
            TimeUnit.MILLISECONDS.sleep(50);
        }
        for (int i = 5; i < 20; i++) {
            executorService.execute(new Customer("Name" + i, barbershop));
            TimeUnit.MILLISECONDS.sleep(1);
        }
        TimeUnit.MILLISECONDS.sleep(100);
        Collection<Customer> customers = new HashSet<>();
        for (int i = 20; i < 100; i++) {
            //executorService.execute(new Customer("Name" + i, barbershop));
            customers.add(new Customer("Name" + i, barbershop));

        }
        executorService.invokeAll(customers);

    }
}
