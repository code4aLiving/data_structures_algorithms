
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


    
    
