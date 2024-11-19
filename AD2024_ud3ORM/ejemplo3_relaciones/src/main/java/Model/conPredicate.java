package Model;

import java.util.function.Predicate;

public class conPredicate {
    public static void main (String[] args){
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(4));//True
        System.out.println(isEven.test(7));//False

    }
}
