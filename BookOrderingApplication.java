/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it410.gmu.edu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author david
 */
@ManagedBean(name= "bookOrderingApplication")
@SessionScoped
public class BookOrderingApplication implements Serializable{
    private Customer customer = new Customer();
    //private Address address = new Address();
    private ArrayList<State> states = new ArrayList<>();
    private ArrayList<Customer> customerList = new ArrayList<>();
    private UserDataModel dataModel = new UserDataModel(customerList);
    private String[] books = {"Computer Science 101","History 101","Geography 101","English 101","Biology 101","Algebra 101","Calculus 101"};
    private String[] paymentOptions = {"Credit","Debit","Cash"};
    private static int id = 1;
    
    public BookOrderingApplication() {
    }
    
    public String getFirstName(){
        return customer.getAddress().getFirstName();
    }
    
    public void setFirstName(String firstName){
        customer.getAddress().setFirstName(firstName);
    }
    
    public String getLastName(){
        return customer.getAddress().getLastName();
    }
    
    public void setLastName(String lastName){
        customer.getAddress().setLastName(lastName);
    }
    
    public String getAddress(){
        return customer.getAddress().getAddress();
    }
    
    public void setAddress(String address1){
        customer.getAddress().setAddress(address1);
    }
    
    public String getCity(){
        return customer.getAddress().getCity();
    }
    
    public void setCity(String city){
        customer.getAddress().setCity(city);
    }
    
    public ArrayList<State> getStates(){
    
        states.add(new State("Virginia", "VA"));
        states.add(new State("Maryland", "MD"));
        states.add(new State("Pensylvannia", "PA"));
        states.add(new State("Florida", "FA"));
        states.add(new State("Georgia", "GA"));
        states.add(new State("California", "CA"));
        states.add(new State("New York", "NY"));
        
        return states;
    }
    
    public String getState(){
        return customer.getAddress().getState();
    }
    
    public void setState(String state){
        customer.getAddress().setState(state);
    }
    
    public String getZipCode(){
        return customer.getAddress().getZipCode();
    }
    
    public void setZipCode(String zipCode){
        customer.getAddress().setZipCode(zipCode);
    }

    public UserDataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(UserDataModel dataModel) {
        this.dataModel = dataModel;
    }

    public String[] getBooks() {
        return books;
    }
    
    public String[] getProducts(){
        return customer.getOrder().getProducts();
    }
    
    public void setProducts(String[] products){
        customer.getOrder().setProducts(products);
        
    }
    
    public int getQuantity(){
        return customer.getOrder().getQuantity();
    }
    
    public void setQuantity(int quantity){
        customer.getOrder().setQuantity(quantity);
    }
    
    public double getTotalCost(){
        return customer.getOrder().getTotalCost();
    }
    
    public void setTotalCost(double totalCost){
        totalCost = customer.getOrder().getQuantity() * 50;
        customer.getOrder().setTotalCost(totalCost);
        
    }
    
    public String getPaymentType(){
        return customer.getOrder().getPayment().getPaymentType();
    }
    
    public void setPaymentType(String paymentType){
        customer.getOrder().getPayment().setPaymentType(paymentType);
    }

    public String[] getPaymentOptions() {
        return paymentOptions;
    }
    
    public String getAccountNumber(){
        return customer.getOrder().getPayment().getAccountNumber();
    }
    
    public void setAccountNumber(String accountNumber){
        customer.getOrder().getPayment().setAccountNumber(accountNumber);
    }
    
    public void orderEntry(ActionEvent ae){
        customer.setId(id++);
        System.out.println("First Name= " + customer.getAddress().getFirstName());
        System.out.println("Last Name= " + customer.getAddress().getLastName());
        System.out.println("Address= " + customer.getAddress().getAddress());
        System.out.println("City= " + customer.getAddress().getCity());
        System.out.println("State = " + customer.getAddress().getState());
        System.out.println("Zip Code= " + customer.getAddress().getZipCode());
        System.out.println("Products = " + Arrays.toString(customer.getOrder().getProducts()));
        System.out.println("Quantity = " + customer.getOrder().getQuantity());
        System.out.println("Total Cost = " + customer.getOrder().getTotalCost());
        System.out.println("Payment Option = " + customer.getOrder().getPayment().getPaymentType());
        System.out.println("Account Number = " + customer.getOrder().getPayment().getAccountNumber());
        this.customerList.add(customer);
        
        try {
        //Integrate with RESTful Web Service.
        OrderingServiceClient.addCustomerJSON(customer);
        OrderingServiceClient.getCustomersJSON();
        } catch (Exception e) {
            
        }
        customer = new Customer();
        
    } 
    
    public void selectCustomer(SelectEvent se){
        customer = (Customer) se.getObject();
    }
    
    public void unselectCustomer(UnselectEvent ue){
        customer = (Customer) ue.getObject();
        customer = new Customer();
    }   
    
    public void resetForm(){
        customer = new Customer();
    }
}
