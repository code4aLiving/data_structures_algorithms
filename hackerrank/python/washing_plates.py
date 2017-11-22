def wash_dishes(n,k,p,d):
    table = [[0 for x in range(n+1)] for y in range(k+1)]
    dsum = [0 for x in range(n+1)]
    for i in range(1,n+1):
        table[0][i]= table[0][i-1] - d[i-1]
        
    for y in range(1,k+1):
        for x in range(1,n+1-k+y):
            table[y][x] = max(table[y-1][x-1] + p[x-1],table[y][x-1] - d[x-1])
    return max(0,table[k][n])

def wash_dishes_mem_efficient(n,k,p,d):
    table = [0 for x in range(n+1)]
    dsum = [0 for x in range(n+1)]
    for i in range(1,n+1):
        table[i]= table[i-1] - d[i-1]

    for y in range(1,k+1):
        newTable = [0]
        for x in range(1,n+1-k+y):
            newTable.append(max(table[x-1] + p[x-1],newTable[x-1]-d[x-1]))
        table = newTable
    return max(0,table[-1])


    
n,k = map(int,raw_input().split(' '))
k = min(k,n)
p = []
d = []
pMinusSumOfd = []
for i in range(n):
    pi,di = map(int,raw_input().split(' '))
    p.append(pi)
    d.append(di)

sumd = sum(d)
for i,v in enumerate(p):
    pMinusSumOfd.append((v - sumd + d[i],i))
pMinusSumOfd = sorted(pMinusSumOfd,reverse=True)
#print pMinusSumOfd
res = sum(map(lambda x:p[x[1]],pMinusSumOfd[:k])) - sum(map(lambda x:d[x[1]],pMinusSumOfd[k:]))
print max(res,0)
#print wash_dishes_mem_efficient(n,k,p,d)
