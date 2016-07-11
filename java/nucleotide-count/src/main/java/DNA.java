import java.util.HashMap;
import java.util.Map;

public class DNA {

    private String DNA;

    public DNA(String DNA) {
        this.DNA = DNA;
    }

    public Integer count(Character nucleotideToCount) {
        if (isNotValidNucleotide(nucleotideToCount))
            throw new IllegalArgumentException("nucleotideToCount input must be A, C, G or T values");

        int counter = 0;
        for (char nucleotideFound : DNA.toCharArray()) {
            if (nucleotideFound == nucleotideToCount)
                counter++;
        }
        return counter;
    }

    private boolean isNotValidNucleotide(Character nucleotideToCount) {
        return !newEmptyDnaMap().containsKey(nucleotideToCount);
    }

    public Map<Character, Integer> nucleotideCounts() {
        Map<Character, Integer> dnaCounter = newEmptyDnaMap();
        for (char nucleotide : DNA.toCharArray()) {
            dnaCounter.put(nucleotide, dnaCounter.get(nucleotide) + 1);
        }
        return dnaCounter;
    }

    private Map<Character, Integer> newEmptyDnaMap() {
        Map<Character, Integer> dnaMap = new HashMap<>();
        dnaMap.put('A',0);
        dnaMap.put('C',0);
        dnaMap.put('G',0);
        dnaMap.put('T',0);
        return dnaMap;
    }
}
