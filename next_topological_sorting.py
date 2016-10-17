
def buckets(g,inverseG):
    res = []
    q = sorted([(x,0) for x in g.keys() if x not in inverseG])
    visited = set([x for x,y in q])
    buckets = []
    #print q,g,inverseG
    while len(q)>0:
        node,b = q.pop(0)
        if len(buckets) <= b:
            buckets.append(set())
        buckets[b].add(node)
        if not g.has_key(node):
            continue
        for child in g[node]:
            if child in visited:
                continue
            visited.add(child)
            q.append((child,b+1))
    #print buckets
    return [len(x) for x in buckets]
        
def next_greater(l):
    l = list(l)
    if len(l) <= 1:
        return l,0
    i = len(l) - 1
    while i>0:
        if l[i] > l[i-1]:
            break
        i-=1
    if i == 0:
        #is already the max
        return l,i
    temp = l[i-1]
    tail = l[i:]
    tail.reverse()
    for j,x in enumerate(tail):
        if x > temp:
            l[i-1]=tail[j]
            tail[j]=temp
            break
    res = l[:i] + tail
    return res,i

def next_topological(buckets,p):
    buckets.reverse()
    skip = 0
    res = []
    #print buckets
    for b in buckets:
        l = []
        if skip == 0:
            l = p[-b:]
        else:
            l = p[-skip-b:-skip]
        
        ng,i = next_greater(l)
        if i==0:
            ng.reverse()
            res = ng + res
            #print b,l,skip,res
            skip += b
            continue
        #print res,-skip-b,ng
        res = p[:-skip-b] + ng + res
        return res
    return res
        

n,m = map(int,raw_input().split(' '))
g = {}
for i in range(1,n+1):
    g[i] = []
inverseG = set()
for i in range(m):
    u,v = map(int,raw_input().split(' '))
    g[u].append(v)
    inverseG.add(v)

p = map(int,raw_input().split(' '))
#print p
ng,j = next_greater(p)
#print ng,j
if j == 0:
    print -1
else:
    buckets = buckets(g,inverseG)
    #print buckets
    res = next_topological(buckets,p)
    if res == p:
        print -1
    else:
        print ' '.join(map(str,res))
