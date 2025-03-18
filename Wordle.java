import java.io.*;
import java.util.*;
import java.util.random.RandomGenerator;

public class Wordle{
    
    static String random_word(List<String> words){
        RandomGenerator random = RandomGenerator.getDefault();
        int idx = random.nextInt(words.size());
        return words.get(idx);

    }
    public static void main (String[] args){
        final String fileName = "words.txt";
        List<String> wordList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = br.readLine()) != null) {
                wordList.add(line.trim());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(random_word(wordList));
    }
}