/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crud;

import java.util.Scanner;

/**
 *
 * @author vinod mali
 */
public class CRUD {

    public static void main(String[] args) {
        System.out.println("Welcome ....");
        
      
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("1.Add User\n 2.Display All Users \n 3.Update User \n 4.Get User \n 5. Delete User \n 6.EXIT");
            int ch=sc.nextInt();
            switch(ch){
                case 1:{
                    System.out.println("Enter Roll No");
                    int rno=sc.nextInt();
                    System.out.println("Enter Name");
                    String name=sc.next();
                    System.out.println("Enter Age");
                    int age=sc.nextInt();
                    CRUDexample.insertUser(rno, name, age);
                    break;
                }
                case 2:{
                    CRUDexample.displayAllUser();
                    break;
                }
                case 3:{
                    System.out.println("Enter Roll No");
                    int rno=sc.nextInt();
                    CRUDexample.updateUser(rno);
                    break;
                }
                case 4:{
                    System.out.println("Enter Role No");
                    int rno=sc.nextInt();
                    CRUDexample.getUser(rno);
                    break;
                }
                case 5:{
                    System.out.println("Enter Role No");
                    int rno=sc.nextInt();
                    CRUDexample.deleteUser(rno);
                    break;
                }
                case 6:{
                    return;
                }
                default:{
                    System.out.println("You Have Entered Wrong Value");
                }
                   
            }
        }
                
    }
}
