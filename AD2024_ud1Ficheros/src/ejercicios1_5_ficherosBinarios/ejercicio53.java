package ejercicios1_5_ficherosBinarios;

import java.io.*;
import java.util.Scanner;

public class ejercicio53 {
    public static void main(String[] args) throws IOException {

        Persona p1 = new Persona("Sergio", 86, "Cape Town");

        System.out.println("Elige una opción:");
        System.out.println("1. Guardar datos del objeto en fichero");
        System.out.println("2. Cargar y mostrar datos de fichero en objeto");

        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();

        if (opcion == 1){
            System.out.println("Guardando datos");
            DataOutputStream dOutput = new DataOutputStream(new FileOutputStream("persona.dat"));
            dOutput.writeUTF(p1.getNombre());
            dOutput.writeInt(p1.getEdad());
            dOutput.writeUTF(p1.getCiudadNacimiento());
            dOutput.close();
        }else{
            System.out.println("Cargando datos");
            DataInputStream dInput = new DataInputStream(new FileInputStream("nuevapersona.dat"));

            String nombre = dInput.readUTF();
            int edad = dInput.readInt();
            String ciudadNac = dInput.readUTF();

            Persona p2 = new Persona(nombre, edad, ciudadNac);
            System.out.println(p2);
            dInput.close();
        }

    }
}