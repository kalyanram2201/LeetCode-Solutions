class Solution {
    public int getKth(int lo, int hi, int k) {
            HashMap<Integer,Integer>map=new HashMap<>();
            for(int i=lo;i<=hi;i++)
            {
               map.put(i,power(i));
            }
            List<Integer>list=new ArrayList<>(map.keySet());
            list.sort((a,b)->{
                int pa=map.get(a);
                int pb=map.get(b);
                if(pa==pb){
                    return Integer.compare(a,b);
                }
                return Integer.compare(pa,pb);
            });
            
            return list.get(k-1);
    }

    private int power(int x){
        int steps=0;
        while(x!=1){
            if(x%2==0){
                x=x/2;
            }else{
                x=x*3+1;
            }
            steps++;
        }
        return steps;
    }
}