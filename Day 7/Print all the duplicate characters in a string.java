import java.util.*;

public class DuplicateCharacters {
    static void printDuplicates(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        for (Map.Entry<Character,Integer> mapElement : map.entrySet()) {
            if (mapElement.getValue() > 1)
                //if the count of characters is greater than 1 then duplicate found
                System.out.println(mapElement.getKey() + ", count = " + mapElement.getValue());
        }
    }
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        printDuplicates(s);
    }
}