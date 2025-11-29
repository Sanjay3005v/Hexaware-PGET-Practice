package com.example.util;

import java.util.Scanner;
public class InputUtil {
    private static Scanner scan = new Scanner(System.in);
    public static int getInt(String message){
        System.out.print(message);
        while(!scan.hasNextInt()){
            System.out.println("Invalid");
            scan.next();
            System.out.print(message);
        }
        return scan.nextInt();
    }
    public static String getString(String message){
        System.out.print(message);
        scan.nextLine();
        String temp = scan.nextLine();
        while(temp.trim().isEmpty()){
            System.out.println(message);
            temp = scan.nextLine();
        }
        return temp;
    }
}
