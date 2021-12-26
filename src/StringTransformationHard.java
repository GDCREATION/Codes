import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class StringTransformationHard {
    /**Given two strings str1 and str2 of the same length, determine whether you can transform str1 into str2 by doing zero or more conversions.

In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.

Return true if and only if you can transform str1 into str2. */
        public boolean canConvert(String str1, String str2) {
            HashMap<Character,Character> map =new HashMap<>();
            Set<Character> un = new HashSet<>();
            int len = str1.length();
            if (str1.equals(str2)) {
                return true;
            }
            for(int i=0;i<len;i++){
                char it = str1.charAt(i);
                char it2 = str2.charAt(i);
                if(map.containsKey(it)){
                    if(map.get(it) != it2)
                        return false;
                }else
                {
                    map.put(it,it2);
                    un.add(it2);  
                }
            }
            if(un.size() < 26)
                return true;
            return false;
        }
    }
