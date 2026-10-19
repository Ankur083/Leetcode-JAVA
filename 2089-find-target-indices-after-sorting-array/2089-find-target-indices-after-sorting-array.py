class Solution:
    def targetIndices(self, nums: list[int], target: int) -> list[int]:
        nums.sort()

        ls = []

        for i in range(len(nums)):
            if(nums[i] == target):
                ls.append(i)

        
        return ls