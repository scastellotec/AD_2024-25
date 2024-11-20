package leerNumerosMedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.Scanner;

public class LeerNumeros {
    public static void main(String[] args) throws FileNotFoundException {
        // Creo la coleccion donde guardare todos los numeros
        ArrayList<Integer> numeros = new ArrayList();

        // Leer el archivo
        File archivo = new File("numeros.txt");
        Scanner sc = new Scanner(archivo);

        // Guardaria en un array
        while(sc.hasNextLine()){
            String lineaLeida = sc.nextLine();
            numeros.add(Integer.valueOf(lineaLeida));
        }

        // Recorro el array y calculo media
        int sumaTotal = 0;
        for(int i=0; i < numeros.size(); i++){
            sumaTotal += numeros.get(i);
        }

        System.out.println("suma: "+sumaTotal);
        System.out.println("media: "+sumaTotal/ numeros.size());


        // calcularlo con streams
        OptionalDouble media = numeros.stream().mapToInt(Integer::intValue).average();
        System.out.println(media);
    }
}
