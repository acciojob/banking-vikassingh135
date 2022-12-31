package com.driver;

import com.driver.Exceptions.Insufficient_funds;
import com.driver.Exceptions.account_can_not_generated_exception;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount() {
    }
    
    

    public BankAccount(String name, double balance, double minBalance) {
//             if(balance < minBalance) throw new Insufficient_funds();
             this.name = name;
             this.balance = balance;
             this.minBalance = minBalance;
            if(this.balance < this.minBalance) throw new Insufficient_funds();
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

        String accountNumber = null;
        
        for(int i=1; i<=sum; i++) {
            if(sum==digitsSum(i)){
                accountNumber = Integer.toString(i);
                break;
            }
        }
        if(accountNumber==null) throw new account_can_not_generated_exception();
        else return accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    
    
    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount; 
    }

    public void withdraw(double amount) throws Exception {
        if(balance - amount < minBalance) throw new Insufficient_funds();
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        else balance -= amount;
    }
    
    public int digitsSum(int n) {
        int ans = 0;
        while(n>0) {
            ans += (n%10);
            n /= 10;
        }
        return ans;
    }

}