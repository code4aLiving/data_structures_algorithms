from heapq import *
from bisect import bisect

## To solve this with the running mean is necessary to have a custom priority queue 
# that allows removing elements.
def solve_running_mean(a, d):
    a = [(a[i],i) for i in range(len(a))]
    res = 0
    ta = sorted(a[:d])
    min_queue = [(-x,i) for (x,i) in ta[:len(ta)//2]]
    heapify(min_queue)
    max_queue = ta[len(ta)//2:]
    heapify(max_queue)
    len_max_queue = d//2 + 1 if d % 2 else d // 2
    len_min_queue = d//2 

    for i in range(d, len(a)):
        mean = max_queue[0][0] if d%2 else (max_queue[0][0] - min_queue[0][0]) / 2
        if a[i][0] >= mean*2:
            res += 1
        
        # add the new element to the correct heap depending on its value respectively to the mean
        if a[i][0] > mean:
            heappush(max_queue, (a[i][0],i))
        else:
            heappush(min_queue, (-a[i][0],i))
        
        rebalance_heaps(max_queue, min_queue)   
                
    return res

def remove_old_values(q, i, d):
    while len(q) > 0 and q[0][1] <= i - d:
        heappop(q)

def rebalance_heaps(max_queue, min_queue):
    while abs(len(max_queue) - len(min_queue)) > 1:
        if len(max_queue) > len(min_queue):
            v,index = heappop(max_queue)
            heappush(min_queue, (-v,index))
        else:
            v,index = heappop(min_queue)
            heappush(max_queue, (-v, index))

def solve_slow(a, d):
    res = 0
    for i in range(len(a)-d):
        s = sorted(a[i:i+d])
        mean = s[len(s)//2] if d%2 else (s[len(s)//2] + s[len(s)//2 + 1])/2
        if (a[i + d] >= mean*2):
            res+=1
    return res

## This is cheating
def solve2(n, a, d):
    res = 0
    s = sorted(a[:d])
    for i in range(n-d):
        cur_val = a[d + i]
        median2 = s[d//2] * 2 if d%2 else s[d//2] + s[d//2-1]
        if cur_val >= median2:
            res+=1
        to_delete = a[i]
        to_add = cur_val
        x = bisect(s, to_delete)
        s.pop(x-1)
        x = bisect(s, to_add)
        s.insert(x, to_add)
    return res

def solve_bucket_sort(n, a, d):
    bucket = [0 for x in range(201)]
    for i in range(d):
        bucket[a[i]] += 1
    
    res = 0
    for i in range(n-d):
        to_add = a[d + i]
        to_delete = a[i]
        median2 = median2_from_bucket(bucket, d)
        if to_add >= median2:
            res+=1
        bucket[to_delete]-=1
        bucket[to_add]+=1
    return res

def median2_from_bucket(bucket, d):
    low_med, high_med = 0,0
    cum = 0
    for i in range(len(bucket)):
        cum += bucket[i]
        if cum >= d // 2 and low_med == 0:
            low_med = i
        if cum >= d // 2 + 1 and high_med == 0:
            high_med = i
        if low_med and high_med:
            break
    if d % 2:
        return high_med * 2
    return low_med + high_med
        
if __name__ == "__main__":
    n, d = tuple(map(int, input().split(" ")))
    a = list(map(int, input().split(" ")))
    # print(solve2(n, a, d))
    print(solve_bucket_sort(n,a,d))