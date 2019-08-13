
package com.mycompany.vendingmachine;

/**
 *
 *  You need to design a Vending Machine which follows following requirements
    Accepts coins of 1,5,10,25, 50 Cents i.e. penny, nickel, dime, and quarter as well as 1 and 2 dollar note
    Allow user to select products e.g. CANDY(10), SNACK(50), NUTS(90), Coke(25), Pepsi(35), Soda(45)
    Allow user to take refund by canceling the request.
    Return selected product and remaining change if any
    Allow reset operation for vending machine supplier
 */
public interface VendingMachineInterface 
{
    public void chooseSnack();
    public void enterMoney(Snack s);
}
