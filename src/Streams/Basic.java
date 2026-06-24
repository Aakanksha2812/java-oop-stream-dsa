package Streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Basic {

    ArrayList<Integer> evenNumber() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        nums = nums.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        return (ArrayList<Integer>) nums;
    }

    ArrayList<String> convertToUppercase() {
        List<String> names = List.of("alice", "bob", "charlie", "diana");
        return names.stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));
    }

    int sumGreaterDigitThree() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        return nums.stream().filter(n -> n > 3).reduce(0, Integer::sum);
    }

    ArrayList<String> nameWithA() {
        List<String> names = List.of("Alice", "Bob", "andrew", "Charlie", "anna");
        return names.stream().filter(s -> s.toUpperCase().startsWith("A")).collect(Collectors.toCollection(ArrayList::new));
    }

    ArrayList<Integer> squareOfGreaterDigitTwo() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        return nums.stream().filter(n -> n > 2).map(n -> n * n).collect(Collectors.toCollection(ArrayList::new));
    }

    Map<Integer, List<String>> sameWordLength() {
        List<String> words = List.of("hi", "hello", "hey", "world", "ok");
        return words.stream().collect(Collectors.groupingBy(String::length));
    }

    Map<Character, Long> sameCharacterCount() {
        List<String> names = List.of("Alice", "Bob", "Anna", "Charlie", "Ben", "Amy");

        return names.stream().collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.counting()));
    }

    List<Integer> singleList() {
        List<List<Integer>> nested = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 8, 9)
        );
        return nested.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    String joinByComma() {
        List<String> words = List.of("apple", "banana", "cherry", "date");
        return words.stream().collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        Basic b = new Basic();
        b.evenNumber();
        System.out.println("even number from list are " + b.evenNumber());
        System.out.println("String of list converted to uppercase " + b.convertToUppercase());
        System.out.println("sum of digit greater than 3 " + b.sumGreaterDigitThree());
        System.out.println("List of names who start with A " + b.nameWithA());
        System.out.println("List of square of digit greater than two " + b.squareOfGreaterDigitTwo());
        System.out.println("group by same length: " + b.sameWordLength());
        System.out.println("Count Same intial character: " + b.sameCharacterCount());
        System.out.println("convert nested list to flat list: " + b.singleList());
        System.out.println("join by comma: "+b.joinByComma());
    }
}
