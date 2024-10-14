package ejercicios1_1_File;

import java.io.File;
import java.util.Arrays;

public class ejercicio1_7_v3 {
    public static void main(String[] args) {
        File carpeta = new File ("usuarios");

        String[] archivos = carpeta.list();

        if(archivos == null){
            System.out.println("Error");
        }else if (archivos.length == 0){
            System.out.println("Carpeta vacia");
        }else{
            //Arrays.stream(archivos).forEach(a -> System.out.println(a));
            Arrays.stream(archivos).forEach(System.out::println);
        }
    }
}
