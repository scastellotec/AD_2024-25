package ejercicios1_1_File;

import java.io.File;

public class ejercicio1_2 {
    /*
    1.2 Instancia un directorio y determina si existe o no existe.
     Muestra su nombre, longitud y ruta absoluta
     */
    public static void main(String[] args) {
        File carpeta = new File("usuarios/imagenes");
        if(carpeta.exists()) {
            System.out.println("Existe");
            System.out.println(carpeta.getName());
            System.out.println(carpeta.getAbsolutePath());
            System.out.println(carpeta.length());
        }else
            System.out.println("No existe");
    }
}
