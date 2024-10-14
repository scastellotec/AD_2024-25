package ejercicios1_1_File;

import java.io.File;

public class ejercicio1_7 {
    public static void main(String[] args) {
        File carpeta = new File ("usuarios");

        String[] archivos = carpeta.list();

        if(archivos == null){
            System.out.println("Error");
        }else if (archivos.length == 0){
            System.out.println("Carpeta vacia");
        }else{
            for(int i=0; i < archivos.length; i++){
                System.out.println(archivos[i]);
            }
        }
    }
}
