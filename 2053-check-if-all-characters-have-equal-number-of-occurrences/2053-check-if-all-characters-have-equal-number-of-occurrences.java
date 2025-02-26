class Solution {
    public boolean areOccurrencesEqual(String s) {
        if(s.length()==0){
            return true;
        }
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int max=map.get(s.charAt(0));
        for(char c:map.keySet()){
            if(max!=map.get(c)){
                return false;
            }
        }
        return true;
    }
}