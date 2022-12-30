/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.driver.Exceptions;

/**
 *
 * @author Vikas_Singh
 */
public class Insufficient_funds extends RuntimeException{

    public Insufficient_funds() {
        super("Insufficient Balance");
    }
    
}
