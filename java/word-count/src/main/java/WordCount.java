import java.util.HashMap;
import java.util.Map;

public class WordCount {

    public static final String WORD_MATCHER_PATTERN = "\\W+";

    public Map<String, Integer> phrase(String toCount) {
        Map<String, Integer> countedWords = new HashMap<>();

        String[] splittedString = toCount.split(WORD_MATCHER_PATTERN);

        for (String word : splittedString) {
            String lowerCaseWord = word.toLowerCase();
            countedWords.putIfAbsent(lowerCaseWord, 0);
            countedWords.put(lowerCaseWord, countedWords.get(lowerCaseWord) + 1);
        }
        return  countedWords;
    }
}
