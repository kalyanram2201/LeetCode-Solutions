class Solution(object):
    def removeDuplicates(self, num):
        if len(num)==0:
            return num
        a=[]
        for x in num:
            if x not in a:
                a.append(x)
        for i in range(len(a)):
            num[i]=a[i]
        return len(a)