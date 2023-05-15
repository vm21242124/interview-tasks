/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;


/**
 *
 * @author vinod mali
 */
public class Connection {
    public static MongoClient CreateConnection() {
        String connction="mongodb+srv://vm21242124:ILfTf5ptwmWnOcYC@cluster0.untzeai.mongodb.net/?retryWrites=true&w=majority";
       
            MongoClient mg=MongoClients.create(connction);
            System.out.println("connection created "+mg);
          
        return mg;
    }
}
