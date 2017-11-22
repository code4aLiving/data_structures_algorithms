def intervals(l):
    l = sorted(l)
    res = []
    i = 0
    while i < len(l):
        interval = l[i]
        j = i
        while j < len(l):
            jint = l[j]
            if jint[0] > interval[1]:
                break
            #merge
            s = interval[0]
            e = max(interval[1],jint[1])
            interval = (s,e)
            j+=1
        res.append(interval)
        i = j        
    return res

n,m,k = map(int,raw_input().strip().split(' '))
d = {}
for i in range(k):
    r,s,f = map(int,raw_input().split(' '))
    if d.has_key(r):
        d[r].append((s,f))
    else:
        d[r]=[(s,f)]

res = n * m
for key in d:
    lintervals = intervals(d[key])
    for i in lintervals:
        res -= i[1]-i[0]+1
print res
