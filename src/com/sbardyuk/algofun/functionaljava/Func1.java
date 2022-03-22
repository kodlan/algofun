package com.sbardyuk.algofun.functionaljava;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Func1 {

    public interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }

    public interface NoArgFunction<R> {
        R apply();
    }

    public static int tripple(int x) {
        return x * 3;
    }

    public static void main(String[] args) {
        Function<Integer, Integer> tripleFn = Func1::tripple;

        System.out.println(tripleFn.apply(1));

        Function<Integer, Integer> tripleLambda = x -> x * 3;
        Function<String, Integer> lenLambda = String::length;

        System.out.println(tripleLambda.apply(3));
        System.out.println(lenLambda.apply("this is a test"));

        BiFunction<Integer, Integer, Integer> sum1 = (x, y) -> x + y + 1;
        System.out.println(sum1.apply(1, 1));

        BiFunction<Integer, Integer, Integer> sum = Integer::sum;
        System.out.println(sum.apply(1, 1));

        TriFunction<Integer, Integer, Integer, Integer> triFn = (x, y, z) -> x + y + z;
        System.out.println(triFn.apply(1, 1, 1));

        NoArgFunction<String> helloFn = () -> "Hello";
        System.out.println(helloFn.apply());

    }
}
