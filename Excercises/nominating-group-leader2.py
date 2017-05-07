
memory = {}
def solve(n,v,groups):
    res = []
    for (l,r,x) in groups:
        if (l,r) in memory:
            votes = memory[(l,r)]
        else:
            votes = {}
            for i in range(l,r+1):
                votes[v[i]] = votes.setdefault(v[i],0) + 1
                #if (l,i) not in memory:
                    #memory[(l,i)] = dict(votes)

        winner = -1
        for student,vote in votes.items():
            if vote == x:
                if winner < 0 or winner > student:
                    winner = student
        res.append(winner)
    return res


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
        
    res = list(map(str,solve(n,v,groups)))
    print('\n'.join(res))
