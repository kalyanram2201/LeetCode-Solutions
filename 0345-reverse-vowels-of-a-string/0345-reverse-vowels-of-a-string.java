class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
        List<Character>list=new ArrayList<>();
        for(char c:s.toCharArray()){
            if(vowels.contains(c)){
                list.add(c);
            }
        }
        Collections.reverse(list);
        StringBuilder str=new StringBuilder();
        int j=0;
        for(char c:s.toCharArray())
        {
            if(vowels.contains(c)){
                str.append(list.get(j));
                j++;
            }else{
                str.append(c);
            }
        }
        return str.toString();
    }
}