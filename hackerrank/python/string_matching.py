
def prefix(s):
    m = len(s)
    s = list('x' + s)
    p = [-1 for x in range(m+1)]
    k = -1
    for i in range(1,m+1):
        while k >= 0 and s[k+1] != s[i]:
            k = p[k]
        k+=1
        p[i]=k
    return p

def kmp_matcher(p,t):
    n = len(t)
    m = len(p)
    pi = prefix(p)
    p = ' '+p
    #print(pi)
    q = 0
    res = []
    for i in range(n):
        while q>0 and p[q+1] != t[i]:
            print('mismatch at',q,i,pi[q])
            q = pi[q]
        if p[q+1] == t[i]:
            print(q,i,p[q+1],t[i])
            q+=1
        if q==m:
            res.append(i-m+1)
            print('pattern found at',i-m+1,q,i)
            q = pi[q]
    return res
        
            
        
def kmp_test():
    patterns = ['ab','a','x','abababaaa']
    texts = ['abababaa'] * 4
    for i in range(4):
        print(kmp_matcher(patterns[i],texts[i]))
                
