import math

def eratostheres_primes(n):
    primes = []
    visited = set()
    for x in range(2,n+1):
        if x not in visited:
            primes.append(x)
            i = 1
            while x*i <= n:
                visited.add(x*i)
                i+=1
    return primes


def SoE(n):
    boolTable = [True for x in range(n-1)]
    for x in xrange(2,n+1):
        if boolTable[x-2]:
            i = 2
            while x*i <= n:
                boolTable[x*i-2]=False
                i+=1
    return boolTable

def SoE_segmented(n):
    sqr = int(math.sqrt(n))

def twin_primes(n,m):
    boolTable = SoE(m)
    print boolTable
    res = 0
    for i in range(len(boolTable)-2):
        if i+2>=n and boolTable[i] and boolTable[i+2]:
            res+=1
    return res
            

    
    
