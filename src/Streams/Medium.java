package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Medium {
    int maxNumber() {
        List<Integer> nums = List.of(3, 7, 1, 9, 4, 6);
        return nums.stream().reduce(Integer::max).orElseThrow();
    }

    List<String> lengthGreaterThree() {
        List<String> words = List.of("hi", "hello", "hey", "hello", "world", "hi", "java");

        return words.stream().filter(s -> s.length() > 3).distinct().sorted().collect(Collectors.toCollection(ArrayList::new));
    }

    public static void main(String[] args) {
        Medium m = new Medium();
        System.out.println("maximum number in list: " + m.maxNumber());
        System.out.println("List of length of word greater than three: " + m.lengthGreaterThree());
    }
}
