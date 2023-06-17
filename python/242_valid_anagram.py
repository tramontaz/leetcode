class Solution(object):

    def word_to_map(self, word):
        symbols = {}

        for letter in word:
            if letter in symbols:
                symbols[letter] = symbols[letter] + 1
            else:
                symbols[letter] = 1

        return symbols

    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        s_map = self.word_to_map(s)
        t_map = self.word_to_map(t)

        for key in s_map:
            if key not in t_map or (s_map[key] != t_map[key]):
                return False
        
        for key in t_map:
            if key not in s_map or (s_map[key] != t_map[key]):
                return False

        return True