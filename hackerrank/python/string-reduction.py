#!/usr/bin/py
# Head ends here

letters = set(['a','b','c'])
def stringReduction(a):
    res = len(a)
    q = [a]
    visited = set([a])
    while len(q):
        x = q.pop(0)
        print(x)
        if len(x)==1:
            return 1
                
        for i in range(len(x)-1):
            if a[i] == a[i+1]:
                continue
            letter = list(letters.difference(set([x[i],x[i+1]])))[0]
            aa = x[:max(i,0)] + letter + x[i+2:]
            print(aa)
            if aa not in visited:
                q.append(aa)
                res = min(res,len(aa))
    return res
    
    
# Tail starts here
if __name__ == '__main__':
    t = int(input())
    for i in range(0,t):
        a=input()
        print(stringReduction(a))
