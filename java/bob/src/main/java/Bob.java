public class Bob {

    public static final String QUESTION_RESPONSE = "Sure.";

    public static final String YELL_RESPONSE = "Whoa, chill out!";

    public static final String EMPTY_ADDRESS_RESPONSE = "Fine. Be that way!";

    public static final String OTHER_RESPONSE = "Whatever.";

    public String hey(String sentence) {
        if (isEmptyAddress(sentence))
            return EMPTY_ADDRESS_RESPONSE;
        if (isYell(sentence))
            return YELL_RESPONSE;
        if (isQuestion(sentence))
            return QUESTION_RESPONSE;
        return OTHER_RESPONSE;
    }

    private boolean isYell(String sentence) {
        return sentence.chars().filter(i -> i>=97 && i<=122).count() == 0;
    }

    private boolean isQuestion(String sentence) {
        return ((sentence.charAt(sentence.length()-1) == '?'));
    }

    private boolean isEmptyAddress(String sentence) {
        return sentence.isEmpty();
    }
}
