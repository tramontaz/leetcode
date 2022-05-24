def longestValidParentheses(s: str) -> int:
    if len(s) == 0: return 0
        
    if s[0] == '(':
        deep = 1 
    else: 
        deep = 0
    max_length = 0
    
    dp = [0]
    for i in range(0, len(s)):
        dp.append(0)
        
    for i in range(1, len(s)):
        if(s[i] == ')'):
            if deep > 0:
                deep -= 1
                dp[i] = dp[i - 1] + 2
                if i - dp[i] > 0:
                    dp[i] += dp[i - dp[i]]
                
                if dp[i] > max_length: max_length = dp[i]
        else:
            deep += 1
                
    return max_length

print(longestValidParentheses("((())())"))
