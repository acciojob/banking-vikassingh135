/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.driver.Exceptions;

/**
 *
 * @author Vikas_Singh
 */
public class account_can_not_generated_exception extends RuntimeException{

    public account_can_not_generated_exception() {
        super("Account Number can not be generated");
    }
    
}
