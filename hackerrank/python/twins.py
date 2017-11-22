from math import sqrt
from random import Random

def solve(n,m):
    if m-n < 2:
        return 0
    primes = SoE(int(sqrt(m)))
    boolTable = [True for x in range(m-n+1)]
    if n == 1:
        boolTable[0]=False
    res = 0
    for p in primes:
        c = n/p
        while p*c <= m:
            if p*c < n or c == 1:
                c+=1
                continue            
            #print p*c-n
            boolTable[p*c-n]=False
            c+=1
    #print sqrt(m),primes,boolTable
    for i in range(len(boolTable)-2):
        if boolTable[i] and boolTable[i+2]:
            res+=1
    return res

def SoE(n):
    boolTable = [True for x in range(n-1)]
    primes = []
    for x in xrange(2,n+1):
        if boolTable[x-2]:
            i = 2
            primes.append(x)
            while x*i <= n:
                boolTable[x*i-2]=False
                i+=1
    return primes

def eratostheres_primes(n,s):
    primes = []
    visited = set()
    for x in range(2,n+1):
        if x not in visited:
            if x >= s:
                primes.append(x)
            i = 1
            while x*i <= n:
                visited.add(x*i)
                i+=1
    return primes

def solve2(n,m):
    primes = eratostheres_primes(m,n)
    res = 0
    for i in range(len(primes)-1):
        if abs(primes[i]-primes[i+1])==2:
            res+=1
    return res

def test():
    r = Random()
    for i in range(10):
        n = r.randint(1,10)
        m = r.randint(10,20)
        print n,m,solve2(n,m),solve(n,m)

#n,m = map(int,raw_input().split(' '))
#print solve(n,m)
