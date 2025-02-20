class Solution {
    public String frequencySort(String s) {
        if(s.length()<=1){
            return s;
        }
        String str[]=s.split("(?<=(.))(?!\\1)");
        HashMap<Character,Integer>map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Character>list=new LinkedList<>(map.keySet());
        list.sort((a,b)-> {
            if (map.get(b).equals(map.get(a))) {
                return a-b; 
            }
            return map.get(b) - map.get(a);
        });
        StringBuilder result=new StringBuilder();
        for(char c:list){
            result.append(String.valueOf(c).repeat(map.get(c)));
        }
        return result.toString();
    }
}