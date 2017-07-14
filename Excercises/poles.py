
memory = {}

def solve(n,s,k,w,x):
    print(n,s,k)
    if (n-s,k) in memory:
        return memory[(n-s,k)]
    if k == 1:
        memory[(n-s,k)]=move(s,n-1,w,x)
        return memory[(n-s,k)]
    if k == 0 and n-s>1:
        return 10**7
    
    if k==0 or n-s==k:
        return 0

    tempRes = 10**7
    for i in range(1,n-s-k+2):
        tempRes = min(tempRes,solve(n,s+i,k-1,w,x) + move(s,s+i-1,w,x))
        #print('temp',tempRes)
    memory[(n-s,k)]=tempRes
    return tempRes

def move(a,b,w,x):
    print('move ',a,b)
    res = (sumWX[b] - sumWX[a])-x[a]*(sumW[b]-sumW[a])
    return res

n,k = tuple(map(int,input().split(' ')))
w,x=[],[]
for i in range(n):
    xi,wi = tuple(map(int,input().split(' ')))
    x.append(xi)
    w.append(wi)

sumW = [w[0] for i in range(n)]
sumWX = [x[0]*w[0] for i in range(n)]
for i in range(1,n):
    sumW[i] = sumW[i-1]+w[i]
    sumWX[i] = sumWX[i-1]+w[i]*x[i]

print(solve(n,0,k,w,x))

