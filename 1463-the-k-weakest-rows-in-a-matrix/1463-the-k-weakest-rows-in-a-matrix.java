class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        if(k==0||mat.length==0){
            return new int[0];
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<mat.length;i++){
            int count=0;
            for(int j=0;j<mat[0].length;j++){
               if(mat[i][j]==1){
                count++;
               }else{
                break;
               }
            }
            map.put(i,count);
        }
        PriorityQueue<Integer>queue=new PriorityQueue<>((a,b)-> {
            if(!map.get(a).equals(map.get(b))){
               return  map.get(a)-map.get(b);
            }else{
                return a-b;
            }
        });
            for(int i=0;i<mat.length;i++){
                queue.add(i);
            }
        int result[]=new int[k];
        for(int i=0;i<k;i++){
            result[i]=queue.poll();
        }
        return result;

    }
}