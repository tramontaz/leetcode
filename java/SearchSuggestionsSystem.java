import java.util.*;

import static java.lang.String.format;

public class SearchSuggestionsSystem {
    private static Solution SOLUTION = new Solution();
    public static void main(String[] args) {

        String[] prod1 = {"mobile","mouse","moneypot","monitor","mousepad"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("mobile","moneypot","monitor"),
                Arrays.asList("mobile","moneypot","monitor"),
                Arrays.asList("mouse","mousepad"),
                Arrays.asList("mouse","mousepad"),
                Arrays.asList("mouse","mousepad")
        );
        test(prod1, "mouse", expected);

        String[] prod2 = {"havana"};
        List<List<String>> expected2 = Arrays.asList(
                Arrays.asList("havana"),
                Arrays.asList("havana"),
                Arrays.asList("havana"),
                Arrays.asList("havana"),
                Arrays.asList("havana"),
                Arrays.asList("havana")
        );
        test(prod2, "havana", expected2);

        String[] prod3 = {"bags","baggage","banner","box","cloths"};
        List<List<String>> expected3 = Arrays.asList(
                Arrays.asList("baggage","bags","banner"),
                Arrays.asList("baggage","bags","banner"),
                Arrays.asList("baggage","bags"),
                Arrays.asList("bags")
        );
        test(prod3, "bags", expected3);

    }

    private static void test(String[] products, String searchWord, List<List<String>> expected)  {
        var result = SOLUTION.suggestedProducts(products, searchWord);
        if (!expected.toString().contentEquals(result.toString())) {
            throw new IllegalStateException(format("Test failed. Expected: %s but result is %s", expected.toString(), result.toString()));
        }
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        final Map<String, List<String>> dictionary = new HashMap<>();
        Arrays.sort(products);

        for (String product : products) {
            for (int j = 0; j < product.length() && j < searchWord.length(); j++) {
                String key = product.substring(0, j + 1);
                List<String> matches = dictionary.getOrDefault(key, new ArrayList<>());
                matches.add(product);
                dictionary.put(key, matches);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> matches = dictionary.get(searchWord.substring(0, i + 1));

            if (matches == null || matches.isEmpty()) {
                result.add(Collections.emptyList());
                continue;
            }
            
            int j = 0;
            List<String> suggestions = new ArrayList<>();
            while (j < matches.size() && j < 3) {
                suggestions.add(matches.get(j));
                j++;
            }
            result.add(suggestions);
        }

        return result;
    }
}
