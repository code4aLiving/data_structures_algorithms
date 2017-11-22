


def luckyNumberEight(number):
    digits = [int(x) for x in num]
    res = len(list(filter(lambda x: x%8==0,digits)))
    mod = 10**9 + 7

    cube = twoDigitsCube(digits)
    multiplesOfEight = [8*x for x in range(1000//8)]
    twoTable = twoDigitsTable(digits)
    twoDigitsRes = 0

    for m in multiplesOfEight:
        c = m//100
        d = (m//10)%10
        u = m%10

        if m == 0 or m == 8 or (m > 10 and m < 100):
            for j in range(len(digits)-1,0,-1):
                if digits[j] == u:
                    #print(c,d,u,twoTable[j-1][d])
                    twoDigitsRes += twoTable[j-1][d]

        res += f(digits,c,d,u,cube)    
    print(twoDigitsRes,res)
    return (res + twoDigitsRes)%mod

def f(digits,c,d,u,cube):
    res = 0
    n = len(digits)
    for i in range(2,n):
        if digits[i]!=u:
            continue
        #print(c,d,u,cube[i-1][c][d])
        res += cube[i-1][c][d]
        
    return res

def oneDigitTable(digits):
    table = [[0 for x in range(10)] for x in range(len(digits))]
    for i in range(len(digits)):
        for j in range(10):
            if j != digits[i]:
                if i>0:
                    table[i][j] = table[i-1][j]
            else:
                if not i:
                    table[i][j]=1
                else:
                    table[i][j]=table[i-1][j] + 2**i
    
    return table

def twoDigitsCube(digits):
    table = oneDigitTable(digits)
    cube = [[[0 for x in range(10)] for x in range(10)] for x in range(len(digits))]
    for i in range(1,len(digits)):
        for j in range(10):
            for k in range(10):
                if k != digits[i]:
                    cube[i][j][k] = cube[i-1][j][k]
                    continue
                cube[i][j][k] = cube[i-1][j][k] + table[i-1][j]
    
    return cube

def twoDigitsTable(digits):
    table = [[0 for x in range(10)] for x in range(len(digits))]
    for i in range(len(digits)):
        for j in range(10):
            if digits[i] != j:
                if i:
                    table[i][j]=table[i-1][j]
            else:
                if i:
                    table[i][j]=table[i-1][j]+1
                else:
                    table[i][j]=1
    return table

n = int(input().strip())
num = input().strip()
print(luckyNumberEight(num))
