package Model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class BlockingQuequeEjemplo {
    public static void main(String[] args) {
        BlockingQueue<Integer> queque = new ArrayBlockingQueue<>(5);

        //este es el productor
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("produciendo:" + i);
                    queque.put(i); //Blquea si la cola esta llena

                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        //este es el consumidor

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    Integer item = queque.take();//Bloquea si esta vacia
                    System.out.println("Consumiendo;" + item);
                }
            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });
        producer.start();
        consumer.start();

    }
}