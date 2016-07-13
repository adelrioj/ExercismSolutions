import java.util.function.Predicate;
import java.util.stream.Stream;

public class Pangrams {

    public static final int ALPHABET_CHAR_COUNT = 26;

    public static boolean isPangram(String pangram) {
        Predicate<Character> matchAlphabetChars = c -> c.toString().matches("[a-zA-Z]");

        String lowerCasePangram = pangram.toLowerCase();
        Stream<Character> pangramAsCharStream = lowerCasePangram.chars().mapToObj(i -> (char) i);
        return pangramAsCharStream.filter(matchAlphabetChars).distinct().count() == ALPHABET_CHAR_COUNT;
    }
}