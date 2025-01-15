package org.example;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ProyectoRecursividad {

    static Scanner teclado = new Scanner(System.in);
    static char palabra[];

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
                    System.out.println("Dime un número");
                    int numero=pedirnumero();
                    System.out.println("El numero es: "+digitos(numero));
                    break;
                case 2:
                    System.out.println("Dime la base:");
                    int base=pedirnumero();
                    System.out.println("Dime el exponente:");
                    int exp=pedirnumero();
                    System.out.println("El numero es: "+potencias(base,exp));
                    break;
                case 3:
                    System.out.println("dime el modo que quieres elegir:");
                    System.out.println("\t 1.numero");
                    System.out.println("\t 2.cadena");
                    int opcion = teclado.nextInt();
                    switch (opcion){
                        case 1:
                            System.out.println("Has elegido invertir numero");
                            System.out.println("Dime un numero:");
                            int inv = pedirnumero();
                            invertido(inv);
                            break;
                        case 2:
                            System.out.println("Has elegido invertir cadena");
                            System.out.println("Dime una cadena:");
                            String p = teclado.next();
                            palabra=p.toCharArray();
                            System.out.print(Arrays.toString(palabra));
                            invertir_palabra(palabra.length-1);
                            break;
                        default:
                            System.out.println("ERROR");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Dime un numero:");
                    int bin = pedirnumero();
                    if (esBinario(bin)){
                        System.out.println("El numero "+bin + " es binario");
                    }else {
                        System.out.println("El numero "+bin+" no es binario");
                    }

                    break;
                case 5:
                    System.out.println("dime un numero para convertir en binario:");
                    int conv= pedirnumero();
                    System.out.println("El numero en binario es "+convertir(conv));

                    break;
                case 6:
                    System.out.println("Dime una palabra");
                    String pal = teclado.next();
                    palabra=pal.toLowerCase().toCharArray();
                    System.out.print(Arrays.toString(palabra));
                    if (estaOrdenada(0)){
                        System.out.println("palabra ordenada");
                    }else{
                        System.out.println("palabra desordenada");
                    }

                    break;
                case 7:
                    System.out.println("Dime un numero:");
                    int numro=pedirnumero();
                    System.out.println(suma(numro));
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

    public static int pedirnumero(){
        return teclado.nextInt();
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
    public static void invertir_palabra (int contador){
        if (contador==0){
            System.out.println(palabra[contador]);
        }else {
            System.out.println(palabra[contador]);
            invertir_palabra(--contador);
        }
    };

    public static boolean estaOrdenada(int posicion) {
        if (posicion < palabra.length - 1) {
            if (palabra[posicion] <= palabra[posicion + 1]) {
                return estaOrdenada(++posicion);
            } else {
                return false;
            }
        }
        return true;
    };

    public static boolean esBinario (int numero){
        if (numero>9){
            if (numero%10==0|| numero%10==1){
                return esBinario(numero/10);
            }else{
                return false;
            }
        }
        if (numero==0||numero==1){
            return true;
        }else {
            return false;
        }
    }

    public static String convertir(int numero){

        if (numero==1||numero==0){
            return Integer.toString(numero);
        }else {
            return convertir(numero/2)+numero%2;
        }
    }

    public static int suma(int numero) {
        if (numero == 1) {
            return 1;
        }
        return numero + suma(numero - 1);
    }


}

