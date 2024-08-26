class Solution {
    public boolean isValid(String s) {
        Stack<Character>stack=new Stack<>();
        if(s.length()==1){
            return false;
        }
        for(char ch:s.toCharArray()){
            if(ch=='('||ch=='{'||ch=='['){
                stack.push(ch);
            }
            else if(ch==')'){
                if(stack.isEmpty()||stack.pop()!='('){
                    return false;
                }
            }
            else if(ch=='}'){
                if(stack.isEmpty()||stack.pop()!='{'){
                    return false;
                }
            }
            else if(ch==']'){
                if(stack.isEmpty()||stack.pop()!='['){
                    return false;
                }
            }              
        }
        return stack.isEmpty();
    }
        
}
