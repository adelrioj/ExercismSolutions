import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Anagram {

    public static final int CHARS_IN_ALPHABET = 26; //26 == chars in english alphabet
    private String word;

    public Anagram(String word) {
        this.word = word;
    }

    public List<String> match(List<String> anagrams) {
        return anagrams.stream()
                .filter(isAnagram)
                .collect(Collectors.toList());
    }

    private Predicate<String> isAnagram = possibleAnagram -> {
        if (hasDifferentLenght(possibleAnagram))
            return false;
        if (isSameWord(possibleAnagram))
            return false;

        char[] wordCharArray = word.toLowerCase().toCharArray();
        char[] possibleAnagramCharArray = possibleAnagram.toLowerCase().toCharArray();
        int[] counts = new int[CHARS_IN_ALPHABET];
        for (int i = 0; i < wordCharArray.length; i++){
            counts[wordCharArray[i]-97]++;
            counts[possibleAnagramCharArray[i]-97]--;
        }

        return Arrays.stream(counts).sum() == 0;
    };

    private boolean isSameWord(String possibleAnagram) {
        return word.equalsIgnoreCase(possibleAnagram);
    }

    private boolean hasDifferentLenght(String possibleAnagram) {
        return word.length() != possibleAnagram.length();
    }
}
