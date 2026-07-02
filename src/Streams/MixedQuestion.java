package Streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MixedQuestion {
    long distinctElement() {
        List<Integer> nums = List.of(1, 2, 2, 3, 3, 3, 4);

        return nums.stream().distinct().count();
    }

    double avgLengthOfString() {
        List<String> words = List.of("hi", "hello", "hey", "world");

        return words.stream().collect(Collectors.averagingInt(String::length));
    }

    boolean greaterDigitTen() {
        List<Integer> nums = List.of(1, 2, 3, 15, 4);

        return nums.stream().anyMatch(n -> n > 10);
    }

    List<String> sortByLength() {
        List<String> words = List.of("banana", "hi", "apple", "ok");
        return words.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    Optional<Integer> secondLargest() {
        List<Integer> nums = List.of(3, 7, 1, 9, 4, 6);

        return nums.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
    }

    public static void main(String[] args) {
        MixedQuestion m = new MixedQuestion();

        System.out.println("Distinct Element in list: " + m.distinctElement());
        System.out.println("Average of string length: " + m.avgLengthOfString());
        System.out.println("is thier any digit greater than 10: " + m.greaterDigitTen());
        System.out.println("Sort list as per length: " + m.sortByLength());
        System.out.println("Second Largest Element: "+m.secondLargest());
    }
}
