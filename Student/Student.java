package Student;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Student {
    public static void main(String[] args) {
        System.out.println("Enter Following details of student");
        ValidateStudent();

    }

    private static void ValidateStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Roll No : ");
        int rno = sc.nextInt();
        System.out.println("Enter Name : ");
        String name = sc.next();
        System.out.println();
        System.out.println("Enter phone : ");
        String phone = sc.next();
        System.out.println();
        System.out.println("Enter Email Address : ");
        String email = sc.next();
        sc.close();
        if (phone.length() != 10) {
            System.out.println("Invalid phone no.");
            return;
        }
        if (!checkEmail(email)) {
            System.out.println("Invalid email address");
        }else{
            System.out.println("Student Validate SuccessFull");
        }
        printStudent(rno, name, email, phone);
    }

    private static void printStudent(int rno, String name, String email, String phone) {
        System.out.println("Details of student are : ");
        System.out.println("Roll No : " + rno);
        System.out.println("Name : " + name);
        System.out.println("Phone : " + phone);
        System.out.println("Email : " + email);
    }

    private static boolean checkEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pt = Pattern.compile(emailRegex);
        return pt.matcher(email).matches();
    }

}
