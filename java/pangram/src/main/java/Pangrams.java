import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Pangrams {

    public static boolean isPangram(String pangram) {
        String lowerCasePangram = pangram.toLowerCase();
        return getLowerCaseAlphabet().allMatch(c -> lowerCasePangram.indexOf(c) > -1);
    }

    private static Stream<Character> getLowerCaseAlphabet(){
        return IntStream.rangeClosed('a','z').mapToObj(i -> (char)i);
    }
}