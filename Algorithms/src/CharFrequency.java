import java.util.HashMap;

public class CharFrequency {
    public static void count(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        map.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
