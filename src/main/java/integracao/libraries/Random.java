package integracao.libraries;

import java.util.ArrayList;
import java.util.List;

public class Random {

    public static int getRandomInteger(int min, int max) {
        return min + (int) (Math.random() * max);
    }

    public static List<Integer> getRandomIntegers(int min, int max, int size) {
        List<Integer> numbers = new ArrayList<>();
        while (size > 0) {
            int number = getRandomInteger(min, max);
            if (!numbers.contains(number)) {
                numbers.add(number);
                size--;
            }
        }
        return numbers;
    }
}
