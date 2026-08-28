class Solution(object):
    def findJudge(self, n, trust):

        alltrust=[0]*(n+1)
        for a,b in trust:
            alltrust[a]-=1
            alltrust[b]+=1
        for i in range(1,n+1):
            if alltrust[i]==n-1:
                return i
        return -1
       
    