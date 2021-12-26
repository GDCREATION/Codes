import java.util.*;

public class GroupAnagrms {

    /**Given an array of strings strs, group the anagrams together. 
     * You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once. */
    
        class Node{
            int[] rest;
            int length;
            Node(int[] rest, int length){
                this.rest = rest;
                this.length = length;
            }
        }
        
        List<Node> res = new ArrayList<>();
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> map =new LinkedList<>();
            int counter=0;
            for(int i=0;i<strs.length;i++){
                char ch[]= strs[i].toCharArray();
                if(res.size()==0){
                    int arrr[] = changeToInt(ch);
                    res.add(new Node(arrr,ch.length));
                    ArrayList<String> ss = new ArrayList<>();
                    ss.add(strs[i]);
                    map.add(counter,ss);
                    counter++;
                }
                else{
                    boolean checkRes =false;
                    int[] chr = changeToInt(ch);
                    for(int j=0;j<res.size();j++){
                        Node node = res.get(j);
                        if(node.length != ch.length)
                            continue;
                        boolean ang = checkAnagram(chr,node.rest);
                        if(ang == false)
                            continue;
                        List y = map.get(j);
                        y.add(strs[i]);
                        map.set(j, y);
                        checkRes = true;
                        break;
                    }
                    if(checkRes == false){
                        res.add(new Node(chr,ch.length));
                        ArrayList<String> ss = new ArrayList<>();
                        ss.add(strs[i]);
                        map.add(counter,ss);
                        counter++;
                    }
                }
            }
            
            
            return map;
        }
        
        int[] changeToInt(char []ch){
            int in[]=new int[26];
            for(int i=0;i<ch.length;i++){
                in[ch[i]-'a']++;
            }
            Node node = new Node(in,ch.length);
            return in;
        }
        
        boolean checkAnagram(int []ch, int []ch1){
            
            for(int i=0;i<26;i++){
                if(ch[i] != ch1[i])
                    return false;
            }
            return true;
        }
    }
