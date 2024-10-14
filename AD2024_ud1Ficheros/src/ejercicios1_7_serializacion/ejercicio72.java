package ejercicios1_7_serializacion;

import java.io.*;

public class ejercicio72 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // 1. Creo varios alumnos
        Aula dam2 = new Aula();
        dam2.addAlumno(new Alumno("Sergio",10.0f, 16));
        dam2.addAlumno(new Alumno("Marisa",9.5f, 17));
        dam2.addAlumno(new Alumno("Ines",6.2f, 18));
        dam2.addAlumno(new Alumno("Julian",4.9f, 19));
        dam2.addAlumno(new Alumno("Ramon",7.8f, 20));

        // 2. Los guardo en un archivo binario
        FileOutputStream fOutput = new FileOutputStream("alumno.dat");
        ObjectOutputStream oOutput = new ObjectOutputStream(fOutput);
        oOutput.writeObject(dam2);
        oOutput.close();

        // 3. Los recupero del archivo binario
        ObjectInputStream oInput = new ObjectInputStream(new FileInputStream("alumno.dat"));
        Aula dam2_temp = new Aula();
        dam2_temp = (Aula) oInput.readObject();
        oInput.close();

        // 4. Muestro su contenido
        System.out.println(dam2_temp);

    }
}
