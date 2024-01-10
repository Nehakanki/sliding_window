/**
 * countingAnagrams
 */
import java.util.*;
public class countingAnagrams {

    //for frequency stored into the hashmap
    public static Map<Character, Integer> frequency(String s){
        Map<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            
            int  value = hm.getOrDefault(ch, 0);
            hm.put(ch, value+1);
        }

        return hm;

    }

    //for checking presence of anagram
    public static boolean isAnagram (String s, String p){
        Map<Character, Integer> freq_s = frequency(s);
         Map<Character, Integer> freq_p = frequency(p);

         return freq_p.equals(freq_s);

    }

    public static int count_Anagram(String s, String pattern){
        int i=0;
        int j=0;
        int k = pattern.length(); //size of the window
        int count=0;

        while(j<s.length()){
            //1. calculation
            String substr = s.substring(i, j+1);
             Map<Character, Integer>ans =   frequency(substr);

            //increment j++
            if(j-i+1 <k){
                j++;
            }
            else if(j-i+1 ==k){
                if(isAnagram(substr, pattern)){
                    count++;
                 
                }
                int charFreq = ans.get(s.charAt(i));
                    if(charFreq>1){
                        ans.put(s.charAt(i), charFreq - 1);
                    }
                    else{
                        ans.remove(s.charAt(i));
                    }
                    i++;
                    j++;

            }



            //calculate  when window ==k
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "aabaabaa";
        String pattern = "aaba";
        int n = count_Anagram(s,pattern);
        System.out.println(n);
    }
    
}