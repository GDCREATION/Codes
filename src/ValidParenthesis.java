import java.util.Stack;

public class ValidParenthesis {
    /**Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order. */
        public boolean isValid(String s) {
            Stack<Character> ss = new Stack<>();
            
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(c == '(' || c == '{' || c == '['){
                    ss.push(c);
                }else if(!ss.isEmpty()){
                    if(c == ')' && ss.pop() != '('){
                    return false;
                    }else if(c == '}' && ss.pop() != '{'){
                        return false;
                    }else if(c == ']' && ss.pop() != '['){
                        return false;
                    }
                }
                else
                    return false;
            }
            
            if(ss.isEmpty())
                return true;
            return false;
        }
    }
