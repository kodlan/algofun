package com.sbardyuk.algofun.functionaljava;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FuncPartial {

    public static void main(String[] args) {

        Func1.TriFunction<Integer, Integer, Integer, Integer> add = (x, y, z) -> x + y + z;

        Function<Integer, BiFunction<Integer, Integer, Integer>> addPartial = (x) -> (y, z) -> add.apply(x, y, z);

        BiFunction<Integer, Integer, Integer> add5 = addPartial.apply(5);

        System.out.println(add5.apply(6, 7));

    }
}
