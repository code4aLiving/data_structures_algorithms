import math

def solve(ns):
    ns = sorted(ns)
    mn = ns[-1]
    table = [0 for x in range(mn)]
    d = {}
    #fill dict
    for i in range(1, min(5,mn) + 1):
        for x in range(10**(i-1), 10**i):
            if full_fill_condition(x):
                if i == 5:
                    d[x%10000] = d.setdefault(x%10000, 0) + 1
                table[i-1]+=1
        table[i-1] %= (10**9 + 7)
    
    #print(d)
    for i in range(5,mn):
        newd = {}
        for k in d:
            for j in range(10):
                kl = list(map(int, list(str(k))))
                sk4 = sum(kl)
                sk3 = sum(kl[1:])
                sk2 = sum(kl[2:])
                if is_prime(sk4+j) and is_prime(sk3+j) and is_prime(sk2+j):
                    newd[(k*10 + j)%10000] = newd.setdefault((k*10 + j)%10000,0) + d[k] % (10**9 + 7)
                    table[i] += d[k] % (10**9 + 7)
        table[i] %= (10**9 + 7)
        d = newd
    print(table)
    for n in ns:
        print(table[n-1])
            
    

def full_fill_condition(x):
    xl = list(map(int, list(str(x))))
    if x >= 10**4:
        for i in range(len(xl)-4):
            if not is_prime(sum(xl[i:i+5])):
                #print(xl[i:i+5])
                return False
    if x >= 10**3:
        for i in range(len(xl)-3):
            if not is_prime(sum(xl[i:i+4])):
                #print(xl[i:i+4])
                return False
    if x >= 10**2:
        for i in range(len(xl)-2):
            if not is_prime(sum(xl[i:i+3])):
                #print(xl[i:i+3])
                return False
    return True
    
def is_prime(p):
    if p<2:
        return False
    s = int(math.sqrt(p))
    for i in range(2,s):
        if not p % i:
            return False
    return True

q = int(input())
ns = []
for i in range(q):
    n = int(input())
    ns.append(n)
solve(ns)
