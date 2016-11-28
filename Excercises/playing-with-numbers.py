# Enter your code here. Read input from STDIN. Print output to STDOUT

n = int(raw_input())
a = map(int,raw_input().split(' '))
q = int(raw_input())
queries = map(int,raw_input().split(' '))

def solve_slow(a,queries):
    for x in queries:
        res = 0
        for i in range(len(a)):
            a[i]+=x
            res+=abs(a[i])
        print res

def binary_search(arr,s,e,x):
    if s == e:
        return s
    middle = (s+e)/2
    if x<=arr[middle]:
        return binary_search(arr,s,middle-1,x)
    return binary_search(arr,middle+1,e,x)
        
def solve(a,queries):
    positive = sorted([x for x in a if x >= 0])
    negative = sorted([x for x in a if x < 0])
    sump = [0,positive[0]]
    for i in range(1,len(positive)):
        sump.append(sump[i-1] + positive[i])
    sumn = [0,negative[0]]
    for i in range(1,len(negative)):
        sumn.append(sumn[i-1] + negative[i])
    q = 0
    for x in queries:
        q += x
        res = 0
        if q > 0:
            res += sump[-1] + (len(sump)-1)*q
            k = binary_search(negative,0,len(negative)-1,-q)
            print negative,q,k            
            res += -(sumn[k]) + (sumn[-1]-sumn[k])-(k)*q + (len(negative)-k-1)*q
        else:
            res += abs(sumn[-1] + (len(sumn)-1)*q)
            k = binary_search(positive,0,len(positive)-1,-q)
            print positive,q,k
            res += -(sump[k])+(sump[-1]-sump[k])-(k)*q + (len(positive)-k-1)*q
        print res       
    

solve(a,queries)
