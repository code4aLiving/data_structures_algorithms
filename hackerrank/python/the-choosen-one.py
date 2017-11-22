from math import sqrt
def eratostheres_primes(n):
    primes = []
    visited = set()
    for x in xrange(2,n+1):
        if x not in visited:
            primes.append(x)
            i = 1
            while x*i <= n:
                visited.add(x*i)
                i+=1
    return primes

def SoE(n):
    boolTable = [True for x in xrange(n-1)]
    for x in xrange(2,n+1):
        if boolTable[x-2]:
            i = 2
            while x*i <= n:
                boolTable[x*i-2]=False
                i+=1
    return boolTable

def solve(n,a):
    #primes = eratostheres_primes(int(sqrt(10**18)))
    boolTable = SoE(int(sqrt(10**13)))
    for i in boolTable:
        if boolTable[i]:
            p = i + 2
            notdiv = 0
            for num in a:
                if num%p:
                    notdiv+=1
                if notdiv>1:
                    break
            if notdiv==1:
                return p          
            
        

n = int(raw_input().strip())
a = map(int, raw_input().strip().split(' '))
print solve(n,a)
