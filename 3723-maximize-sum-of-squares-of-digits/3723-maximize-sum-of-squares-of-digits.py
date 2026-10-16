class Solution:
    def maxSumOfSquares(self, num: int, sum: int) -> str:
        if sum > 9*num | sum < 0 :
            return ""

        s = ""
        i = 0

        for i in range(num):
            d = min(sum, 9)
            s = s+str(d)
            sum = sum - d

        if sum != 0:
            return ""

        return s
