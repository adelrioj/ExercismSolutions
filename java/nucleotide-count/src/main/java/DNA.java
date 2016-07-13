import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DNA {

    public static final Map<Character, Integer> DNA_MAP = Collections.unmodifiableMap(
            new HashMap<Character, Integer>(){{
            put('A',0);
            put('C',0);
            put('G',0);
            put('T',0);
        }});

    private String DNA;

    public DNA(String DNA) {
        this.DNA = DNA;
    }

    public Integer count(Character nucleotideToCount) {
        if (isNotValidNucleotide(nucleotideToCount))
            throw new IllegalArgumentException("nucleotideToCount input must be A, C, G or T value");
        long nucleotideCount = DNA.chars().mapToObj(i -> (char) i).filter(c -> c == nucleotideToCount).count();
        return Math.toIntExact(nucleotideCount);
    }

    public Map<Character, Integer> nucleotideCounts() {
        Map<Character, Integer> dnaCounter = newEmptyDnaMap();
        for (char nucleotide : DNA.toCharArray()) {
            dnaCounter.put(nucleotide, dnaCounter.get(nucleotide) + 1);
        }
        return dnaCounter;
    }

    private boolean isNotValidNucleotide(Character nucleotide) {
        return !DNA_MAP.containsKey(nucleotide);
    }

    private Map<Character, Integer> newEmptyDnaMap() {
        return new HashMap<>(DNA_MAP);
    }
}
