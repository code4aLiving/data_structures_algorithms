import sys

def getMaxMonsters(n, hit, t, h):
    print(h,hit,t)
    h.sort()
    res = 0
    i = 0
    print(h)
    while(t > 0 and i < len(h)):
        r = h[i]%hit
        c = h[i]//hit
        #print(c,r,c + int(r>0))
        t -= c + int(r>0)
        if t >= 0:
            res+=1
        i+=1
    return res
        
    # Complete this function

n, hit, t = input().strip().split(' ')
n, hit, t = [int(n), int(hit), int(t)]
h = list(map(int, input().strip().split(' ')))
result = getMaxMonsters(n, hit, t, h)
print(result)
