package ejercicios1_7_serializacion;

import java.io.*;

public class ejercicio71 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // 1. Creo varios alumnos
        Alumno a1 = new Alumno("Sergio",10.0f, 16);
        Alumno a2 = new Alumno("Marisa",9.5f, 17);
        Alumno a3 = new Alumno("Ines",6.2f, 18);
        Alumno a4 = new Alumno("Julian",4.9f, 19);
        Alumno a5 = new Alumno("Ramon",7.8f, 20);

        // 2. Los guardo en un archivo binario
        FileOutputStream fOutput = new FileOutputStream("alumno.dat");
        ObjectOutputStream oOutput = new ObjectOutputStream(fOutput);

        oOutput.writeObject(a1);
        oOutput.writeObject(a2);
        oOutput.writeObject(a3);
        oOutput.writeObject(a4);
        oOutput.writeObject(a5);

        oOutput.close();

        // 3. Los recupero del archivo binario
        ObjectInputStream oInput = new ObjectInputStream(new FileInputStream("alumno.dat"));

        Alumno a101 = (Alumno) oInput.readObject();
        Alumno a102 = (Alumno) oInput.readObject();
        Alumno a103 = (Alumno) oInput.readObject();
        Alumno a104 = (Alumno) oInput.readObject();
        Alumno a105 = (Alumno) oInput.readObject();

        // 4. Muestro su contenido
        System.out.println(a101);
        System.out.println(a102);
        System.out.println(a103);
        System.out.println(a104);
        System.out.println(a105);

        oInput.close();

    }
}
