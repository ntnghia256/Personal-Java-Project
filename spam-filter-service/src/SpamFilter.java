import javax.swing.text.html.Option;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class SpamFilter {
    private Set<String> badWords = new HashSet<>();

    public void loadBadWords(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String word;
            while ((word = br.readLine()) != null) {
                badWords.add(word.trim().toLowerCase());
            }
        } catch (IOException e) {
            System.out.println("File bad words is not found!");
        }
    }

    public String cleanContent(String input) {
        String content = Optional.ofNullable(input).orElse("");
        if (content.isEmpty()) return "";

        String[] words = content.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (String w : words) {
            if (badWords.contains(w.toLowerCase())) {
                sb.append(w).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
