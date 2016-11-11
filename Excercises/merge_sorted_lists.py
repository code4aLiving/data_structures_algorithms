from heapq import *

def merge_sorted_lists(lists):
    #build heap with the first elements of the list
    heap = []
    for i,l in enumerate(lists):
        if len(l)>0:
            heap.append((l[0],i))
            l.pop(0)
    
    heapify(heap)
    res = []
    while len(heap)>0:
        v,li = heappop(heap)
        res.append(v)
        if len(lists[li])>1:
            heappush(heap,(lists[li].pop(0),li))
    return res

n = int(input())
lists = []
for i in range(n):
    lists.append(list(map(int,input().split(' '))))

print(merge_sorted_lists(lists))
