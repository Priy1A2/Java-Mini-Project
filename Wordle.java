import java.io.*;
import java.util.*;
import java.util.random.RandomGenerator;

public class Wordle{
    
    static String random_word(List<String> words){
        RandomGenerator random = RandomGenerator.getDefault();
        int idx = random.nextInt(words.size());
        return words.get(idx);

    }
    static void play(String random_word){
        Scanner sc = new Scanner(System.in);
        String guess = "";
        int counter=1;
        while(!guess.equals(random_word) && counter<=6){
            System.out.println("Guess #"+counter);
            guess = sc.nextLine();
            System.out.println(feedback(guess, random_word));
            counter++;
        }
        if(guess.equals(random_word)){
        System.out.println("Congratulations! You guessed the correct word.");
        }
        else{
            System.out.println("Better luck next time! The correct word was: "+random_word);
        }
        sc.close();
    }
    static String feedback(String guess, String word){
        String feedback = "";
        for(int i = 0;i < guess.length(); i++){
            char c = guess.charAt(i);
            if(c == word.charAt(i)){
                feedback += "\033[32m" + c;
            }
            else if(word.contains(c+"")){
                feedback += "\033[33m" + c;
            }
            else{
                feedback += "\033[0m" + c;
            }
        }
        return feedback + "\033[0m";
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
            System.out.println(e.getMessage());
        }
        
        String random = random_word(wordList);
        // System.out.println(random);
        play(random);
    }
}
