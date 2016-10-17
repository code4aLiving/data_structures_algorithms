
class MemObject(object):
    def __init__(self,n,coins):
        self.n = n
        self.coins = list(coins)
    def __hash__(self):
        res = n
        for x in self.coins:
            res ^= x
        return res
    def __eq__(self,other):
        return self.n == other.n and set(self.coins)==set(other.coins)
    
    def __str__(self):
        return str(self.n) + ' ' + self.coins.__str__()

memory = {}
def change_memoize(n,c):
    if n == 0:
        memory[MemObject(n,c)] = 1
        return 1
    if len(c)==0:
        memory[MemObject(n,c)]=0
        return 0
    res = 0
    cj = c.pop(0)
    for i in range(n/cj + 1):
        memObject = MemObject(n-(cj*i),c)
        if memory.has_key(memObject):
            #print 'memoized'
            res += memory[memObject]
        else:
            temp = change_memoize(n-(cj*i),list(c))
            memory[memObject] = temp
            res += temp
    return res

def change_recursive(n,c):
    #print n,c
    if n == 0:
        return 1
    if len(c) == 0:
        return 0    
    res = 0
    cj = c.pop(0)
    for i in range(n/cj + 1):
        res += change_recursive(n-(cj*i),list(c))       
    return res
    
n,m = map(int, raw_input().split(' '))
c = map(int,raw_input().split(' '))
#print change_recursive(n,sorted(c,reverse=True))
print change_memoize(n,sorted(c,reverse=True))
