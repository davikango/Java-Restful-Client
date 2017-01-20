/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it410.gmu.edu;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author david
 */
public class UserDataModel extends ListDataModel<Customer> implements SelectableDataModel<Customer>{
    public UserDataModel() {  
    }  
  
    public UserDataModel(List<Customer> data) {  
        super(data);  
    }  
      
    @Override  
    public Customer getRowData(String rowKey) {  
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data 
          
        System.out.println(" Key = " + rowKey);
        List<Customer> customers = (List<Customer>) getWrappedData();  
          
        for(Customer customer : customers) {  
            if(customer.getId().equals(rowKey))  
                return customer;  
        }  
          System.out.println(" Valid User not found");
        return null;  
    }  
  
    @Override  
    public Object getRowKey(Customer customer) {  
        return customer.getId();
    }  
}
