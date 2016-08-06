import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCount {

    public static final String WORD_MATCHER = "\\W+";

    public Map<String, Integer> phrase(String toCount) {
        Pattern wordPattern = Pattern.compile(WORD_MATCHER);
        return wordPattern.splitAsStream(toCount)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue))
                );
    }
}
