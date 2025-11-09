package org.pm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface  Person{
    int add(int x , int y);
};

@FunctionalInterface
interface Calculators{
    int opeartor(int a , int b);
}


public class LambdaExpression {
    public static void main(String[] args) {
//        Calculators add = (a , b) -> a + b;
//        Calculators sub = (a, b)-> a - b;
//        Calculators multiply = (a, b)-> a * b;
//        Calculators division = (a, b)-> a / b;
//
//        System.out.println(add.opeartor(2,10));
//        System.out.println(sub.opeartor(2,10));
//        System.out.println(multiply.opeartor(2,10));
//        System.out.println(division.opeartor(2,10));


        Predicate<Integer> isEven = n -> n % 2 ==0;
        System.out.println(isEven.test(10));

        Function<Integer , Integer> square  = n -> n*n;
        System.out.println(square.apply(10));

        Consumer<String> ans = System.out::println;
        ans.accept("venky");

        Supplier<LocalDateTime> localDateTimeSupplier = LocalDateTime::now;
        System.out.println(localDateTimeSupplier.get());
    }
}
