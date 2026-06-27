package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class Hard {
    Map<String, String> highestPaidEmp() {
        record Employee(String name, String department, int salary) {
        }

        List<Employee> employees = List.of(
                new Employee("Alice", "Engineering", 90000),
                new Employee("Bob", "HR", 60000),
                new Employee("Charlie", "Engineering", 95000),
                new Employee("Diana", "HR", 65000),
                new Employee("Eve", "Engineering", 85000)
        );
        return employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Employee::salary)), opt -> opt.get().name())));
    }

    Optional<String> LongestString() {
        List<String> words = List.of("hi", "hello", "hey", "world", "java");
        return words.stream().collect(Collectors.maxBy(Comparator.comparingInt(String::length)));
    }

    Optional<String> LongestString2() {
        List<String> words = List.of("hi", "hello", "hey", "world", "java");
        return words.stream().reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
    }

    Map<Boolean, List<Integer>> partitionByOddEven() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        return nums.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
    }

    Map<String, Integer> wordAndLength() {
        List<String> words = List.of("apple", "banana", "cherry", "date");
        return words.stream().collect(Collectors.toMap(s -> s, s -> s.length()));
    }

    Map<String, Double> deptAvgSalary() {
        record Employee(String name, String department, int salary) {
        }

        List<Employee> employees = List.of(
                new Employee("Alice", "Engineering", 90000),
                new Employee("Bob", "HR", 60000),
                new Employee("Charlie", "Engineering", 95000),
                new Employee("Diana", "HR", 65000),
                new Employee("Eve", "Engineering", 85000)
        );
// Output: {Engineering=90000.0, HR=62500.0}
        return employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors.averagingInt(Employee::salary)));
    }

    public static void main(String[] args) {
        Hard h = new Hard();
        System.out.println("Highest paid employee in depteratment: " + h.highestPaidEmp());
        System.out.println("Longest string: " + h.LongestString());
        System.out.println("Longest string approach two: " + h.LongestString2());
        System.out.println("partition on the basis of Even and Odd: " + h.partitionByOddEven());
        System.out.println("word and their length: " + h.wordAndLength());
        System.out.println("Average salary by department: " + h.deptAvgSalary());
    }
}
