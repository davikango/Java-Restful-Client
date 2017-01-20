/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it410.gmu.edu;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author david
 */
public class OrderingServiceClient {

    public static void main(String[] args) throws Exception {
         
    }
    
    
    public static void addCustomerJSON(Customer customer) throws IOException {
        
        Gson gson = new Gson();
        String customerString = gson.toJson(customer);
        System.out.println("Customer JSON = " + customerString);
        
        HttpClient client = new DefaultHttpClient();
     
        HttpPost post = new HttpPost("http://localhost:8080/BookstoreRestService/generic/addOrderJSON");
        post.setHeader("Content-Type", "application/json");
        StringEntity entity = new StringEntity(customerString);
        post.setEntity(entity);
        HttpResponse response = client.execute(post);
        
        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        String line = "";
         while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }

    }
    
    public static void getCustomersJSON() throws Exception {
        
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://localhost:8080/BookstoreRestService/generic/getOrdersJSON");
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        StringBuilder sb = new StringBuilder();

        while ((line = rd.readLine()) != null) {
          //System.out.println(line);
          sb.append(line);
        }
        System.out.println("Customers JSON = " + sb.toString());

        Gson gson = new Gson();
        Customers customers = gson.fromJson(new StringReader(sb.toString()), Customers.class); 

        System.out.println(" JSON Customer List size = " + customers.getCustomersJSON().size());
 }
}
