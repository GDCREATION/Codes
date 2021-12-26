public class PermutationStringinStringSlidingWindow  {
        public boolean checkInclusion(String s1, String s2) {
            int x=s1.length();
            int y=s2.length();
            if(x>y || y==0)
                return false;
            int s1arr[]=new int[26];
            int s2arr[]=new int[26];
            
            for(int i=0;i<x;i++){
                s1arr[s1.charAt(i)-'a']++;
                s2arr[s2.charAt(i)-'a']++;
            }
            int count=0;
            for(int i=0;i<26;i++){
                if(s1arr[i]==s2arr[i])
                    count++;
            }
            
            for(int i=0;i<y-x;i++){
                if(count == 26)
                    return true;
                int r = s2.charAt(x+i)-'a';
                int l = s2.charAt(i)-'a';
                s2arr[r]++;
                if(s1arr[r]==s2arr[r])
                    count++;
                else if(s1arr[r] == s2arr[r]-1)
                    count--;
                s2arr[l]--;
                if(s1arr[l]==s2arr[l])
                    count++;
                else if(s1arr[l] == s2arr[l]+1)
                    count--;
                
            }
            
            if(count == 26)
                return true;
            else
                return false;
        }
    }
