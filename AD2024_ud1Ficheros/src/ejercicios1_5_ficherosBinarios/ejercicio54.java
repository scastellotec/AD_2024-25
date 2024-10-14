package ejercicios1_5_ficherosBinarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ejercicio54 {

    public static void main(String[] args) {
        try {
            String nombreArchivoOriginal = "persona.dat";
            String nombreArchivoDuplicado = "nuevapersona.dat";

            FileInputStream fInput = new FileInputStream(nombreArchivoOriginal);
            FileOutputStream fOutput = new FileOutputStream(nombreArchivoDuplicado);

            int dato;
            while((dato = fInput.read()) != -1){
                fOutput.write(dato);
            }

            fInput.close();
            fOutput.close();

            System.out.println("Archivo copiado con exito");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
