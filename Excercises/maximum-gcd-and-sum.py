import math

def solve(a, b):
    divisors = {}
    for x in a:
        for d in range(1,int(math.sqrt(x))+1):
            if not x % d:
                divisors.setdefault(d,set()).add((x,'A'))
        divisors.setdefault(x,set()).add((x,'A'))
    for x in b:
        for d in range(1,int(math.sqrt(x))+1):
            if not x % d:
                divisors.setdefault(d,set()).add((x,'B'))
        divisors.setdefault(x,set()).add((x,'B'))

    keys = sorted(divisors.keys(),reverse=True)
    #print(keys)
    for k in keys:
        ma = list(map(lambda t: t[0], filter(lambda t:t[1]=='A', divisors[k])))
        mb = list(map(lambda t: t[0], filter(lambda t:t[1]=='B', divisors[k])))
        if len(ma) == 0 or len(mb) == 0:
            continue
        #print(max(ma), max(mb))
        return max(ma) + max(mb)


n = int(input())
a = list(map(int, input().split(' ')))
b = list(map(int, input().split(' ')))

print(solve(a,b))
