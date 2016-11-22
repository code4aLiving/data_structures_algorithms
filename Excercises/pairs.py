#!/usr/bin/py
# Head ends here
def pairs(a,k):
    #a contains array of numbers and k is the value of difference
    a.sort(reverse=True)
    #ak = [x for x in a if x < k]
    #ka = [x for x in a if x >= k]
    answer = 0
    for x in a:
        if x < k:
            continue
        answer+=binary_search(a,0,len(a)-1,x-k)
    return answer

def binary_search(arr,s,e,x):
    #print arr,s,e,x
    #raw_input()
    if e < s:
        return 0
    if s == e and arr[s] == x:
        return 1
    if s == e and arr[s]!=x:
        return 0
    middle = (s+e)/2
    if x > arr[middle]:
        return binary_search(arr,s,middle-1,x)
    elif x < arr[middle]:
        return binary_search(arr,middle+1,e,x)
    else:
        res = 1
        res += binary_search(arr,s,middle-1,x)
        res += binary_search(arr,middle+1,e,x)
        return res

# Tail starts here
if __name__ == '__main__':
    a = map(int, raw_input().strip().split(" "))
    _a_size=a[0]
    _k=a[1]
    b = map(int, raw_input().strip().split(" "))
    print pairs(b,_k)
