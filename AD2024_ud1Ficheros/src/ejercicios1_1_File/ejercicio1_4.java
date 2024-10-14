package ejercicios1_1_File;

import java.io.File;

public class ejercicio1_4 {
    public static void main(String[] args) {
        File nuevaCarpeta = new File("usuarios/ejercicios");

        if(nuevaCarpeta.mkdir()){
            System.out.println("Carpeta creada OK");
        }else{
            System.out.println("Error inesperado en la cración de la carpeta o carpeta ya existente");
        }
    }
}
