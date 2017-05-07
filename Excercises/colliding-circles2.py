import math
import random


def simulate(r,k):
    for i in range(k):
        a = random.randint(0,len(r)-1)
        while r[a]==0:
            a = random.randint(0,len(r)-1)
        b = random.randint(0,len(r)-1)
        while b == a or r[b]==0:
            b = random.randint(0,len(r)-1)
        r[a]+=r[b]
        r[b]=0

    return math.pi*sum([x**2 for x in r])


n,k = input().strip().split(' ')
n,k = [int(n),int(k)]
r = list(map(int, input().strip().split(' ')))
mres = 0
for i in range(10):
    res = 0
    iterations = 10000
    for i in range(iterations+1):
        rCopy = list(r)
        res += simulate(rCopy,k)
    mres+=res/iterations
    #print(res/iterations)

print(mres/10)
