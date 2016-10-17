def next_row(a):
    res = [a[i]^a[i+1] for i in range(len(a)-1)]
    res.append(a[-1]^a[0])
    return res
    
def smarter(a,m,n):
    a0 = list(a)
    i = 1
    rows = []
    row = []
    zeros = [0 for x in range(len(a))]
    while i < m:
        a = next_row(a)        
        if a == zeros:
            return zeros
        if len(rows) > 0 and a[:3] in rows:
            break
        rows.append(a[:3])
        i+=1
    if i == m:
        return a
    index = rows.index(a[:3])
    p = i - index -1
    r = (m-index-2)%p
    #print i,r
    a = a0
    j = 0
    while j < r + index + 1:
        a = next_row(a)
        #print a
        j+=1
    return a
    #return rows[index + r]

def brute_force(a,m):
    i = 1
    while m > 1:
        a = next_row(a)
        print i,'-', ' '.join(map(str,a))
        m-=1
        i+=1
    return a

n,m = map(int,raw_input().split(' '))
a = map(int,raw_input().split(' '))
#print ' '.join(map(str,brute_force(a,m)))
print ' '.join(map(str,smarter(a,m,n)))
