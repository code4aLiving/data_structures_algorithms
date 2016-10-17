
def recursive(l,s,f,p):
    if p == 1:
        return sum(l)*(f-s+1)
    if p == len(l):
        return sum(l)
    res = 0
    for i in range(1,f-s+1-p):
        res += sum(l[s:s+i])*i + recursive(l,s+i,f,p-1)
    return res


n = int(raw_input())
l = map(int,raw_input().split(' '))
res = 0
for i in range(1,len(l)+1):
    res += recursive(l,i-1,len(l)-1,i)
print res
