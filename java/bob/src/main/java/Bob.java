import java.util.stream.Stream;

public class Bob {

    public static final String QUESTION_RESPONSE = "Sure.";

    public static final String YELL_RESPONSE = "Whoa, chill out!";

    public static final String EMPTY_ADDRESS_RESPONSE = "Fine. Be that way!";

    public static final String OTHER_RESPONSE = "Whatever.";

    public String hey(String sentence) {
        String normalizedSentence = normalize(sentence);
        if (isEmptyAddress(normalizedSentence))
            return EMPTY_ADDRESS_RESPONSE;
        else if (isYell(normalizedSentence))
            return YELL_RESPONSE;
        else if (isQuestion(normalizedSentence))
            return QUESTION_RESPONSE;
        else return OTHER_RESPONSE;
    }

    private String normalize(String sentence) {
        return org.apache.commons.lang3.StringEscapeUtils.unescapeJava(sentence);
    }

    private boolean isYell(String sentence) {

        long lettersCount = streamSentence(sentence)
                .filter(Character::isLetter)
                .count();
        long lowerCaseCount = streamSentence(sentence)
                .filter(Character::isLowerCase)
                .count();
        return lettersCount > 0 && lowerCaseCount == 0;
    }

    private Stream<Character> streamSentence(String sentence) {
        return sentence.chars().mapToObj(i -> (char) i);
    }

    private boolean isQuestion(String sentence) {
        return ((sentence.charAt(sentence.length()-1) == '?'));
    }

    private boolean isEmptyAddress(String sentence) {
        return sentence.trim().isEmpty();
    }


}
