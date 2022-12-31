package com.driver;

import com.driver.Exceptions.Insufficient_funds;
import com.driver.Exceptions.max_withdraw_limit_exceeded;

public class SavingsAccount extends BankAccount {

    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name, balance, 0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;

    }

    public double getRate() {
        return rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    @Override
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if (amount < maxWithdrawalLimit) {
            if (this.getBalance() - amount < this.getMinBalance()) {
                throw new Insufficient_funds();
            } // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
            else {
                double remAmount = this.getBalance() - amount;
                this.setBalance(remAmount);
            }
        } else {
            throw new max_withdraw_limit_exceeded();
        }
    }

    public double getSimpleInterest(int years) {
        // Return the final amount considering that bank gives simple interest on current amount
        return (this.getBalance() * rate * years) / 100;
    }

    public double getCompoundInterest(int times, int years) {
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        return this.getBalance() * Math.pow(1 + (this.rate / times), times * years);
    }

}
