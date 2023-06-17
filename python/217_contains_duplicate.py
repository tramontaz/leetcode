class Solution(object):
    def containsDuplicate(self, nums):
        nums_without_duplicates = set(nums)
        if len(nums_without_duplicates) != len(nums):
            return True
        return False
