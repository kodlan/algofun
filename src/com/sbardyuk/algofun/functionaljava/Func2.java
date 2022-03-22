package com.sbardyuk.algofun.functionaljava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Func2 {

    public static void main(String[] args) {
        BiFunction<Float, Float, Float> div = (x, y) -> x / y;

        Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>> argCheckFunc =
                (func) -> (x, y) -> {
                    if (y == 0f) {
                        System.out.println("Error can't divide by 0");
                        return 0f;
                    }
                    return func.apply(x, y);
                };

        BiFunction<Float, Float, Float> divideSafe = argCheckFunc.apply(div);

        System.out.println(divideSafe.apply(1f, 0f));
        System.out.println(divideSafe.apply(10f, 2f));

        // String len test
        String [] strings = { "Hello", "this", "is", "a", "test" };
        List<String> stringList = new ArrayList<>(Arrays.asList(strings));

        Function<Integer, Predicate<String>> createLengthTest =
                (Integer maxLen) -> (String str) -> str.length() > maxLen;

        Predicate<String> test1Chars = createLengthTest.apply(1);
        Predicate<String> test2Chars = createLengthTest.apply(2);

        String str1 = stringList.stream()
                .filter(test1Chars)
                .collect(Collectors.joining(" "));

        String str2 = stringList.stream()
                .filter(test2Chars)
                .collect(Collectors.joining(" "));

        System.out.println(str1);
        System.out.println(str2);
    }
}
