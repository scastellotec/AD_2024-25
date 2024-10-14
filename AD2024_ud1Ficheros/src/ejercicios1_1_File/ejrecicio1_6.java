package ejercicios1_1_File;

import java.io.File;

public class ejrecicio1_6 {
    public static void main(String[] args) {
        File directorioEliminar = new File ("usuarios/imagenes");
        if(directorioEliminar.delete()){
            System.out.println("Carpeta eliminada");
        }else{
            System.out.println("Carpeta no existente o error");
        }
    }
}
