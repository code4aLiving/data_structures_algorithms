import sys

def cut_rod_recursive(p,n):
    if n == 0:
        return 0
    q = -sys.maxint
    for i in range(1,n+1):
        q = max(q,p[i] + cut_rod_recursive(p,n-i))
    return q

def cut_rod_bottom_up(p,n):
    r = [0 for x in range(n+1)]
    for j in range(1,n+1):
        q = -sys.maxint
        for i in range(1,j+1):
            q = max(q,p[i] + r[j-i])
        r[i] = q
    return r[n]

def extended_cut_rod_bottom_up(p,n):
    r = [0 for x in range(n+1)]
    s = [0 for x in range(n+1)]
    for j in range(1,n+1):
        q = -sys.maxint
        for i in range(1,j+1):
            if q < p[i] + r[j-i]:
                q = p[i] + r[j-i]
                s[j]=i
        r[i] = q
    return r,s

def print_cut_rod_solution(p,n):
    r,s = extended_cut_rod_bottom_up(p,n)
    res = []
    while n > 0:
        res.append(s[n])
        n-=s[n]
    print ' '.join(map(str,res))

p = [0,1, 5, 8, 9, 10, 17, 17, 20, 24, 30]
