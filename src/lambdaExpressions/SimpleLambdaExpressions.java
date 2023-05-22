package lambdaExpressions;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SimpleLambdaExpressions {
    public static void main(String[] args) {
        int a = 8;
        int b = 3;

        // Addition
        Operations addition = (x, y) -> x + y;
        System.out.println("Addition: " + addition.perform(a, b)); // Output: 11

        // Subtraction
        Operations subtraction = (x, y) -> x - y;
        System.out.println("Subtraction: " + subtraction.perform(a, b)); // Output: 5

        // Multiplication
        Operations multiplication = (x, y) -> x * y;
        System.out.println("Multiplication: " + multiplication.perform(a, b)); // Output: 24

        // Division
        Operations division = (x, y) -> x / y;
        System.out.println("Division: " + division.perform(a, b)); // Output: 2

        // Custom functional interfaces
        HelloFunction helloFunction = message -> System.out.println("Hello, " + message);
        GoodbyeFunction goodbyeFunction = message -> System.out.println(message + " Thanks for coming!");
        NumberEvaluator isEven = num -> num % 2 == 0; // Lambda expression to check if a number is even

        // Using lambda expressions
        helloFunction.greet("John");
        goodbyeFunction.goodbye("See you next time!");
        System.out.println("The # is even? " + isEven.evaluate(4));

        //Predicate checks if number is odd
        Predicate<Integer> isOdd = num -> num % 2 !=0;
        System.out.println("Is the number odd? " + isOdd.test(12));

        //Function converts string to uppercase
        Function<String, String> toUpperCase = str -> str.toUpperCase();
        System.out.println("Uppercase: " + toUpperCase.apply("north carolina"));

        //Consumer prints elements of array
        Consumer<String[]> printArray = arr -> {
            for ( String name : arr) {
                System.out.println(name + " ");
            }
        };
        String[] names = {"John", "Jane", "Jim", "Jacob"};
        System.out.println("Array: "); printArray.accept(names);

        //Supplier generates random number
        Supplier<Integer> randomNumber = () -> (int) (Math.random() * 1000);
        System.out.println("Random number: " + randomNumber.get());

    }

    @FunctionalInterface
    interface Operations {
        int perform(int a, int b);
    }

    @FunctionalInterface
    interface HelloFunction {
        void greet(String message);
    }

    @FunctionalInterface
    interface GoodbyeFunction {
        void goodbye(String message);
    }

    @FunctionalInterface
    interface NumberEvaluator {
        boolean evaluate(int num);
    }
}
