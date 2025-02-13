class Solution {
    public boolean digitCount(String num) {
        
        HashMap<Integer,Integer>map=new HashMap<>();
        for(char c:num.toCharArray()){
            int key=c-'0';
            map.put(key,map.getOrDefault(key,0)+1); 
        }

        for(int i=0;i<num.length();i++){
            int expect=num.charAt(i)-'0';
            int actual=map.getOrDefault(i,0);
            if(expect!=actual){
                return false;
            }
        }
        return true;
    }
}