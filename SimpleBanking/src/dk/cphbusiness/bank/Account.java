/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.bank;

/**
 *
 * @author RolfMoikjær
 */
public class Account {

    private Bank bank;
    private String number;
    private Customer customer;
    private int balance = 0;
    
    public Account(Bank bank, String number) {
        this.bank = bank;
        this.number = number;

    }

    public Account(Bank bank, Customer customer, String number) {
        this.bank = bank;
        this.number = number;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean isInternal() {
        return customer == null;
    }

    public Bank getBank() {
        return bank;
    }

    public int getBalance() {
        return balance;
    }

    public String getNumber() {
        return number;
    }

    public void transfer(String targetNumber, int amount) {
        Account target = bank.findAccount(targetNumber);
        this.balance -= amount;
        target.balance += amount;
        
    }
    

}
