

def min_pattern_len(s):
    ls = len(s)
    for i in range(1,ls):
        pattern = s[:i]
        c = s.count(pattern)
        if ls == i * c:
            return i
    return ls

def min_pattern_len_improved(s):
    f = compute_prefix_function(s)
    #print f
    n = len(s)
    i = len(f)-1
    res = n
    while i > 0:
        #print i, f[i], n - f[i]
        if f[i]==0:
            return res
        if n % f[i] == 0:
            res = f[i]
            #print 'res',res
        i = f[i]-1
    return res
                
    

def compute_prefix_function(s):
    m = len(s)
    f = [0] * m
    k = 0
    for q in range(1,m):
        while k > 0 and s[k] != s[q]:
            k = f[k]
        if s[k] == s[q]:
            k = k + 1
        f[q] = k
    return f

s = raw_input()
m = int(raw_input())

#mpl = min_pattern_len(s)
mpl2 = min_pattern_len_improved(s)
#print m/mpl
print m/mpl2
        
