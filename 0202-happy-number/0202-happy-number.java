class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer>cycle=new HashSet<>();

        while(n!=1){
            if(cycle.contains(n)){
                return false;
            }
            cycle.add(n);
           n=square(n); 
        }
        return true;
        
    }

    int square(int num){
        int sum=0;
        while(num!=0){
            int rem=num%10;
            sum+=rem*rem;
            num/=10;
        }
        return sum;
    }
}