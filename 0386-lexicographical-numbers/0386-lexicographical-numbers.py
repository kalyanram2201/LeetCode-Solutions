class Solution:
    def lexicalOrder(self, n: int) -> List[int]:
        s = []
        for i in range(1, n + 1):
            s.append(str(i))
            
        s.sort()
        ans = []
        
        for i in range(n):
            ans.append(int(s[i])) 
        return ans
 