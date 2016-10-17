

n = int(raw_input())
b = map(int,raw_input().split(' '))
m = int(raw_input())
lasers = map(int,raw_input().split(' '))

#print b
#print lasers
#sort the lasers
lasers = sorted(lasers)
lastLaser = 0
for l in lasers:
    for i in range(lastLaser,l-1):
        y = -(i+1) + l
        #print l,b[i],y
        #raw_input()
        b[i] = min(b[i],y)
    lastLaser = l-1

#print b
print sum(b)
