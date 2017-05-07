
from math import sqrt

'''
array is a list of integers
queries is a list of tuples (l,r)
k is the number of occurrences we are looking for
'''
def solve(array, queries, k):
    sorted_queries = mo_sorting(len(array), queries)
    print(sorted_queries)
    currentL, currentR, answer = 0,len(array)-1,[]
    m = max(array)
    counts, res = init_counts(array, m, k)
    print(counts, res, currentL, currentR)
    for l,r in sorted_queries:
        print(l,r)
        while currentL < l:
            res += remove(array, counts, k, currentL)
            currentL += 1
            print("Current L : {}, l:{}".format(currentL,l),counts,res)
        while currentL > l:
            res += add(array, counts, k, currentL)
            currentL -= 1
            print("Current L : {}, l:{}".format(currentL,l),counts,res)
        while currentR < r:
            res += add(array, counts, k, currentR)
            currentR += 1
            print("Current R : {}, r:{}".format(currentR,r),counts,res)
        while currentR > r:
            res += remove(array, counts, k, currentR)
            currentR -= 1
            print("Current R : {}, r:{}".format(currentR,r),counts,res)
        answer.append(res)
    return answer

def mo_sorting(n, queries):
    block_size = int(sqrt(n))
    return sorted(queries,key=lambda q:(q[0]//block_size,q[1]))    
    

def init_counts(array, m, k):
    counts = [0 for x in range(m+1)]
    res = 0
    for i in range(len(array)):
        counts[array[i]]+=1
        if counts[array[i]] == k:
            res +=1
    return counts,res

def add(array, counts, k, pos):
    counts[array[pos]] += 1
    if counts[array[pos]] == k:
        return 1
    return 0

def remove(array, counts, k, pos):
    counts[array[pos]] = max(0,counts[array[pos]]-1)
    if counts[array[pos]]==k-1:
        return -1
    return 0


array = [1,2,3,1,1,2,1,2,3]
queries = [(0,3),(1,7),(2,8),(7,8),(4,8),(4,4),(1,2)]

print(solve(array, queries, 3))
