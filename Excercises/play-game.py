def solve(b):
    b.reverse()
    n = len(bricks)
    s = [0 for x in range(n+1)]
    for i in range(1,n+1):
        s[i]=s[i-1]+b[i-1]
    a1=s[1]
    a2=s[2]
    a3=s[3]
    print(a1,a2,a3)
    for i in range(4,n+1):
        a = max(s[i]-a3,s[i]-a2,s[i]-a1)
        a1=a2
        a2=a3
        a3=a
        print(i,a)
    return a3

t = int(input())
for i in range(t):
    n = int(input())
    bricks = list(map(int,input().strip().split(' ')))
    print(solve(bricks))
