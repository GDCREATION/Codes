public class RansomNote {
    /**Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote. */
        public boolean canConstruct(String ransomNote, String magazine) {
            int count[]=new int[26];
            for(Character c:  magazine.toCharArray()){
                count[c-'a']++;
            }
            for(Character c: ransomNote.toCharArray()){
                if(count[c-'a']==0)
                    return false;
                count[c-'a']--;
            }
            return true;
        }
    }
