package ejercicios1_6_accesoAleatorio;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ejercicio61 {

    /* Este código utiliza la función seek que sirve para mover el puntero del archivo
       a la ubicación deseada. En este caso, cada entero ocupa 4 bytes,
       por lo que para leer el entero de la posición número 6 debemos desplazarnos
       20 bytes (4 bytes * 5) y leer los siguientes bytes.
    */
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("random.dat", "rw");

        for (int i = 0; i < 10; i++) {
            raf.writeInt(i);
        }

        raf.seek(4);
        //0-3:   (num=0) 00000000 00000000 00000000 00000000
        //4-7:   (num=1) 00000000 00000000 00000000 00000001
        //8-11:  (num=2) 00000000 00000000 00000000 00000010
        //12-15: (num=3) 00000000 00000000 00000000 00000011
        //16-19: (num=4) 00000000 00000000 00000000 00000100
        //20-23: (num=5) 00000000 00000000 00000000 00000101
        //24-27: (num=6) 00000000 00000000 00000000 00000110
        //28-31: (num=7) 00000000 00000000 00000000 00000111
        //32-35: (num=8) 00000000 00000000 00000000 00001000
        //36-39: (num=9) 00000000 00000000 00000000 00001001

        int sexto = raf.readInt();
        System.out.println("El entero es: " + sexto);

        raf.close();
    }
}
