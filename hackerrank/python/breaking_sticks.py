from math import sqrt

def breaking_sticks(sticks):
    primes = SoE(10**6)
    maxP = primes[-1]
    setPrimes = set(primes)
    sticks = sorted(sticks)
    res = 0
    for s in sticks:
        if s == 1:
            res += 1
            continue

        primeDivisors = getPrimes(primes,s)
        print(primeDivisors)
        if not len(primeDivisors):
            res += 1
        res += s
        for p,e in primeDivisors:
            while e > 0:
                s = s // p
                res += s
                e -= 1
        #res += break_stick(s, primeDivisors, memory, 0)
    return res

def getPrimes(primes, n):
    res = {}
    queue = [n]
    while len(queue):
        current = queue.pop(0)
        primeFound = False
        for p in primes:
            if p > sqrt(current):
                if not primeFound:
                    #current is prime
                    res[current]=res.setdefault(current,0)+1
                break
            if not current % p:
                primeFound = True
                res[p] = res.setdefault(p,0)+1
                queue.append(current // p)
    return [(k,v) for (k,v) in res.items()];

def SoE(n):
    boolTable = [True for x in range(n-1)]
    primes = []
    for x in range(2,n+1):
        if boolTable[x-2]:
            i = 2
            primes.append(x)
            while x*i <= n:
                boolTable[x*i-2]=False
                i+=1
    return primes

def isPrime(n):
    for i in range(2,int(sqrt(n))):
        if not n%i:
            return False
    return True

if __name__ == "__main__":
    n = int(input().strip())
    a = list(map(int, input().strip().split(' ')))
    result = breaking_sticks(a)
    print(result)
