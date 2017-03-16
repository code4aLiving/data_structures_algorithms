import math
def solve(A):
    d = {}
    for i,a in enumerate(A):
        d[a]=d.get(a,0)+1
    #print(d)
    nums = set()
    for k,v in d.items():
        if v>1:
            nums.add(v)
            nums.add(v-2)
    nums = list(nums)
    factsDict = eficient_factorials(nums)
    res = 0
    #print(factsDict)
    for k,v in d.items():
        if v>1:
            res+=(factsDict[v]//factsDict[v-2])

    return res        
    

def eficient_factorials(numbers):
    nums = sorted(numbers)
    d = {}
    res = []
    #print(nums)
    for i,n in enumerate(nums):
        if len(res)==0:
            res.append(math.factorial(n))            
        else:
            fact=res[-1]
            for x in range(nums[i-1]+1,n+1):
                fact*=x
            res.append(fact)
        #print(res)
        d[n]=res[-1]
        #print(d)
    return d
        

t = int(input())
for i in range(t):
    n = int(input())
    A = list(map(int,input().split(' ')))
    print(solve(A))
