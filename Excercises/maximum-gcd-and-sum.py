import sys
import math

def gcd(a,b):
    m = min(a,b)
    M = max(a,b)
    a = m
    b = M
    r = b % a
    while r:
        b = a
        a = r
        r = b % a
    return a

def solve2(a, b):
    a = sorted(a, reverse=True)
    b = sorted(b, reverse=True)

    mgcd = 0
    res = 0
    i,j = 0,0

    while i < len(a) and j < len(b):
        print(i,j)
        if a[i] > b[j]:
            ma = a[i]
            mi = b[j]
            k = j
            while mgcd < b[k]:
                tgcd = gcd(ma, b[k])
                if mgcd < tgcd:
                    mgcd = tgcd
                    res = ma + b[k]
                elif mgcd == tgcd:
                    res = max(res, ma + b[k])
                k+=1
            if i == len(a)-1:
                j += 1
            else:
                i += 1
        else:
            ma = b[j]
            mi = a[i]
            k = i
            while mgcd < a[k]:
                tgcd = gcd(ma, a[k])
                if mgcd < tgcd:
                    mgcd = tgcd
                    res = ma + a[k]
                elif mgcd == tgcd:
                    res = max(res, ma + a[k])
                k+=1

            if j == len(b)-1:
                i += 1
            else:
                j += 1
    return res
                
def solve(A, B):
    table = [[0 for x in range(10**6+1)] for y in range(4)]
    for a in A:
        table[0][a] = 1
    for b in B:
        table[1][b] = 1
    gcd = 0
    res = 0
    for i in range(1,10**6+1):
        for j in range(i,10**6+1,i):
            if table[0][j]:
                table[2][i] = max(table[2][j],j)
            if table[1][j]:
                table[3][i] = max(table[3][j],j)
        if table[2][i] and table[3][i]:
            gcd = j
            res = table[2][i] + table[3][i]
    return res
                

if __name__ == "__main__":
    n = int(input().strip())
    A = list(map(int, input().strip().split(' ')))
    B = list(map(int, input().strip().split(' ')))
    res = solve(A, B)
    print(res)
