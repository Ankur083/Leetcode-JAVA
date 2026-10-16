class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        
        i = 0
        for i in range(len(nums)):
            if nums[i] < 0:
                nums[i] = -1*nums[i]

        

        nums.sort()
        size = len(nums)//2

        i = 0
        sum1 = 0

        while i < size:
            sum1 = sum1 + nums[i]*nums[i]
            i = i+1

        i = size
        sum2 = 0

        while i < len(nums):
            sum2 = sum2+ nums[i]*nums[i]
            i = i+1

        return sum2-sum1

    
