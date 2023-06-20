class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        memory = {}

        for string in strs:
            rearanged_symbols = ''.join(sorted(string))
            if memory.get(rearanged_symbols) != None:
                memory[rearanged_symbols].append(string)
            else: memory[rearanged_symbols] = [string]

        return memory.values()