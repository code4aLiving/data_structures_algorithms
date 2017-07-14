





t = int(input().strip())
for a0 in range(t):
    n = int(input().strip())
    v = list(map(int, input().strip().split(' ')))
    g = int(input().strip())
    groups = []
    memory = {}
            
    for a1 in range(g):
        l,r,x = input().strip().split(' ')
        l,r,x = [int(l),int(r),int(x)]
        groups.append((l,r,x))
        
    res = []
    for r in solve(n,v,groups):
        res.append(str(r))
    print('\n'.join(res))
