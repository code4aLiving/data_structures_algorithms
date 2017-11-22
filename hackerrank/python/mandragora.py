from collections import deque
def do(n,h):
    s = 1
    p = 0
    res = 0
    #q = deque(sorted(h))
    h = sorted(h)
    hSum = sum(h)
    res = hSum

    for first in h:
        s += 1
        hSum -= first
        tempRes = hSum * s
        #if improved save the result
        if tempRes < res:
            return res
        res = max(res,tempRes)
    return res


t = int(raw_input())
for i in range(t):
    n = int(raw_input())
    h = map(int,raw_input().split(' '))
    print do(n,h)
