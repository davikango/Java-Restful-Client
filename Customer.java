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
public class Customer {
    private Address address = null;
    private Order order = null;
    private Integer id;

    public Customer() {
        address = new Address();
        order = new Order();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" + "address=" + address + ", order=" + order + ", id=" + id + '}';
    }
    
}
