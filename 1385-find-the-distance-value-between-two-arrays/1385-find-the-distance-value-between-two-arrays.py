class Solution:
    def findTheDistanceValue(self, arr1: list[int], arr2: list[int], d: int) -> int:
        cnt = 0


        for i in range(len(arr1)):
            flag = False
            for j in range(len(arr2)):
                if(abs(arr1[i]-arr2[j]) <= d):
                    flag = True

            if flag == False:
                cnt = cnt+1

        return cnt
