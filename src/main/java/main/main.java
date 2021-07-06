/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author facu
 */
public class main {

    public static void main(String[] args) {
        int arr = 10;        
        int op = -1;
        
        Arbol[] arboles = new Arbol[arr];
        var terminal = new Scanner(System.in);
        var interactArbol = new InteractArbol(arr); 
        
        arboles = interactArbol.returnNull(arr);
        
        while (op != 0) {
            printOptions();
            op = terminal.nextInt();


            switch (op) {
                case 1:
                    int num;
                    
                    printNumber();
                    num = terminal.nextInt();
                    try{
                        interactArbol.insertArbol(num, 0, arboles);
                        printSuccessfully();  
                                                
                    }
                    catch(Exception e){
                        printErrorDate();
                        
                    }                                      
                    
                    break;

                case 2:
                    printRead();
                    printShowDatas();
                    interactArbol.showArbol(arboles);

                    break;

                default:
                    printErrorDefault();

                    break;

            }
            printEnd();
            
        }
    }

    public static void printNumber() {
        System.out.println("Ingrese un numero");

    }

    public static void printShowDatas() {
        System.out.println("Datos: ");

    }

    public static void printSuccessfully() {
        System.out.println("Exitoso √");

    }

    public static void printOptions() {
        System.out.println("ELIGE UNA OPCION:\n1. Crear una raiz\n2. Mostrar raiz\n0. Salir");

    }

    public static void printErrorDefault() {
        System.out.println("VUELVE A INTENTAR...");

    }

    public static void printEnd() {
        System.out.println("\n==============================\n");

    }
    
    public static void printErrorDate(){
        System.out.println("Error(Valor de dato insufiente para el vector)");        
        
    }
    
    public static void printRead(){
        System.out.println("Leyendo...");
        
    }
}

class Arbol {

    private int num;

    public Arbol() {
    }

    public Arbol(int num) {
        this.num = num;

    }

    public Integer getNum() {
        return this.num;

    }

    public void setNum(int num) {
        this.num = num;

    }
}

class InteractArbol {

    public static int arr;

    public InteractArbol(int arr) {
        InteractArbol.arr = arr;

    }

    public void insertArbol(int num, int i, Arbol arboles[]) {
        Boolean checkIfNullArbol = (arboles[i].getNum() == 0);
        
        if (checkIfNullArbol) {
            arboles[i].setNum(num);

        } else {
            if (num < arboles[i].getNum()) {
                insertArbol(num, (2 * i) + 1, arboles);

            } else {
                insertArbol(num, (2 * i) + 2, arboles);

            }
        }
    }

    public void showArbol(Arbol arboles[]) {
        int i = 0;
        for (Arbol arbol : arboles) {
            System.out.println(i + ":" + arbol.getNum());
            i++;

        }
    }
    
    public static Arbol[] returnNull(int arr){
        Arbol[] arboles = new Arbol[arr];
        
        for(int i = 0 ; i < arr; i++){
            arboles[i] = new Arbol();
            
        }
        return arboles;
        
    }
}
