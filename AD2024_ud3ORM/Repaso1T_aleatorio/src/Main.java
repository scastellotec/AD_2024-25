import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private final static int EMPLEADO_SIZE = 30;

    public static void main(String[] args) throws IOException {


        // 0. Creo el arraylist que almacenará todos los empleados leidos
        ArrayList<Empleado> empleados = new ArrayList<>();

        // 1. Leer CSV
        File archivo = new File("empleados.csv");
        Scanner sc = new Scanner(archivo);

        // Recorro el CSV y almaceno cada empleado en el ArrayList
        while(sc.hasNextLine()){
            String lineaLeida = sc.nextLine();
            String[] datosLeidos = lineaLeida.split(",");
            empleados.add(new Empleado(Integer.parseInt(datosLeidos[0]),datosLeidos[1],Double.parseDouble(datosLeidos[2])));
        }

        // Compruebo que se rellenan todos los empleados correctamente
        empleados.forEach(System.out::println);

        // 2. Crear el archivo de acceso aleatorio
        RandomAccessFile archivoAleatorio = new RandomAccessFile("empleados.random", "rw");

        /* CALCULO EL TAMAÑOA DE CADA EMPLEADO
            - int id = 4 bytes
            - String nombre = char * 9 veces = 2 bytes * 9 = 18 bytes
            - double salario = 8 bytes
            Empleado total = 4 + 18 + 8 = 30 bytes
         */

        // 3. Recorrer el arrayList e insertar cada dato
        for(Empleado e: empleados){
            try {
                archivoAleatorio.seek(e.getId()*30);
                archivoAleatorio.writeInt(e.getId());
                archivoAleatorio.writeChars(e.getNombre());
                archivoAleatorio.writeDouble(e.getSalario());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        /*
            Quiero leer el empleado numero 5.
            Suponiendo que el primero esta en la posicion 0
            y cada empleado ocupa 30 bytes
            Empleado 1: 0
            Empleado 2: 30
            Empleado 3: 60
            ...
        */

        int idDeseado = 14;
        int posicionInidial = idDeseado*EMPLEADO_SIZE;

        // Me posiciona al principio del empleado
        archivoAleatorio.seek(posicionInidial);
        // Leo el primer dato que el int id
        System.out.println(archivoAleatorio.readInt());
        // Avanzo al siguiente dato (posicion inicial + int)
        archivoAleatorio.seek(posicionInidial+4);
        // Leo los 9 caracteres (cada uno ocupa 2 bytes) del nombre
        for(int i=1; i<10; i++){
            System.out.print(archivoAleatorio.readChar());
            archivoAleatorio.seek(posicionInidial+4+(i*2));
        }
        // Creo un salto de linea
        System.out.print("\n");
        // Leo el ultimo dato que es un double
        archivoAleatorio.seek(posicionInidial+4+18);
        System.out.println(archivoAleatorio.readDouble());





    }
}
