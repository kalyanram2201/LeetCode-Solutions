class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>result=new ArrayList<>();
        helper(n,result,"",0,0);
        return result;
    }

    private void helper(int n,List<String>result,String str,int op,int cl)
    {
        if(str.length()==n*2){
            result.add(str);
            return;
        }
        if(op<n){
            helper(n,result,str+"(",op+1,cl);
        }
        if(cl<op){
            helper(n,result,str+")",op,cl+1);
        }
    }
}