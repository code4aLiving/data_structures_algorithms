
import sys
import math

def solve(n, k, r):
    r = sorted(r)
    area,c = solve_exp(n, k, tuple(r))
    #print(memory)
    return area/c


memory = {}

def solve_exp(n, k, r):
    h = hash(r)
    if (h,k) in memory:
        return memory[(h,k)]
    
    #print(n, k, r)
    if not k:
        area = math.pi * sum([x**2 for x in r])
        #print(r,area)
        memory[(hash(r),k)] = (area,1)
        return (area,1)
    area = 0
    c = 0
    newr = [x for x in r]
    for i in range(n):
        if not newr[i]:
            continue
        for j in range(i+1,len(newr)):
            if not newr[j]:
                continue
            #print(i,j,newr,n)
            newr[i]+= r[j]
            newr[j]=0
            newt = tuple(sorted([x for x in newr if x > 0]))
            if (hash(newt),k-1) in memory:
                #print('Found in memory {}{} {}'.format(newt,k,memory[(hash(newt),k-1)]))
                (a,count) = memory[(hash(newt),k-1)]
                c += count
                area += a
            else:
                a,count = solve_exp(n-1,k-1,newt)
                #memory[(hash(newt),k)] = tempArea,count
                area += a
                c += count
                         
            newr[i]=r[i]
            newr[j]=r[j]
            #print("Area {}, Count {}".format(area,c))
                        
    memory[(h,k)]=(area,c)
    return (area,c)
            
    



def combinations(n, k, s):
    if not k or n-s < k:
        yield set()
    else:
        for comb in combinations(n, k-1, s+1):
            yield set([s]).union(comb)
        if n-s > k:
            for comb in combinations(n, k, s+1):
                yield comb

            
        

n,k = input().strip().split(' ')
n,k = [int(n),int(k)]
r = list(map(int, input().strip().split(' ')))
print('{0:.10f}'.format(solve(n, k, r)))

