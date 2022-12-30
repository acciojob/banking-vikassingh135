/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.driver.Exceptions;

/**
 *
 * @author Vikas_Singh
 */
public class max_withdraw_limit_exceeded extends RuntimeException{

    public max_withdraw_limit_exceeded() {
        super("Maximum Withdraw Limit Exceed");
    }
    
}
