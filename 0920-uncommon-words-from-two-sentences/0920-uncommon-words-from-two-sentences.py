class Solution(object):
    def uncommonFromSentences(self, s1, s2):

        s1=s1.split(" ");
        s2=s2.split(" ");
        s3=[]
        for i in s1:

            if(i not in s2 and s1.count(i)==1):
                s3.append(i)
        for i in s2:
            if(i not in s1 and s2.count(i)==1):
                s3.append(i)
        return s3; 
        