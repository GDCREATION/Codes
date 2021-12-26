import java.util.Stack;

/**Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4]. */

public class DecodeStringusingStack {
        public String decodeString(String s) {
            Stack<StringBuilder>strings=new Stack<>();
            Stack<Integer>nums=new Stack<>();
            
            StringBuilder currStr=new StringBuilder();
            int currNum=0;
            
            for(char c: s.toCharArray()){
                if(c == '['){
                    strings.push(currStr);
                    nums.push(currNum);
                    currStr=new StringBuilder();
                    currNum=0;
                }
                else if(c == ']'){
                    StringBuilder decod = strings.pop();
                    for(int j= nums.pop();j>0;j--){
                        decod.append(currStr);
                    }
                    currStr = decod;
                }
                else if(c-'0'>=0 && c-'0'<=9){
                    currNum = currNum*10+c-'0';
                }else{
                    currStr.append(c);
                }
            }
            
            return currStr.toString();
        }
    }