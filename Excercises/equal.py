

def equal_chocolate(a):
    #da = list(set(a))
    a.sort()
    res = 0
    for i in range(len(a)-1):
        res += reduce(a,i)
        print(a)
    return res

def reduce(a,i):
    maxi = a[i+1]
    mini = a[i]
    res5 = (maxi-mini)//5
    maxi -= res5*5
    res = res5
    print(res)
    res2 = (maxi-mini)//2
    maxi -= res2*2
    res += res2
    print(res)
    res += maxi - mini
    a[i+1]=mini
    print(res)
    return res
    

t = int(input())
for x in range(t):
    n = int(input())
    a = list(map(int,input().split(' ')))
    print(equal_chocolate(a))
