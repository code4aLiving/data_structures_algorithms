import sys

def equal_chocolate(a):
    #da = list(set(a))
    mini = min(a)
    A = [mini-x for x in range(5)]
    res = sys.maxsize
    for x in A:
        res = min(res,reduce(x,a))
    return res

def reduce(mini, a):
    res = 0
    for ai in a:
        x = ai - mini
        res += x//5 +(x%5)//2 + (x%5)%2
    return res

t = int(input())
for x in range(t):
    n = int(input())
    a = list(map(int,input().split(' ')))
    print(equal_chocolate(a))
