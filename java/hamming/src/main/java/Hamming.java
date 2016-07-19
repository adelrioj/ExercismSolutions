import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Hamming {

    public static int compute(String strand1, String strand2) {
        if (strand1.length() != strand2.length())
            throw new IllegalArgumentException();

        long differences = IntStream.range(0, strand1.length())
                .filter(compareNucleotidesByPosition(strand1, strand2))
                .count();

        return (int) differences;
    }

    private static IntPredicate compareNucleotidesByPosition(String strand1, String strand2) {
        return i -> strand1.charAt(i) != strand2.charAt(i);
    }
}
