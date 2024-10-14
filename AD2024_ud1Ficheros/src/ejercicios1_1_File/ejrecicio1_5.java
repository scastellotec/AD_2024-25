package ejercicios1_1_File;

import java.io.File;

public class ejrecicio1_5 {
    public static void main(String[] args) {
        File archivoAEliminar = new File ("usuarios/ejercicio13.txt");
        if(archivoAEliminar.delete()){
            System.out.println("Archivo eliminado");
        }else{
            System.out.println("Archivo no existente o error");
        }
    }
}
