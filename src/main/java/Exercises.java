
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercises {

    public List<String> convertToUpperCase(List<String> input) {
        return input.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public  List<String> retrieveEvenLengthWords(List<String> input) {
        return input.stream()
                .filter(s -> s.length() % 2 == 0)
                .collect(Collectors.toList());
    }

    public int countLinesInFile(Path path) throws IOException {
        return Files.readAllLines(path).size();
    }

    public String joinLineRange(List<String> lines, int start, int end) {
         return lines.stream()
                 .limit(end)
                 .skip(start - 1)
                 .reduce((s,x) -> s + x)
                 .get();
    }

    public int longestLine(Stream<String> lines) {
        return lines.mapToInt(String::length)
                .max()
                .getAsInt();
    }

    public List<String> listOfAllWords(Stream<String> lines, String regex) {
        return lines.map(s -> s.split(regex))
                .flatMap(Arrays::stream)
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toList());
    }


    public List<String> sortedLowerCase(Stream<String> lines, String regex) {
        return lines.map(s -> s.split(regex))
                .flatMap(Arrays::stream)
                .filter(StringUtils::isNotBlank)
                .map(String::toLowerCase)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> sortedLowerCaseDistinctByLengthThenAlphabetically(Stream<String> lines, String regex) {
        return lines.map(s -> s.split(regex))
                .flatMap(Arrays::stream)
                .filter(StringUtils::isNotBlank)
                .map(String::toLowerCase)
                .sorted((o1, o2) -> {
                    if (o1.length() > o2.length()) {
                        return 1;
                    } else if (o1.length() < o2.length()) {
                        return -1;
                    } else {
                        return o1.compareTo(o2);
                    }
                })
                .distinct()
                .collect(Collectors.toList());
    }

    public Map<Integer,List<String>> mapLengthToWordList(Stream<String> lines, String regex) {
        return lines.map(s -> s.split(regex))
                .flatMap(Arrays::stream)
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.groupingBy(
                        String::length,        // use length of string as key
                        TreeMap::new,          // create a TreeMap
                        Collectors.toList()));
    }

    public Map<String,Long> wordFrequencies(Stream<String> lines, String regex) {
        return lines.map(s -> s.split(regex))
                .flatMap(Arrays::stream)
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));
    }

    public Map<String,Integer> wordFrequenciesUsingToMap(Stream<String> lines, String regex) {
        return lines.map(s -> s.split(regex))
                .flatMap(Arrays::stream)
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toMap(
                        w -> w,
                        w -> 1,
                        Integer::sum));
    }

    public Map<String,Map<Integer,List<String>>> nestedMaps(Stream<String> lines, String regex) {
        return lines.map(s -> s.split(regex))
                .flatMap(Arrays::stream)
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.groupingBy(
                        (String s) -> String.valueOf(s.charAt(0)),
                        Collectors.groupingBy(
                                String::length,
                                TreeMap::new,
                                Collectors.toList()
                        )
                ));
    }
}
