import math

def gcd(a,b):
    r = a % b
    while r > 0:
        #print a, b, r
        a, b, r = b, r, b%r
    return b

def isolve(a,b,c):
    q, r = divmod(a,b)
    if r == 0:
        return(0,c/b,b)
    else:
        sol = isolve(b,r,c)
        u = sol[0]
        v = sol[1]
        d = sol[2]
    return (v, u - q*v, d)

def solve(n):
    res = set()
    ab = xrange(1,n+1)
    for i in range(len(ab)/2):
        a = ab[i]
        for j in range(i+1,len(ab)):
            b = ab[j]
            if a+b > n:
                break
##            d = gcd(a,b)
##            if n%d>0:
##                continue
            (x,y,d) = isolve(a,b,n)
            #print a,b,x,y,d
            if n % d > 0:
                continue
##            if a == 3 and b == 6:
##                print d,x,y
            if (x > 0 and y > 0) or \
               math.ceil(y*d/float(a)) - math.floor(-x*d/float(b)) > 1:
                res.add((a,b))
                    
##    print sorted(list(res))
    return len(res)


n = int(raw_input())
print solve(n)
