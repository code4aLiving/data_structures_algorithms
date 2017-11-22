from heapq import *

def max_heappush(heap, v):
    heap.append(v)
    #print('pushup',v,heap)
    pushup(heap)

def max_heappop(heap):
    if len(heap)==0:
        raise Exception()
    if len(heap)==1:
        return heap.pop(0)
    res = heap[0]
    heap[0] = heap[-1]
    pushdown(heap)
    return res

def pushup(heap):
    if len(heap)<=1:
        return
    i = len(heap)-1
    while (i-1)/2>=0:
        if heap[i] > heap[int((i-1)/2)]:
            temp = heap[i]
            heap[i] = heap[int((i-1)/2)]
            heap[int((i-1)/2)] = temp
            i = (i-1)//2
            continue
        return

def pushdown(heap):
    n = len(heap)
    if n <= 1:
        return
    i = 0
    while 2*i + 1 < n:
        if 2*i+2 < n:
            #left and right child
            if heap[i] < heap[2*i+1] or heap[i] < heap[2*i+2]:
                #heap condition is violated
                if heap[2*i+1] >= heap[2*i+2]:
                    temp = heap[i]
                    heap[i] = heap[2*i+1]
                    heap[2*i+1]=temp
                    i = 2*i+1
                else:
                    temp = heap[i]
                    heap[i] = heap[2*i+2]
                    heap[2*i+2]=temp
                    i = 2*i+2
                continue
        else:
            #only left child
            if heap[i] < heap[2*i+1]:
                #heap condition is violated
                temp = heap[i]
                heap[i] = heap[2*i+1]
                heap[2*i+1]=temp
                i = 2*i+1
                continue
        return  
        

def median_list(a):
    max_heap = []
    min_heap = []
    res = []
    for i,v in enumerate(a):
        if len(max_heap) == 0:
            max_heappush(max_heap,v)
            res.append(v)
            continue
        
        if v <= max_heap[0]:
            if len(max_heap) > len(min_heap):
                heappush(min_heap,max_heappop(max_heap))
            max_heappush(max_heap,v)
        else:
            if len(min_heap)>len(max_heap):
                max_heappush(max_heap,heappop(min_heap))
            heappush(min_heap,v)

        if len(min_heap) > len(max_heap):
            res.append(min_heap[0])
        else:
            res.append(max_heap[0])
        #print(max_heap,min_heap)   
    return res

l = map(int,input().split(' '))
print(median_list(l))
