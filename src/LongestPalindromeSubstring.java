public class LongestPalindromeSubstring {
    /**Given a string s, return the longest palindromic substring in s. */
        public String longestPalindrome(String s) {
            int maxLength = 1;
     
            int start = 0;
            int len = s.length();
            for(int i=1;i<len ;i++){
                int low = i-1;
                int high = i;
                while(low >= 0 && high < len && s.charAt(low)== s.charAt(high)){
                        low --;
                        high++;
                }
                
                low++;
                high--;
                
                if(s.charAt(low)==s.charAt(high) && maxLength < high-low+1)
                {
                    maxLength = high-low+1;
                    start = low;
                }
                
                low = i-1;
                high = i+1;
                
                while(low >= 0 && high < len && s.charAt(low)== s.charAt(high)){
                        low --;
                        high++;
                }
                
                low++;
                high--;
                
                if(s.charAt(low)==s.charAt(high) && maxLength < high-low+1)
                {
                    maxLength = high-low+1;
                    start = low;
                }
                
            }
            
            return s.substring(start,start+maxLength);
        }
    }
