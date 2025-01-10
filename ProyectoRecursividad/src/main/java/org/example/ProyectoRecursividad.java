package org.example;

import java.io.IOException;
import java.util.Scanner;

public class ProyectoRecursividad {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        imprimir();

    }
    public static void imprimir(){
        do {

            System.out.println("***** Proyecto de Recursividad *****");
            System.out.println("Selecciona el modo que quieras ejecutar...");
            System.out.println("\t1.- Dígitos");
            System.out.println("\t2.- Potencias");
            System.out.println("\t3.- Del Revés");
            System.out.println("\t4.- Binario");
            System.out.println("\t5.- A binario");
            System.out.println("\t6.- Orden alfabético");
            System.out.println("\t7.- Mostrar suma");

            int eleccion = teclado.nextInt();

            switch (eleccion) {
                case 1:
                    int numero=pedirnumero();
                    System.out.println(digitos());

                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("Quieres invertir una cadena o un numero");
                    String opcion = teclado.next();
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                default:
                    System.out.println("ERROR: la opción no es válida");
                    break;
            }

        } while (!salir());
    }


    public static boolean salir (){

        System.out.println("Elige una opción:");
        System.out.println("\t[M] - Volver al menú principal");
        System.out.println("\t[S] - Salir");
        String op = teclado.next().toUpperCase();
        return op.equals("S");

    }

    public static void borrar() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static void pedirnumero(int numero){
        System.out.println("Introduce un número:");
        int dig = teclado.nextInt();
    }

    public static int digitos(int n){

        if (n<10){
            return 1;
        }
        return 1 + digitos(n/10);

    }
    public static int potencias (int base, int exponente){

        if (exponente==0){
            return 1;
        }
        return base*potencias(base, --exponente);
    }

    public static void invertido (int numero){

        if (numero>=0&&numero<10){
            System.out.println(numero);
        }else {
            System.out.println(numero%10);
            invertido(numero/10);
        }
    }

}
