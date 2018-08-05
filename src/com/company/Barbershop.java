package com.company;

public class Barbershop {
    Customer[] waitingRoom = new Customer[3];

    public  Customer nextCustomer(){
        Customer inChair = waitingRoom[0];
        for (int i = 0; i < waitingRoom.length-1; i++){
            waitingRoom[i] = waitingRoom[i+1];
        }
        waitingRoom[waitingRoom.length-1] = null;
        return inChair;
    }

    public boolean noCustomers(){
        for (Customer c : waitingRoom) {
            if (c != null)
                return false;
        }
        return true;
    }

}
