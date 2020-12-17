package com.company;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        String titulo;

        System.out.println("Bienvenido!");
        System.out.print("Ingrese el titulo de la conferencia:  ");
        titulo = LeerTexto(ent);
        IngresarAlumnos();
    }

    //funcion que define la lectura de texto
    public static String LeerTexto(Scanner Sc){
        return Sc.nextLine();
    }

    //funcion que se encarga del registro de las cuentas de los alumnos concurrentes y su conteo.
    public static void IngresarAlumnos(){
        Scanner Datos = new Scanner(System.in);
        String cuentas[] = new String[25];
        int contadorAlumnos=0;
        String opt="s";

        System.out.println();

        while(contadorAlumnos<25 && opt.equals("s")) {
            System.out.println("Ingrese numero de cuenta: ");
            cuentas[contadorAlumnos] = LeerTexto(Datos);

            contadorAlumnos++;

            if(contadorAlumnos<25) {
                System.out.print("Desea ingresar otra cuenta de alumno? s/n   ");
                opt = LeerTexto(Datos);
            }
        }

        for (int i=0;i<contadorAlumnos;i++){
            for (int j=0;j<contadorAlumnos-1;j++){
                if(i!=j){
                    if(cuentas[i].equals(cuentas[j])){
                        cuentas[j]=" ";    //aqui reemplaza los elementos repetidos por espacios vacios
                    }
                }
            }
        }

        System.out.println("\nCuentas de alumnos concurrentes a la conferencia:");
        int noRepetidos=0;
        for (int i=0;i<contadorAlumnos;i++){
            if(!cuentas[i].equals(" ")){   //aqui compara aquellos elementos vacios y los descarta para tomar en cuenta unicamente los elementos no repetidos
                System.out.println(cuentas[i]);
                noRepetidos++;
            }
        }
        System.out.println("Total Alumnos: "+noRepetidos);
    }
}