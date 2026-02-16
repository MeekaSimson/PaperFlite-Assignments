package WordPattern;
import java.util.*;
public class Main {
    public static Boolean WordPattern(String pattern, String str){
        String words [] = str.split(" ");
        if(pattern.length()!=words.length) return false;
        HashMap <Character,String> map1 = new HashMap<>();
        HashMap <String,Character> map2 = new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            String word = words[i];
            if(map1.containsKey(ch)){
                if(!map1.get(ch).equals(word)) return false;
            }
            map1.put(ch,word);
            if(map2.containsKey(word)){
                if(!map2.get(word).equals(ch)) return false;
            }
            map2.put(word,ch);
        }
        return true;
    }
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter pattern: ");
    String pattern = sc.nextLine();
    System.out.print("Enter string: ");
    String string = sc.nextLine();
    boolean result = WordPattern(pattern, string);
    System.out.println(result);
    sc.close();
}
   }
