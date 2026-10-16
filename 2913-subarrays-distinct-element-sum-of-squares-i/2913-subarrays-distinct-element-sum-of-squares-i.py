class Solution:
    def sumCounts(self, nums: List[int]) -> int:
        sum = 0
        i = 0

        while i < len(nums):
            j = i
            s = set()
            while j < len(nums):
                s.add(nums[j])
                sum = sum + len(s)*len(s)
                j = j+1

            i = i+1

        return sum