class ProductOfNumbers {
    List<Integer>list;;

    public ProductOfNumbers() {
        list=new ArrayList<>();
        list.add(1);
    }
    
    public void add(int num) {
        int n=list.size();
        if(num==0){
            list.clear();
            list.add(1);
        }else{
            list.add(list.get(n-1)*num);
        }
    }
    
    public int getProduct(int k) {
        int n=list.size();
        if(k>=n)return 0;
        return list.get(n-1)/list.get(n-1-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */