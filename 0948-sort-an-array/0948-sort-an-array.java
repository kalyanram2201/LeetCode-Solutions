class Solution {
    public int[] sortArray(int[] nums) {
        if(nums.length<=1){
            return nums;
        }
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    private void quickSort(int[] arr,int p,int q){
        if(p<q){
            int j=Partition(arr,p,q+1);
            quickSort(arr,p,j-1);
            quickSort(arr,j+1,q);
        }
    }

    private int Partition(int[] arr,int p,int q){
        int pivot=arr[p];
        int i=p,j=q;
        do{
            do{
                i++;
            }while(i<q && arr[i]<pivot);

            do{
                j--;
            }while(j>p && arr[j]>pivot);

            if(i<j){
                swap(arr,i,j);
            }
        }while(i<j);
        swap(arr,p,j);
        return j;
    }

    private void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}