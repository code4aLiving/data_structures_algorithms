
n = int(raw_input())
l = map(int,raw_input().split(' '))
ts = []
for i in range(n-2):
    for j in range(i+1,n-1):
        for k in range(j+1,n):
            #print (i,j,k)
            if l[i] + l[j] <= l[k] or l[i] + l[k] <= l[j] or l[k] + l[j] <= l[i]:
                #non triangle
                continue
            ts.append(sorted([l[i],l[j],l[k]]))
#print ts
if len(ts) == 0:
    print -1
else:
    res = sorted(ts,key=sum,reverse=True)
    print ' '.join(map(str,res[0]))

            
            
