package ejercicios1_1_File;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ejercicio1_1 {
    public static void main(String[] args) {
        File archivo = new File("usuarios/usuarios.txt");
        if(archivo.exists()) {
            System.out.println("Nombre: "+archivo.getName());
            System.out.println("Longitud: "+archivo.length());
            System.out.println("Ruta absoluta: "+archivo.getAbsolutePath());
        }else
            System.out.println("El archivo no existe");
    }
}