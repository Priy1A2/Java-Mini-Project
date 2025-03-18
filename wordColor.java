public class wordColor{
        private static String feedback(String guess, String word){
        String feedback="";
        for(int i=0;i<max_length;i++){
            char c=guess.charAt(i);
            if(c==word.charAt(i)){
                feedback+="\033[32m"+c;
            }
            else if(word.contains(c+"")){
                feedback+="\033[33m"+c;
            }
            else{
                feedback+="\033[0m"+c;
            }
        }
        return "\033[0m"+c;
    }
}