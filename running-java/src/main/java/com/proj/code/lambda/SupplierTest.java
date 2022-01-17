package com.proj.code.lambda;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 供给型接口
 */
public class SupplierTest {
    public static void main(String[] args) {
        // generate 生产
        Stream.generate(new Supplier<Double>() {
            @Override
            public Double get() {
                return null;
            }
        });
        Stream<Double> stream = Stream.generate(Math::random);
        stream.forEach(System.out::println);
    }
}
