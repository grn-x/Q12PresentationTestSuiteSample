package de.grnx.utils;


import java.util.List;

public class MathUtils {
    /**
     * Pre-refactor: counts actual words using regex to split on whitespace
     */
    public static int countWordsPre(String input) {
        if (input == null || input.trim().isEmpty()) return 0;
        return input.trim().split("\\s+") .length;
    }

    /**
     * Post-refactor: splits only on single spaces
     */
    public static int countWordsPost(String input) {
        if (input == null || input.trim().isEmpty()) return 0;
        return input.trim().split(" ").length;
    }

        /*public static int sumPositivePre(List<Integer> numbers) {
        int sum = 0;
        for (int n : numbers) {
            if (n > 0) {
                sum += n;
            }
        }
        return sum;
    }


    public static int sumPositivePost(List<Integer> numbers) {
        //bug; includes zero in sum (>= 0 instead of > 0)
        return numbers.stream()
                .filter(n -> n >= 0)
                .mapToInt(Integer::intValue)
                .sum();
    }*/

}

