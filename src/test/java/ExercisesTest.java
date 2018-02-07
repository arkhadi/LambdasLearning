import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ExercisesTest {

   private Exercises classToTest;

    static List<String> wordList = Arrays.asList(
            "every", "problem", "in", "computer", "science",
            "can", "be", "solved", "by", "adding", "another",
            "level", "of", "indirection");

    static final String REGEXP = "\\W+"; // for splitting into words

    private BufferedReader reader;

    @Before
    public void setUpBufferedReader() throws IOException, URISyntaxException {
        classToTest = new Exercises();
        reader = Files.newBufferedReader(Paths.get(getClass().getResource("/testFile.txt").toURI()), StandardCharsets.UTF_8);
    }

    @After
    public void closeBufferedReader() throws IOException {
        reader.close();
    }

// Exercise: Convert all words in wordList to upper case,
// and gather the result into an output list.

    @Test
    public void upperCaseWords() {
        //Given
        //When
        List<String> result = null; /* TODO */

        //Then
        assertThat(result, is(Arrays.asList(
                "EVERY", "PROBLEM", "IN", "COMPUTER", "SCIENCE",
                "CAN", "BE", "SOLVED", "BY", "ADDING", "ANOTHER",
                "LEVEL", "OF", "INDIRECTION")));
    }

// Exercise: Find all the words in wordList that have even length
// and put them into an output list.

    @Test
    public void findEvenLengthWords() {
        //Given
        //When
        List<String> result =null;

        //Then
        assertThat(result, is(Arrays.asList("in", "computer", "be", "solved", "by", "adding", "of")));
    }

// Exercise: Count the number of lines in a file. The field *reader*
// is a BufferedReader which will be opened for you on the text file.
// See the JUnit @Before and @After methods at the top of this file.
// The text file is "testFile.txt" (Shakespeare's first sonnet) which is
// located at the resources folder.

    @Test
    public void countLinesInFile() throws IOException {
        //Given
        //When
        int result = 0;

        //Then
        assertThat(result, is(14));
    }

// Exercise: Join lines 3-4 from the text file into a single string.

    @Test
    public void joinLineRange() throws IOException {
        //Given
        //When
        String result = null; /* TODO */

        //Then
        assertThat(result, is(
                "But as the riper should by time decease," +
                        "His tender heir might bear his memory:"));
    }

// Exercise: Find the length of the longest line in the file.

    @Test
    public void lengthOfLongestLine() throws IOException {
        //Given
        //When
        int result = 0; /* TODO */
        
        //Then
        assertThat(result, is(53));
    }

// Exercise: Collect all the words from the text file into a list.
// Hint: use String.split(REGEXP) to split a string into words.
// Splitting this way results in "words" that are the empty string,
// which should be discarded. REGEXP is defined at the bottom of this file.

    @Test
    public void listOfAllWords() throws IOException {
        //Given
        //When
        List<String> result = null; /* TODO */

        //Then
        assertThat(result, is(Arrays.asList(
                        "From", "fairest", "creatures", "we", "desire", "increase",
                        "That", "thereby", "beauty", "s", "rose", "might", "never", "die",
                        "But", "as", "the", "riper", "should", "by", "time", "decease",
                        "His", "tender", "heir", "might", "bear", "his", "memory", "But",
                        "thou", "contracted", "to", "thine", "own", "bright", "eyes",
                        "Feed", "st", "thy", "light", "s", "flame", "with", "self",
                        "substantial", "fuel", "Making", "a", "famine", "where",
                        "abundance", "lies", "Thy", "self", "thy", "foe", "to", "thy",
                        "sweet", "self", "too", "cruel", "Thou", "that", "art", "now",
                        "the", "world", "s", "fresh", "ornament", "And", "only", "herald",
                        "to", "the", "gaudy", "spring", "Within", "thine", "own", "bud",
                        "buriest", "thy", "content", "And", "tender", "churl", "mak",
                        "st", "waste", "in", "niggarding", "Pity", "the", "world", "or",
                        "else", "this", "glutton", "be", "To", "eat", "the", "world", "s",
                        "due", "by", "the", "grave", "and", "thee")));
    }

// Exercise: Create a list containing the words, lowercased, in alphabetical order.

    @Test
    public void sortedLowerCase() throws IOException {
        //Given
        //When
        List<String> result = null; /* TODO */
        
        //Then
        assertThat(result, is(Arrays.asList(
                        "a", "abundance", "and", "and", "and", "art", "as", "be",
                        "bear", "beauty", "bright", "bud", "buriest", "but", "but",
                        "by", "by", "churl", "content", "contracted", "creatures",
                        "cruel", "decease", "desire", "die", "due", "eat", "else",
                        "eyes", "fairest", "famine", "feed", "flame", "foe", "fresh",
                        "from", "fuel", "gaudy", "glutton", "grave", "heir", "herald",
                        "his", "his", "in", "increase", "lies", "light", "mak",
                        "making", "memory", "might", "might", "never", "niggarding",
                        "now", "only", "or", "ornament", "own", "own", "pity",
                        "riper", "rose", "s", "s", "s", "s", "self", "self", "self",
                        "should", "spring", "st", "st", "substantial", "sweet",
                        "tender", "tender", "that", "that", "the", "the", "the",
                        "the", "the", "the", "thee", "thereby", "thine", "thine",
                        "this", "thou", "thou", "thy", "thy", "thy", "thy", "thy",
                        "time", "to", "to", "to", "to", "too", "waste", "we", "where",
                        "with", "within", "world", "world", "world")));
    }

// Exercise: Sort unique, lower-cased words by length, then alphabetically
// within length, and place the result into an output list.

    @Test
    public void sortedLowerCaseDistinctByLengthThenAlphabetically() throws IOException {
        //Given
        //When
        List<String> result = null; /* TODO */
        
        //Then
        assertThat(result, is(Arrays.asList(
                        "a", "s", "as", "be", "by", "in", "or", "st", "to", "we",
                        "and", "art", "bud", "but", "die", "due", "eat", "foe", "his",
                        "mak", "now", "own", "the", "thy", "too", "bear", "else",
                        "eyes", "feed", "from", "fuel", "heir", "lies", "only",
                        "pity", "rose", "self", "that", "thee", "this", "thou",
                        "time", "with", "churl", "cruel", "flame", "fresh", "gaudy",
                        "grave", "light", "might", "never", "riper", "sweet", "thine",
                        "waste", "where", "world", "beauty", "bright", "desire",
                        "famine", "herald", "making", "memory", "should", "spring",
                        "tender", "within", "buriest", "content", "decease",
                        "fairest", "glutton", "thereby", "increase", "ornament",
                        "abundance", "creatures", "contracted", "niggarding",
                        "substantial")));
    }

// Exercise: Categorize the words into a map, where the map's key is
// the length of each word, and the value corresponding to a key is a
// list of words of that length. Don't bother with uniqueness or lower-
// casing the words.

    @Test
    public void mapLengthToWordList() throws IOException {
        //Given
        //When
        Map<Integer, List<String>> map = null; /* TODO */
        
        //Then
        assertThat(map.get(7).size(), is(6));
        assertThat(map.get(8), is(Arrays.asList("increase", "ornament")));
        assertThat(map.get(9), is(Arrays.asList("creatures", "abundance")));
        assertThat(map.get(10), is(Arrays.asList("contracted", "niggarding")));
        assertThat(map.get(11), is(Arrays.asList("substantial")));
        assertThat(map.containsKey(12), is(true));
    }

// Exercise: Gather the words into a map, accumulating a count of the
// number of occurrences of each word. Don't worry about upper case and
// lower case. Extra challenge: implement two solutions, one that uses
// groupingBy() and the other that uses toMap().

    @Test
    public void wordFrequencies() throws IOException {
        //Given
        //When
        Map<String, Long> map = null; /* TODO */
        
        //Then
        assertThat((long)map.get("tender"), is(2L));
        assertThat((long)map.get("the"), is(6L));
        assertThat((long)map.get("churl"), is(1L));
        assertThat((long)map.get("thine"), is(2L));
        assertThat((long)map.get("world"), is(3L));
        assertThat(map.containsKey("lambda"), is(false));
    }

// Exercise: Create nested maps, where the outer map is a map from the
// first letter of the word to an inner map. (Use a string of length one
// as the key.) The inner map, in turn, is a mapping from the length of the
// word to a list of words with that length. Don't bother with any lowercasing
// or uniquifying of the words.
//
// For example, given the words "foo bar baz bazz" the string
// representation of the result would be:
//     {f={3=[foo]}, b={3=[bar, baz], 4=[bazz]}}.

    @Test
   
    public void nestedMaps() throws IOException {
        //Given
        //When
        Map<String, Map<Integer, List<String>>> map = null; /* TODO */
        
        //Then
        assertThat(map.get("F").get(4).toString(), is("[From, Feed]") );
        assertThat(map.get("b").get(2).toString(), is("[by, be, by]"));
        assertThat(map.get("t").get(3).toString(), is("[the, thy, thy, thy, too, the, the, thy, the, the, the]"));
        assertThat(map.get("b").get(6).toString(), is("[beauty, bright]"));
    }
}