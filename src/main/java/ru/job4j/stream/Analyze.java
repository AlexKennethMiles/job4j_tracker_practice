package ru.job4j.stream;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(p -> Stream.of(p.getSubjects()))
                .flatMap(Collection::stream)
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(s -> new Tuple(
                s.getName(),
                s.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .average()
                        .orElse(0)))
                .collect(toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(p -> Stream.of(p.getSubjects()))
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(sub -> new Tuple(sub.getKey(), sub.getValue()))
                .collect(toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(s -> new Tuple(
                s.getName(),
                s.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(new Tuple("Error", 0));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(p -> Stream.of(p.getSubjects()))
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(sub -> new Tuple(sub.getKey(), sub.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(new Tuple("Error", 0));
    }
}
