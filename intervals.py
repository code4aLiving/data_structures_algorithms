

def intervals(l):
    l = sorted(l)
    res = []
    i = 0
    while i < len(l):
        interval = l[i]
        j = i
        while j < len(l):
            jint = l[j]
            if jint[0] > interval[1]:
                break
            #merge
            s = interval[0]
            e = max(interval[1],jint[1])
            interval = (s,e)
            j+=1
        res.append(interval)
        i = j        
    return res

l = [(1,5),(2,7),(6,7),(8,10)]
print intervals(l)


