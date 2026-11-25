class Solution:
    def digitSum(self, s: str, k: int) -> str:
        

        
        

        while len(s) > k :
            str1 = ""

            sum = 0
            cnt = 0

            for i in range(len(s)):
                sum += int(s[i])
                cnt = cnt+1


                if cnt == k:
                    cnt = 0
                    str1 += str(sum)
                    sum = 0

            if cnt > 0:
                str1 += str(sum)
                

            s = str1
        return s