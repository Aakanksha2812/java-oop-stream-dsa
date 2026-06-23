package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Basic {

    ArrayList<Integer> evenNumber() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        nums = nums.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        return (ArrayList<Integer>) nums;
    }

    ArrayList<String> convertToUppercase() {
        List<String> names = List.of("alice", "bob", "charlie", "diana");
        return names.stream().map(s -> s.toUpperCase()).collect(Collectors.toCollection(ArrayList::new));
    }

    public static void main(String[] args) {
        Basic b = new Basic();
        b.evenNumber();
        System.out.println(b.evenNumber());
        System.out.println(b.convertToUppercase());
    }
}
