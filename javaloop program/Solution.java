import java.util.Scanner;
// question print the following 1 in this structure
//1 
//1 1 
//1 1 1 
//1 1 1 1
public class Solution{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the rows length : ");
        int n=sc.nextInt();
        for(int i=1;i<n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(1+" ");
                
            }
            System.out.println();
        }
        sc.close();
    }
}