package palabraMasLarga;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        //1. Leer el archivo con el stream que quieras
        BufferedReader leerBuffer = new BufferedReader(new FileReader("palabraLarga.txt"));
        Scanner sc = new Scanner(leerBuffer);

        // Metodo 1: Sencillo y correcto
        /*String palabra;
        String maxPalabra = "";
        while(sc.hasNext()){
            palabra = sc.next();
            if(palabra.length()>maxPalabra.length()){
                maxPalabra = palabra;
            }
        }
        System.out.println("Metodo1: "+maxPalabra);*/


        // Metodo 2: Usamos un array
        /*ArrayList<String> palabras = new ArrayList<>();
        while(sc.hasNext()){
            palabras.add(sc.next());
        }
        String resultado = String.valueOf(palabras.stream().max(Comparator.comparing(String::length)));
        System.out.println(resultado);*/

        // Metodo 3: Usamos un HashMap
        /*TreeMap<Integer, String> palabrasSize = new TreeMap<Integer, String>();
        while(sc.hasNext()){
            String palabra2 = sc.next();
            palabrasSize.put(Integer.valueOf(palabra2.length()),palabra2);
        }
        System.out.println(palabrasSize.lastEntry().getValue());*/




    }
}
