n = int(raw_input())
b = map(int,raw_input().split(' '))
res = 0
for i in range(n-1):
    if b[i]%2==0:
        continue
    b[i]+=1
    b[i+1]+=1
    res+=2

if len([x for x in b if x%2>0]) == 0:
    print res
else:
    print 'NO'

