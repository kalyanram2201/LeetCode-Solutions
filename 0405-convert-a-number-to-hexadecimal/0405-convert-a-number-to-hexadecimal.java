class Solution {
    public String toHex(int num) {
        if(num==0){
            return "0";
        }
        StringBuilder result=new StringBuilder();
        char []hexnum="0123456789abcdef".toCharArray();
        while(num!=0){
            int rem=num&15;
            result.append(hexnum[rem]);
            num=num>>>4;
        }
        return result.reverse().toString();
    
    }

}