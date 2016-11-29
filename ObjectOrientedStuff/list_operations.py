

def sum(l):
    print 'using my sum function'
    res = 0
    for x in l:
        res += x
    return res

def product(l):
    res = 1
    for x in l:
        res *= x
    return res

def factorial(n):
    return product(range(1,n+1))

def reverse(l):
    return l[::-1]

def __reverse(l):
    res = []
    for i in range(len(l)-1,-1,-1):
        res.append(l[i])
    return res
        
def min(l):
    if len(l) == 0:
        return None
    res = l[0]
    for i in range(1,len(l)):
        if res > l[i]:
            res = l[i]
    return res

def max(l):
    if len(l) == 0:
        return None
    res = l[0]
    for i in range(1,len(l)):
        if res < l[i]:
            res = l[i]
    return res

def cumulative_sum(l):
    if not l:
        return []
    res = [l[0]]
    for x in l[1:]:
        res.append(res[-1]+x)
    return res

def cumulative_product(l):
    if not l:
        return []
    res = [l[0]]
    for x in l[1:]:
        res.append(res[-1]*x)
    return res

def unique(l,key=lambda x:x):
    res = []
    keys = set()
    for x in l:
        keys.add(key(x))
    for x in l:
        if key(x) in keys:
            res.append(x)
            keys.remove(key(x))
    return res
    
def dups(l):
    res = []
    s = set()
    for x in l:
        if x in s:
            res.append(x)
        else:
            s.add(x)
    return res

def group(l,groupSize):
    groups = len(l)/groupSize + 1
    res = []
    g = 0
    while g < groups:
        start = g*groupSize
        end = start + groupSize
        res.append(l[start:end])
        g+=1
    return res

def lensort(l):
    return sorted(l,key=lambda x:len(x))

def extsort(filesList):
    return sorted(filesList,key = lambda fn:fn.split('.')[1])

