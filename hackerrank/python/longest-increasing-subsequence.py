
def solve_recursive_portal(a):
    return solve_recursive(a,0,len(a)-1,-1)

def solve_recursive(a,s,e,m):
    if s == e:
        return int(a[s] > m)
    if a[s] <= m:
        return solve_recursive(a,s+1,e,m)
    return max(solve_recursive(a,s+1,e,m),1 + solve_recursive(a,s+1,e,a[s]))

def solve_n2(a):
    n = len(a)
    d = {}
    d[-1] = [0 for x in range(len(a))]
    d[-1][-1] = 1
    for i in range(n):
        x = a[i]
        d[x] = [0 for x in range(n)]
        d[x][-1] = int(a[-1] > x)
    
    #general update rule
    for s in range(n-2,-1,-1):
        for k in d:
            if a[s] <= k:
                d[k][s] = d[k][s+1]
            else:
                d[k][s] = max(d[k][s+1], 1 + d[a[s]][s+1])
    return d[-1][0]

n = int(input())
a = list(map(int,input().strip().split(',')))
print(solve_recursive_portal(a))
print(solve_n2(a))
