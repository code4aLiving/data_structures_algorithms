
from bisect import *

## This is n*logn however, although it passes all test cases this can be done in O(n)
## Also memory can be reduced by having a bitmap instead of an array of integers
def solve(a, k):
    n = len(a)
    plants = [i for i in range(n) if a[i]>0]
    i = 0
    res = 0
    p = []
    while(i < n):
        plant = find_lt(plants, i + k)
        if abs(i-plant) >= k:
            return -1
        res+=1
        p.append(plant)
        i = plant + k
    return res, p

## O(n) solution. Same as editorial.
def solveOn(a, k):
    n = len(a)
    res = 0
    i = 0
    j = i + k - 1
    while j > i - k  and i < n:
        if a[j]:
            # found a suitable place for a plant
            res += 1
            i = j + k
            j = min(i + k - 1, n-1)
        else:
            j-=1
    
    if i >= n:
        return res
    return -1


def find_lt(a, x):
    'Find rightmost value less than x'
    i = bisect_left(a, x)
    if i:
        return a[i-1]
    return -1

if __name__ == "__main__":
    _, k = tuple(map(int, input().split(" ")))
    a = list(map(int, input().split(" ")))
    print(solve(a, k))
    print(solveOn(a, k))