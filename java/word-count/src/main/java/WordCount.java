import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCount {

    private static final Pattern wordMatcherPattern = Pattern.compile("\\W+");

    public Map<String, Integer> phrase(String toCount) {
        return wordMatcherPattern.splitAsStream(toCount)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue))
                );
    }
}
