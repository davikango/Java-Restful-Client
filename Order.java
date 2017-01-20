/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it410.gmu.edu;

/**
 *
 * @author david
 */
public class Order {
    private String[] products;
    private int quantity;
    private double totalCost;
    private Payment payment = null;

    public Order() {
        payment = new Payment();
    }

    public String[] getProducts() {
        return products;
    }

    public void setProducts(String[] products) {
        this.products = products;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Order{" + "products=" + products + ", quantity=" + quantity + ", totalCost=" + totalCost + ", payment=" + payment + '}';
    }
    
    
}
