package com.mycompany.vendingmachine;

import java.util.Scanner;
import java.util.ArrayList;

public class VendingMachine implements VendingMachineInterface {
    
    public String snackSelected = "";
    public Snack mars = new Snack("1A", "Mars", 1);
    public Snack snickers = new Snack("1B", "Snickers", 1);
    public Snack crisps = new Snack("1C", "Crisps", 2);
    public Snack coke = new Snack("2A", "Coke", 3);
    public Snack pepsi = new Snack("2B", "Pepsi", 3);
    public Snack fanta = new Snack("2C", "Fanta", 3);
    ArrayList<Snack> snacks = new ArrayList<Snack>();
    
    public Coin tenCent = new Coin(.1, "Ten Cent");
    public Coin twentyCent = new Coin(.2, "Twenty Cent");
    public Coin fiftyCent = new Coin(.5, "Fifty Cent");
    public Coin oneEuro = new Coin(1, "One Euro");
    public Coin twoEuro = new Coin(2, "Two Euro");
    ArrayList<Coin> coins = new ArrayList<Coin>();
    
    //Default Constructor
    public VendingMachine()
    {
        
    }
    
    
    //prompt the user to choose a snack from the Vending machine
    //print the available snacks
    public void chooseSnack()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the code of the snack you wish to purchase: ");
        System.out.println();
        
        for(int i=0; i < snacks.size(); i++)
        {
            snacks.get(i).printSnack();
        }
        
        String selectionCode = scan.nextLine();
        
        Snack chosenSnack = null;
        
        for(int i = 0; i < snacks.size(); i++)
        {
            if(selectionCode.equals(snacks.get(i).code))
            {
                chosenSnack = snacks.get(i);
            }
        }
        
        enterMoney(chosenSnack);
        
    }
    
    //Prompt the user to enter their money
    //If they put in too much, return their change
    //If they put in too little, inform them they need to put in more
    //Allow the user to cancel the request and return their money (keep track of coins entered in ArrayList)
    public void enterMoney(Snack s)
    {
        ArrayList<Coin> coinsEntered = new ArrayList<Coin>(); //stores the coins entered by the user
        
        System.out.println("You have chosen: " + s.name);
        System.out.println("The price of this item is: " + s.price);
        System.out.println("Please enter your money");
        
        double totalMoneyEntered = 0;
        double moneyLeft = s.price; //money user has left to pay
        double price = s.price;
        
        Scanner scan = new Scanner(System.in);
        
        while(totalMoneyEntered < price)
        {
            System.out.println("Please enter a coin: .10, .20, .50, 1, 2");
            double coinEntered = scan.nextDouble();
            
            for(int i = 0; i < coins.size(); i++)
            {
                if(coinEntered == coins.get(i).value)
                {
                    coinsEntered.add(coins.get(i));
                    totalMoneyEntered += coins.get(i).value;
                    moneyLeft = moneyLeft - coins.get(i).value;
                    System.out.println("Total entered: €" + totalMoneyEntered);
                    System.out.println("Cost remaining: €" + moneyLeft);
                }
            }
        }
        
        //if the user is due back change
        double changeDue = totalMoneyEntered - price;
        System.out.println("Please take your change of €" + changeDue);
        System.out.println("Enjoy your " + s.name + "!");
        
    }
    
    public void populateVendingMachine()
    {
        snacks.add(mars);
        snacks.add(snickers);
        snacks.add(crisps);
        snacks.add(coke);
        snacks.add(pepsi);
        snacks.add(fanta);
        
        coins.add(twentyCent);
        coins.add(fiftyCent);
        coins.add(oneEuro);
        coins.add(twoEuro);
    }
    
    
    public static void main(String args[])
    {
        System.out.println("Welcome to the Vending Machine!");
        Scanner scan = new Scanner(System.in);
        String status = "";
        VendingMachine vm = new VendingMachine();
        vm.populateVendingMachine();
        System.out.println("If you wish to continue enter 'go', otherwise enter 'cancel'");
        status = scan.nextLine();
        
        while(!status.equals("cancel"))
        {
            vm.chooseSnack();
            System.out.println("If you wish to continue enter 'go', otherwise enter 'cancel'");
            status = scan.nextLine();
        }
    }
}
