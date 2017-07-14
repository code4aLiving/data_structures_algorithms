import sys

def compute_r(n, r0, g, seed, p):
    r = [r0 for x in range(n)]
    for i in range(1,n):
        r[i] = (r[i-1] * g + seed) % p
    #print(r)
    return r

def get_adjs(r, n, current, visited):
    adjs = set()
    for i in range(1,r[current]+1):
        vplus = (current + i)%n
        vmin = (current - i)%n
        if vplus not in visited:
            adjs.add(vplus)
        if vmin not in visited:
            adjs.add(vmin)
    return adjs

def get_interval(r, n, current):
    if r[current] >= n:
        return (n,0)
    left = (current-r[current])%n
    right = (current+r[current])%n
    return (left, right)

def is_in_interval(interval,value):
    #print(interval,value)
    l, r = interval
    if l > r:
        #print("left greater",l,r,value)
        return value >= l or value <= r
    elif l < r:
        #print("left smaller",l,r,value)
        return value >= l and value <= r
    elif l == r:
        #print("equals",l,r,value)
        return value == l
    return False
        

def circularWalk(n, s, t, r_0, g, seed, p):
    # Complete this function
    if s == t:
            return 0
    r = compute_r(n, r_0, g, seed, p)
    si = get_interval(r, n, s)
    q = [(si,1)]
    visited = set([s])
    while len(q):
        interval, d = q.pop(0)
        #print(interval)
        if is_in_interval(interval,t):
            #print(t ,"is in interval", interval)
            return d
        
        if interval[0] > interval[1]:
            for i in range(interval[0],n):
                if i not in visited:
                    q.append((get_interval(r, n, i),d+1))
                    visited.add(i)
            for i in range(interval[1]+1):
                if i not in visited:
                    q.append((get_interval(r, n, i),d+1))
                    visited.add(i)
        else:
            for i in range(interval[0],interval[1]+1):
                if i not in visited:
                    q.append((get_interval(r, n, i),d+1))
                    visited.add(i)            
    return -1

n, s, t = input().strip().split(' ')
n, s, t = [int(n), int(s), int(t)]
r_0, g, seed, p = input().strip().split(' ')
r_0, g, seed, p = [int(r_0), int(g), int(seed), int(p)]
#print(n,s,t)
result = circularWalk(n, s, t, r_0, g, seed, p)
print(result)
