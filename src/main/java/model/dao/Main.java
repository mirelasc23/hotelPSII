package model.dao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("valor 1:");
        Scanner in = new Scanner(System.in);
        int val1 = in.nextInt();
        
        System.out.println("valor 2:");
        int val2 = in.nextInt();
        
        TesteMirela tst = new TesteMirela();
        int resultado = tst.soma(val1, val2);
        System.out.println("resultado = " + resultado);
    }
    
}
