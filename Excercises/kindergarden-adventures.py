
def solve(n,x):
    l = []
    intervals = []

    for i,k in enumerate(x):
        if k == n:
            continue
        s = 0
        e = 0
        if k == 0:
            e = n-1        
        elif i-k >= 0:
            e = i-k
        else:
            e = (n-1)-(k-i-1)
        s = 0 if k==0 else i+1 if i<n-1 else 0
        #print i,k,s,e
        #raw_input()
        if s>e:
            si = (s,n-1)
            ei = (0,e)
            intervals.extend([si,ei])
            l.extend([(s,0),(n-1,1),(0,0),(e,1)])
        else:
            l.extend([(s,0),(e,1)])
            intervals.append((s,e))
    l.sort()
    print intervals
    print l
    #d = {}
    maximum = 0
    current = 0
    maxi = 0
    for v,t in l:
        if t == 0:
            current+= 1
            if current > maximum:
                maximum = current
                maxi = v
        else:
            current-=1
    return maxi+1
                

n = int(raw_input())
x = map(int,raw_input().strip().split(' '))
print solve(n,x)

from random import *
import sys
def do_count(l,n):
    res = 0
    for i in range(n):
        res += 1 if l[i]-i>0 else 0
    return res

def solve2(n,a):
    res = 0
    failedKids = sys.maxint
    for i in range(n):
        l = a[i:] + a[0:i]
        c = do_count(l,n)
        #print c,failedKids
        if c < failedKids:
            failedKids = c
            res = i
        if c == 0:
            break
    return res + 1

def test():
    n = 5
    for i in range(100):
        l = []
        for i in range(5):
            l.append(randint(0,n))
        s1 = solve(n,l)
        s2 = solve2(n,l)
        if s1 != s2:
            print l,s1,s2
    
