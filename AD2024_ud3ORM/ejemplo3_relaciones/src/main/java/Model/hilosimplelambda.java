package Model;

public class hilosimplelambda {

    public static void main(String[] args){
        Thread thread =new Thread(() -> {
            for (int i=1; i<=5;i++) {
                System.out.println("Mensaje del hilo:" + i);
                try {
                    Thread.sleep(100);//Pausa
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            });
         thread.start();
        }
    }


