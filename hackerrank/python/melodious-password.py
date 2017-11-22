import string

def solve(n):
    vowels = ['a','e','i','o','u']
    consonants = list(set(list(string.ascii_lowercase)) - set(vowels + ['y']))
    co = n/2
    r = n%2

    if not r:
        #n is even
        vPerm = list(permutations(vowels,co))
        print(vPerm)
        cPerm = list(permutations(consonants,co))
        print('variations done')
        res = []
        for cp in cPerm:
            for vp in vPerm:
                p = [0 for x in range(len(cp)+len(vp))]
                cpi = 0
                vpi = 0
                for i in range(len(p)):
                    if not i % 2:
                        p[i]=cp[cpi]
                        cpi+=1
                    else:
                        p[i] = vp[vpi]
                        vpi+=1                
                #p = ''.join([x+y for (x,y) in zip(vp,cp)])
                res.append(''.join(p))
                res.append(''.join(p[::-1]))
    return res

def permutations(l,k):
    if k == 0:
        yield ''
    else:
        for x in l:
            for p in permutations(l,k-1):
                yield x + p

def variations3(l):
    print(l)
    res = []
    for x in l:
        for y in l:
            for z in l:
                res.append('{}{}{}'.format(x,y,z))
    return res
            

n = int(input())
print('\n'.join(solve(n)))
    
