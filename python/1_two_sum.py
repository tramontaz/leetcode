class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        memory = {}

        for idx, subtrahend in enumerate(nums):
            difference = target - subtrahend
            if difference in memory:
                return [memory[difference], idx]
            else:
                memory[subtrahend] = idx
        
        raise Exception('Something went wrong')