class Solution {
   public  int romanToInt(String s) {
        if(s==""){
            return 0;
           }
           int sum=0;
           for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='I'&&(i+1)<s.length()&&s.charAt(i+1)=='V'){
                sum+=4;
                i++;  
            }else if(s.charAt(i)=='I'&&(i+1)<s.length()&&s.charAt(i+1)=='X'){
                sum+=9;
                 i++;
            }else if(s.charAt(i)=='I'){
                sum+=1;
             }else if(s.charAt(i)=='V'){
                sum+=5;  
            }else if(s.charAt(i)=='X'&&(i+1)<s.length()&&s.charAt(i+1)=='C'){
               sum+=90;
               i++;
            }else if(s.charAt(i)=='C'&&(i+1)<s.length()&&s.charAt(i+1)=='D'){
                sum+=400;
                i++;
            }else if(s.charAt(i)=='X'&&(i+1)<s.length()&&s.charAt(i+1)=='L'){
                sum+=40;
                i++;
            }else if(s.charAt(i)=='X'){
                sum+=10;
            }else if(s.charAt(i)=='L'){
                sum+=50;
            }else if(s.charAt(i)=='C'&&(i+1)<s.length()&&s.charAt(i+1)=='M'){
               sum+=900;
               i++;
           }else if(s.charAt(i)=='C'){
                sum+=100;
            }else if(s.charAt(i)=='D'){
                sum+=500;
            }else if(s.charAt(i)=='M'){
                sum+=1000;
            }
          // System.out.println(sum);
           } 
           return sum;
     }
}