

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
                if (l,i) not in memory:
                    memory[(l,i)] = dict(votes)

        winner = -1
        for student,vote in votes.items():
            if vote == x:
                if winner < 0 or winner > student:
                    winner = student
        res.append(winner)
    return res


'''
tree is a list of len 2*len(v) - 1
'''
def build_segment_tree(v, s, e, pos):
    #print(s,e,pos)
    if s == e:
        tree[pos] = ({v[s] : 1},(s,e))
        qtree[pos] = {1:set([v[s]])}
        return tree[pos]

    (left,(ls,le)) = build_segment_tree(v, s, (s + e)//2, 2*pos+1)
    (right,(rs,re)) = build_segment_tree(v, (s + e)//2 + 1, e, 2*pos+2)
    d = dict(left)
    for key,value in right.items():
        d[key] = d.setdefault(key,0) + value
    tree[pos] = (d,(s,e))
    qd = {}
    for key, value in d.items():
        if value in qd:
            qd[value].add(key)
        else:
            qd[value] = set([key])
            
        
    #print(qd)
    qtree[pos]=qd
    return tree[pos]

memory = {}

def query_tree(l, r, tree, pos, s, e):
    if (l,r) in memory:
        return memory[(l,r)]
    if l == s and r == e:
        #print('Stored result {}'.format(qtree[pos]))
        return qtree[pos]
        #return tree[pos]
    
    segment,(ss,se) = tree[pos]
    middle = (ss + se)//2
    if r <= middle:
        return query_tree(l, r, tree, pos*2 + 1, s, middle)
    elif l > middle:
        return query_tree(l, r, tree, pos*2 + 2, middle + 1, e)
    qleft = query_tree(l, middle, tree, pos*2 + 1, s, middle)
    qright = query_tree(middle + 1, r, tree, pos*2 + 2, middle+1, e)
    d = {}
    for keyl,valuel in qleft.items():
        for keyr, valuer in qright.items():
            d[keyl] = d.setdefault(keyl, set()).union(valuel.difference(valuer))
            d[keyr] = d.setdefault(keyr, set()).union(valuer.difference(valuel))
            d[keyl + keyr] = d.setdefault(keyr+keyl, set()).union(valuel.intersection(valuer))

    memory[(l,r)]=d    
    return d


t = int(input().strip())
for a0 in range(t):
    n = int(input().strip())
    v = list(map(int, input().strip().split(' ')))
    g = int(input().strip())
    groups = []
    memory = {}
    tree = [None for x in range(10**7)]
    qtree = [None for x in range(10**7)]
    build_segment_tree(v, 0, len(v)-1, 0)
    
    for a1 in range(g):
        l,r,x = input().strip().split(' ')
        l,r,x = [int(l),int(r),int(x)]
        groups.append((l,r,x))
        d = query_tree(l, r, tree, 0, 0, len(v)-1)
        #print(d)
        #print(qtree)
        s = d.get(x,set([-1]))
        #print(s)
        print(-1 if not len(s) else min(s))
    
    #for r in solve(n,v,groups):
        #print(r)
    
