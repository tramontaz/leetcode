def longestPalindrome(s: str) -> str:
    if len(s) == 1: return s

    start = 0
    end = 0
    lps = 1
    for i in range(len(s)):
        oddLenght = get_lps_length_expand(s, i, i)
        evenLength = get_lps_length_expand(s, i, i + 1)

        if oddLenght > lps and oddLenght > evenLength:
            start = i - oddLenght // 2
            end = i + oddLenght // 2
            lps = oddLenght
        elif evenLength > lps and evenLength > oddLenght:
            start = i - evenLength // 2 + 1
            end = i + evenLength // 2
            lps = evenLength

    return s[start:end + 1]

def get_lps_length_expand(s: str, start: int, end: int) -> int:

    while start >= 0 and end < len(s) and s[start] == s[end]:
        start -= 1
        end += 1

    return end - start - 1

def test(s: str, expected: str):
    lp = longestPalindrome(s)
    if expected != lp:
        raise Exception(f'Test failed. Expected: "{expected}", But got "{lp}"')

test("obbad", "bb")
test("babad", "bab")
test("badad", "ada")
test("dabad", "dabad")
test("b", "b")
test("bb", "bb")
test("aaaa", "aaaa")