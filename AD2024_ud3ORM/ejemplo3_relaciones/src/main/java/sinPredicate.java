import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sinPredicate {
public static void main(String[] args){
    //lista numeros
    List<Integer> numbers = Arrays.asList(5,15,25,8);

    //Para almacenar
    List <Integer> filteredNumbers =new ArrayList<>();

    //Filtrar
    for(Integer num: numbers){
     if (mayorDiez(num)){
         filteredNumbers.add(num);
     }
    }
     //Imprime
    for (Integer num: filteredNumbers){
        System.out.println(num); // imprime 15 y 25

    }
}

//metodo mayorDiez
    public static boolean mayorDiez(Integer num){
        return num>10;
    }
}
