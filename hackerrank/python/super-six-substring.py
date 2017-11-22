

def solve(s):
    sumList = [0 for x in s]
    remider3 = [x%3 for x in s]
    res = 0
    if not s[-1] % 6:
        sumList[-1]=1
    for i in range(len(s)-2,-1,-1):
        if not s[i]:
            res += 1
            sumList[i] = sumList[i+1]
            continue
        if not s[i] % 6:
            sumList[i] = sumList[i+1] + 1
    res += sum([sumList[i] for i in range(len(s)) if s[i] > 0])
    print(sumList)
    return res

s = list(map(int,input().strip()))
print(s)
print(solve(s))


        
               
    
