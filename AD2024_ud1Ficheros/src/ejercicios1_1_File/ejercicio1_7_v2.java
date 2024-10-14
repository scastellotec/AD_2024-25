package ejercicios1_1_File;

import java.io.File;
import java.util.Arrays;

public class ejercicio1_7_v2 {
    public static void main(String[] args) {
        File carpeta = new File ("usuarios");

        String[] archivos = carpeta.list();

        if(archivos == null){
            System.out.println("Error");
        }else if (archivos.length == 0){
            System.out.println("Carpeta vacia");
        }else{
            for (String a: archivos){
                System.out.println(a);
            }
            Arrays.stream(archivos).forEach(a -> System.out.println(a));
            /*
            for(int i=0; i < archivos.length; i++){
                System.out.println(archivos[i]);
            }*/
        }
    }
}
