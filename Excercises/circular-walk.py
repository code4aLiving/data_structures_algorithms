import sys

def compute_r(n, r0, g, seed, p):
    r = [r0 for x in range(n)]
    for i in range(1,n):
        r[i] = (r[i-1] * g + seed) % p
    #print(r)
    return r

def circularWalk(n, s, t, r_0, g, seed, p):
    # Complete this function
    if s == t:
        return 0
    left,right = s+n,s+n
    r = compute_r(n, r_0, g, seed, p)
    q = [(s+n,0)]
    while len(q):
        #print(left,right,q)
        current, d = q.pop(0)
        currentLeft = current - r[current % n]
        currentRight = current + r[current % n]

        rr = currentRight % n
        rl = currentLeft % n
        #print(rl,rr,t)
        if rl > rr and (t >= rl or t <= rr):
            return d+1
        elif t >= rl and t <= rr:
            return d+1
                
        for i in range(currentLeft,left):
            q.append((i, d+1))
        for i in range(right + 1, currentRight + 1):
            q.append((i, d+1))
        #print(q)
        left = min(currentLeft, left)
        right = max(currentRight, right)
    return -1

n, s, t = input().strip().split(' ')
n, s, t = [int(n), int(s), int(t)]
r_0, g, seed, p = input().strip().split(' ')
r_0, g, seed, p = [int(r_0), int(g), int(seed), int(p)]
result = circularWalk(n, s, t, r_0, g, seed, p)
print(result)
