import math

def distance(x0,y0,x1,y1):
    return math.sqrt(math.pow(x0-x1,2)+math.pow(y0-y1,2))

def bigger_circle_from_point(matrix,x,y):
    if matrix[y][x]=='*':
        return -1
    n = len(matrix)
    maxR = 0
    for r in range(n/2+1):
        if x-r<0 or x+r>=n or y-r<0 or y+r>=n:
            break
        for i in range(x-r,x+r+1):
            print i
            #check the upper and lower rows
            if distance(i,y-r,x,y)<=r and matrix[y-r][i]=='*':
                return maxR
            if distance(i,y+r,x,y)<=r and matrix[y+r][i]=='*':
                return maxR
        for j in range(y-r,y+r+1):
            #left and right columns
            if distance(x-r,j,x,y)<=r and matrix[j][x-r]=='*':
                return maxR
            if distance(x+r,j,x,y)<=r and matrix[j][x+r]=='*':
                return maxR
        maxR = r
    #print x,y,maxR
    return maxR

def bigger_circle(matrix):
    res = 0
    n = len(matrix)
    for i in range(n):
        for j in range(n):
            res = max(res,bigger_circle_from_point(matrix,i,j))
    return res

n = int(raw_input())
matrix = []
for i in range(n):
    row = list(raw_input())
    matrix.append(row)

print bigger_circle(matrix)


    
    
