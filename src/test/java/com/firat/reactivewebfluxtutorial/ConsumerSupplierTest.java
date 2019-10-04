package com.firat.reactivewebfluxtutorial;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ConsumerSupplierTest {
    Supplier<Double> randomValue;
    @Before
    public void init(){
    }

    @Test
    public void simpleSupplier(){

        // Supplier is a function that only returns a value. Can not take a parameter.
        Supplier<Double> randomValue = Math::random;

        //.get() method is used to return value.
        System.out.println(randomValue.get());
    }

    @Test
    public void simpleConsumer(){

        //Consumers are functions that take a value but not `return` an output although Suppliers.
        Consumer<String> println = System.out::println;

        //Functional way to print something in JVM. accept() method execute the registered method into the consumers.
        println.accept("Hello World");
    }

    @Test
    public void consumerAndThenSample(){

        // square is the function that takes an Integer list to get square of its value.
        Consumer<List<Integer>> square = i -> {
            for (int j = 0; j < i.size(); j++) {
                i.set(j,i.get(j) *2);
            }
        };

        // print is also the consumer function is responsible of representing values on the display
        Consumer<List<Integer>> print = i-> {
            for (int j = 0; j < i.size(); j++) {
                System.out.println(i.get(j));
            }
        };


        ArrayList<Integer> integers = new ArrayList<Integer>(){{add(1);add(2);add(3);add(4);add(5);}};
        square.andThen(print).accept(integers);
        /**
         * Output;
         * 2
         * 4
         * 6
         * 8
         * 10
         */
    }

    @Test
    public void exceptionsAsSupplier(){
        // Exceptions are carried over Suppliers with using Streams in java
        Supplier<NullPointerException> nullPointerException = NullPointerException::new;

        //however we use the nullPointerException in functional way, JVM forces to throw exceptions from the stack frame
        try {
            Optional.of("Hello World")
                    .orElseThrow(nullPointerException);
        }catch (NullPointerException npe){
            npe.printStackTrace();
        }
    }

    @Test
    public void gettingAnActionWithConsumers(){
        Consumer<String> toUpperEverything= (i)->{
            System.out.println(i.toUpperCase());
        };

        Optional.of("Hello World")
                .ifPresent(toUpperEverything);
    }

}
