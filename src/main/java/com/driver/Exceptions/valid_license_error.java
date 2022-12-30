/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.driver.Exceptions;

/**
 *
 * @author Vikas_Singh
 */
public class valid_license_error extends RuntimeException{

    public valid_license_error() {
        super("Valid License can not be generated");
    }
    
}
