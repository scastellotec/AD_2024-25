import java.util.List;

public class StreamsEjemplo {
    public static void main(String[] args){

        List<Integer> numeros = List.of(1, 2, 3, 4);
        numeros.stream()
                .filter(n -> n % 2 == 0)//Pares
                .map(n -> n * n) //Cuadrado
                .forEach(System.out::println);//imprme

    }
}


