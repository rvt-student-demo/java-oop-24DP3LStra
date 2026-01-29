package rvt;

import java.util.Scanner;

public class chap100EX {

 public static void main(String[] args) {
    while (true) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numerator:"); 
        String numerator = sc.nextLine();
        char first = numerator.charAt(0);
        int num;
        
        if (first == 'q' || first == 'Q'){
            break;
        }
        try{
            num = Integer.parseInt(numerator);
        }
        catch(NumberFormatException e){
            System.out.println("You entered bad data.");
            System.out.println("Please try again");
            System.out.println("");
            continue;
        }

        System.out.println("Enter the divisor:");
        String divisor = sc.nextLine();
        char second = divisor.charAt(0);
        if (second == 'q' || second == 'Q'){
            break;
        }
        int div;
        try{
            div = Integer.parseInt(divisor);
        }
        catch(NumberFormatException e){
            System.out.println("You entered bad data.");
            System.out.println("Please try again");
            System.out.println("");
            continue;
        }
        if (div == 0) {
            System.out.println("You can't divide " + num + " by 0");
            System.out.println("");
            continue;
        }

        System.out.println(num + " / " + div + " is " + num /div);
        System.out.println("");

    }
 }
}
