#!/bin/python3

import sys

def geometricTrick(s):
    indexA,indexB,indexC = [],[],[]
    for i,v in enumerate(s):
        if v == 'a':
            indexA.append(i)
        elif v == "b" and math.sqrt(i+1)-int(math.sqrt(i+1))>0:
            indexB.append(i)
        else:
            indexC.append(i)
    res = 0
    for i in indexA:
        for j in indexB:
            for k in indexC:
                if (j+1)**2 == (i+1)*(k+1):
                    res+=1
    return res
              
    
n = int(input().strip())
s = input().strip()
result = geometricTrick(s)
print(result)
