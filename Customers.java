/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it410.gmu.edu;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Customers {
    private ArrayList<Customer> customersJSON = new ArrayList();

    public Customers() {
    }
    
    public ArrayList<Customer> getCustomersJSON() {
        return customersJSON;
    }

    public void setCustomersJSON(ArrayList<Customer> customersJSON) {
        this.customersJSON = customersJSON;
    }

    @Override
    public String toString() {
        return "Customers{" + "customersJSON=" + customersJSON + '}';
    }
    
}
