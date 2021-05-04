//package lesson_eleven;
//
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class Main {
//    public static void main(String[] args) {
//
//        //TASK 1
//        Stream<Integer> empty = Stream.empty();
//        empty.filter(number -> number > 1).distinct().collect(Collectors.toList());
//
//        //TASK 2
//        List<String> stringList = new ArrayList<>();
//        stringList.add("one");
//        stringList.add("two");
//        stringList.add("three");
//        stringList.add("four");
//        stringList.add("five");
//
//        Stream<String> listStream = stringList.stream();
//        listStream.skip(3).sorted().collect(Collectors.toList()).forEach(System.out::println);
//
//        //TASK 3
//        Stream.of("first", "second", "third", "fourth", "fifth").collect(Collectors.toList());
//
//        //TASK4
//        TreeMap<String, Integer> cityPopulationCollection = new TreeMap<>();
//        cityPopulationCollection.put("Kyiv", 2884000);
//        cityPopulationCollection.put("Lviv", 721301);
//        cityPopulationCollection.put("Kharkiv", 1419000);
//
//        Stream.of(cityPopulationCollection.keySet()).collect(Collectors.toList()).forEach(System.out::println);
//
//        //TASK5
//        List<String> stringNumbersList = List.of("0", "1", "3", "4", "5", "6", "7", "8", "9");
//        stringNumbersList
//                .stream()
//                .skip(1)
//                .limit(8)
//                .map(v -> Integer.parseInt(String.valueOf(v)))
//                .filter(number -> number%2 == 0)
//                .distinct()
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
//
//        //TASK6
//        Stream.of("One", "Two", "Three", "Summer", "Winter", "Front-end", "Back-end")
//                .parallel()
//                .filter(val -> val.length() > 3)
//                .findFirst()
//                .stream().collect(Collectors.toList())
//                .forEach(System.out::println);
//
//        //TASK7
//        Random random = new Random(100);
//        Arrays.stream("One, Two, Three, Summer, Winter, Front-end, Back-end"
//        .split("[, ]"))
//                .filter(val -> val.length() > 5)
//                .map(String::length)
//                .map(random::nextInt)
//                .distinct()
//                .sorted()
//                .collect(Collectors.toCollection(ArrayList::new))
//                .forEach(System.out::println);
//    }
//}
