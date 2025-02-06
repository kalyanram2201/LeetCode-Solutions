class Solution {
    List<Integer> sub=new ArrayList<>();
    List<List<Integer>> subsequence=new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        findsequence(nums,0);
        return subsequence;
    }

    private void findsequence(int arr[],int i){
        if(i==arr.length){
            subsequence.add(new ArrayList(sub));
            return;
        }
        findsequence(arr,i+1);
        sub.add(arr[i]);
        findsequence(arr,i+1);
        sub.remove(sub.size()-1);
    }
}