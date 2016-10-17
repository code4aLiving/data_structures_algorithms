import math

def do(a,m,n):
    #a.extend(a)
    #a = [a[x]^a[x+1] for x in range(n)]
    #print a
    m-=1
    while m > 0:
        k = int(math.log(m,2))
        shift = 2**k % n
        a.extend(a)
        a = [a[x]^a[x+shift] for x in range(n)]
        #print k, a
        m = m - 2**k

    return a

def brute_force(a,m,n):
    i = 0
    while m > 1:
        print i+1,'-', ' '.join(map(str,a))
        a.extend(a)
        a = [a[x]^a[x+1] for x in range(n)]
        m-=1
        i+=1
    print i+1,'-', ' '.join(map(str,a))
    return a

n,m = map(int,raw_input().split(' '))
a = map(int,raw_input().split(' '))
print ' '.join(map(str,do(a,m,n)))
#print brute_force(a,m,n)
