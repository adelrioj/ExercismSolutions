import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etl {

    public Map<String, Integer> transform(Map<Integer, List<String>> old) {

        old.entrySet().stream().flatMap(entry -> entry)


        Map<String, Integer> newLetterMap = new HashMap<>();
        for (Map.Entry<Integer, List<String>> letterEntry : old.entrySet()) {
            for (String letterToProcess : letterEntry.getValue()) {
                newLetterMap.put(letterToProcess.toLowerCase(), letterEntry.getKey());
            }
        }
        return newLetterMap;
    }
}
