class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 1,pr=colors[0],gr=0;

        for (int i = 1; i < n+k-1; i++) {
            int id=i%n;
            if(pr==colors[id]){
                count=1;
                pr=colors[id];
                continue;
            }
            count++;
            if(count>=k){
                gr++;
            }
            pr=colors[id];
        }

        return gr;
    }
}
