import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Pangrams {

    public static boolean isPangram(String pangram) {
        String lowerCasePangram = pangram.toLowerCase();
        return getLowerCaseAlphabetAsCharStream().allMatch(c -> lowerCasePangram.contains(Character.toString(c)));
    }

    private static Stream<Character> getLowerCaseAlphabetAsCharStream(){
        return IntStream.rangeClosed('a','z').mapToObj(i -> (char)i);
    }
}