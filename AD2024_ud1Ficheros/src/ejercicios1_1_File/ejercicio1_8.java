package ejercicios1_1_File;

import java.io.File;

public class ejercicio1_8 {
    public static void main(String[] args) {
        File carpeta = new File("usuarios");
        muestraArchivos(carpeta);

    }

    static void muestraArchivos(File c){
        // Recojo la carpeta que me llega como parametro
        File[] archivosEncontrados = c.listFiles();

        // La recorro archivo por archivo / carpeta por carpeta
        for(File f: archivosEncontrados){

            // En caso que sea una carpeta
            if(f.isDirectory()){
                System.out.println("Carpeta: "+f.getName());
                //Al ser una carpeta le digo que profundice y me liste su contenido
                muestraArchivos(f);

            // En caso que sea un archivo
            }else{
                // Solo muestro su nombre
                System.out.println("-"+f.getName());
            }

        }
    }
}
