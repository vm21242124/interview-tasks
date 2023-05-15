/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.Scanner;
import org.bson.Document;

/**
 *
 * @author vinod mali
 */
public class CRUDexample {

    public static MongoCollection setCollection() {
        MongoClient mg = Connection.CreateConnection();
        MongoDatabase dbs = mg.getDatabase("ecommerce");
        MongoCollection<Document> collection = dbs.getCollection("tempusers");
        return collection;
    }
    public static void insertUser(int rollno,String name,int Age){
        Document document = new Document("rollno",rollno).append("name", name).append("age", Age);
        MongoCollection col=setCollection();
        col.insertOne(document);
       
    }
    public static void getUser(int rollno){
        MongoCollection col=setCollection();
        Document user= (Document) col.find(new Document("rollno",rollno)).first();
        System.out.println(user);
    }
    public static void updateUser(int rollno){
        MongoCollection col=setCollection();
        System.out.println("1.update name \n 2.update Age");
        Scanner sc=new Scanner(System.in);
        int ch=sc.nextInt();
        switch (ch) {
            case 1:
                System.out.println("Enter new Name");
                String newname=sc.next();
                col.updateOne(new Document("rollno",rollno),new Document("$set",new Document("name",newname)));
                break;
            case 2:
                System.out.println("Enter new Name");
                int newage=sc.nextInt();
                col.updateOne(new Document("rollno",rollno),new Document("$set",new Document("age",newage)));
                break;
            default:
                System.out.println("You have entered wrong choice");
                break;
        }
   
    }
    public static void displayAllUser(){
        MongoCollection col=setCollection();
        FindIterable<Document> users=col.find();
        try (MongoCursor<Document> it = users.iterator()) {
            while(it.hasNext()){
                Document user=it.next();
                System.out.println(user.toJson());
                
            }
        }
    }
    public static void deleteUser(int roll){
        MongoCollection col=setCollection();
        col.findOneAndDelete(new Document("rollno",roll));
        System.out.println("deleted successfully");
    }
    
}
