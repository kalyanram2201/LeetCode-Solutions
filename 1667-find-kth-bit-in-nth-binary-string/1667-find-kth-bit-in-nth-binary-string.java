class Solution {
    static String[] arr=new String[21];
    static{
    arr[1]="0";
    for(int i=2;i<=20;i++){
        arr[i]=arr[i-1]+"1"+rev(arr[i-1]);
    }

    }
    public static String rev(String s){
        StringBuilder sb=new StringBuilder();
       
        for (int i = s.length() - 1; i >= 0; i--) {
         sb.append(s.charAt(i) == '0' ? '1' : '0');
}
       return sb.toString();
    }
    public char findKthBit(int n, int k) {
        String s=arr[n];
        return s.charAt(k-1);
        

    }
}