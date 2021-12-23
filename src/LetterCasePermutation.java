import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    /**Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. Return the output in any order.

 

Example 1:

Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"] */
        public List<String> letterCasePermutation(String S) {
            List<StringBuilder> ans = new ArrayList<>();
            ans.add(new StringBuilder());
    
            for (char c: S.toCharArray()) {
                int n = ans.size();
                if (Character.isLetter(c)) {
                    for (int i = 0; i < n; ++i) {
                        ans.add(new StringBuilder(ans.get(i)));
                        ans.get(i).append(Character.toLowerCase(c));
                        ans.get(n+i).append(Character.toUpperCase(c));
                    }
                } else {
                    for (int i = 0; i < n; ++i)
                        ans.get(i).append(c);
                }
            }
    
            List<String> finalans = new ArrayList<>();
            for (StringBuilder sb: ans)
                finalans.add(sb.toString());
            return finalans;
        }
    }