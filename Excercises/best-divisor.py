import sys

def better_number(n,m):
    sn = digits_sum(n)
    sm = digits_sum(m)
    if sn > sm:
        return n
    elif sn < sm:
        return m
    elif n <= m:
        return n

    return m

def digits_sum(n):
    res = 0
    while n > 0:
        res += n%10
        n /= 10
    return res

def get_divisors(n):
    for x in range(2,n+1):
        if n%x == 0:
            yield x

def solve(n):
    bestDivisor = 1
    bestSum = 1
    for x in get_divisors(n):
        best = better_number(x,bestDivisor)
        if not best == bestDivisor:
            bestDivisor = best
    return bestDivisor
n = int(raw_input().strip())
print solve(n)
