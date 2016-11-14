
def swap(a,i,j):
    temp = a[i]
    a[i] = a[j]
    a[j] = temp

def buble_sort(a):
    isSorted = False
    n = len(a)-1
    while not isSorted:
        isSorted = True
        for i in range(n):
            if a[i] > a[i+1]:
                swap(a,i,i+1)
                isSorted = False
        n-= 1

def quicksort(a):
    __quicksort__(a,0,len(a)-1)    

def __quicksort__(a,left,right):
    if left >= right:
        return
    pivot = a[(left+right)/2]
    index = __partition__(a,left,right,pivot)

    #the indexing has to be like this because
    #the partition method only stops when left and right
    #overtake each other left > right
    __quicksort__(a,left,index-1)
    __quicksort__(a,index,right)

def __partition__(a,left,right,pivot):
    while left <= right:
        while a[left] < pivot:
            left+=1            
        while a[right] > pivot:
            right-=1
        if left <= right:
            swap(a,left,right)
            left+=1
            right-=1
    return left

def mergesort

def mergesort(a):
    if len(a) == 1:
        return a
    half = len(a)/2
    left = mergesort(a[0:half])
    right = mergesort(a[half:])    
    return merge(left,right)

def merge(left,right):
    mergedList = []
    i = 0
    j = 0
    while i<len(left) or j<len(right):
        if i==len(left):
            mergedList.extend(right[j:])
            break
        elif j == len(right):
            mergedList.extend(left[i:])
            break        
        if left[i] <= right[j]:
            mergedList.append(left[i])
            i+=1
        else:
            mergedList.append(right[j])
            j+=1
    return mergedList

def test_sorting_algorithm(f,a=None):
    if a is None:
        a = [43,5,2,3,7,8,45,98,0,11,11,11,34,789]
    aSorted = sorted(a)
    f(a)
    if a == aSorted:
        print 'Correct'
    else:
        print 'Wrong'
        print aSorted
        print a

def test_buble_sort(a=None):
    if a is None:
        a = [100,4,3,5,6,77,8,0,0,0,12]
    aSorted = sorted(a)
    buble_sort(a)
    if a == aSorted:
        print 'Correct'
    else:
        print 'Wrong'
        print aSorted
        print a

def test_quicksort(a=None):
    if a is None:
        a = [43,5,2,3,7,8,45,98,0,11,11,11,34,789]
    test_sorting_algorithm(quicksort,a)

def test_mergesort(a=None):
    if a is None:
        a = [43,5,2,3,7,8,45,98,0,11,11,11,34,789]
    aSorted = sorted(a)
    a=mergesort(a)
    if a == aSorted:
        print 'Correct'
    else:
        print 'Wrong'
        print aSorted
        print a
                
