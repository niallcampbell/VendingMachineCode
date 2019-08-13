package com.mycompany.vendingmachine;

public class Snack 
{
    String name;
    double price;
    String code; //Code user needs to enter into the machine
    
    //Constructor
    public Snack(String code, String name, double price)
    {
        this.name = name;
        this.price = price;
        this.code = code;
    }
    
    public void printSnack()
    {
        System.out.println(code + " " + name + " €" + price );
    }
    
}
