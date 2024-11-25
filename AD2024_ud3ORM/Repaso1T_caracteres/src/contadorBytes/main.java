package contadorBytes;

import java.io.*;

public class main {
    public static void main(String[] args) throws IOException {
        // Crear un archivo binario para poder trabajar con el
        FileOutputStream fOutput = new FileOutputStream("ejemplo0.dat");
        DataOutputStream dOutput = new DataOutputStream(fOutput);

        for(int i=0; i<10; i++){
            dOutput.writeUTF("a"+i);
        }

        // Recorrer ese archivo binario byte a byte y mostrarlos
        FileInputStream fInput = new FileInputStream("ejemplo0.dat");

        int dato;
        int contador = 0;
        while((dato = fInput.read())!=-1){
            System.out.println(dato);
            contador++;
        }

        // Mostramos cuando bytes tiene en total
        System.out.println("Hemos contado: "+contador+" bytes");


        // Cerramos los recursos abiertos
        fInput.close();
        dOutput.close();
        fOutput.close();

    }
}
