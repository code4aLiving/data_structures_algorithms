
def hack_rec(n):
    if n ==1 :
        return 1
    if n == 2:
        return 2
    if n == 3:
        return 3
    return 1*hack_rec(n-1) + 2*hack_rec(n-2) + 3*hack_rec(n-3)

def hackonacci(n):
    h1 = 1
    h2 = 2
    h3 = 3
    if n == 1:
        return h1
    elif n == 2:
        return h2
    elif n==3:
        return h3
    res = 0
    for i in xrange(4,n+1):
        #print h3,h2,h1
        res = h3 + 2*h2 + 3*h1
        h1 = h2
        h2 = h3
        h3 = res
        #print i,res
    return res

def get_hackonacci_matrix_entry(k):
    r7 = k%7
    if r7 in set([1,6,0]):
        return 'Y'
    return 'X'
        

def solve(n,alpha):
    if alpha == 0:
        return 0
    res = 0
    for row in xrange(1,n/2+1):
        end = n-row+1
        #print end
        for col in xrange(row,end):
            v0 = get_hackonacci_matrix_entry(row*col)
            v90 = get_hackonacci_matrix_entry(col*(n-row+1))
            v180 = get_hackonacci_matrix_entry((n-row+1)*(n-col+1))         
            v270 = get_hackonacci_matrix_entry((n-col+1)*row)
            v = [v0,v90,v180,v270]
            #print row,col,v
            #print '270',(n-row+1),(n-col+1)
            if alpha == 90 or alpha == 270:
                for i in range(3):
                    if v[i]!=v[i+1]:
                        res+=1
                if v[0]!=v[-1]:
                    res+=1
                                
                #print res
            else:
                for i in range(2):
                    if v[i]!=v[i+2]:
                        res+=2
                #print res
    return res

n,q = map(int,raw_input().split(' '))
resDict = {}
for x in xrange(q):
    alpha = int(raw_input())
    alpha %= 360
    #print alpha
    if resDict.has_key(alpha):
        print resDict[alpha]
    else:
        resDict[alpha]=solve(n,alpha)
        print resDict[alpha]
    
    
