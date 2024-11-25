package ejercicios1_5_ficherosBinarios;

import java.io.*;

public class ejercicio52 {
    public static void main(String[] args) throws IOException {
        // Creo los streams para escribir en el fichero
        FileOutputStream fOutput = new FileOutputStream("ejemplo0.dat");
        DataOutputStream dOutput = new DataOutputStream(fOutput);

        dOutput.writeBoolean(true);
        dOutput.writeInt(17);
        dOutput.writeUTF("AccesoDatos");
        dOutput.writeFloat(10.5f);

        dOutput.close();
        fOutput.close();

        // Creo streams para leer el fichero
        DataInputStream dInput = new DataInputStream(new FileInputStream("ejemplo0.dat"));

        System.out.println("Booleano: "+dInput.readBoolean());
        System.out.println("Int: "+dInput.readInt());
        System.out.println("String: "+dInput.readUTF());
        System.out.println("Float: "+dInput.readFloat());

        dInput.close();
    }
}
