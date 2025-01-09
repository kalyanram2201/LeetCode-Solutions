class Solution {
    public String reverseStr(String s, int k) {
        if(s==null ||k==0 || s.length()<1){
            return s;
        }
        char [] temp=s.toCharArray();
        for(int i=0;i<temp.length;i+=2*k){
            int left=i;
            int right=Math.min(i+k-1,temp.length-1);

            while(left<right){
                char temp1=temp[left];
                temp[left]=temp[right];
                temp[right]=temp1;
                left++;
                right--;
            }
        }
        return new String(temp);
    }
}