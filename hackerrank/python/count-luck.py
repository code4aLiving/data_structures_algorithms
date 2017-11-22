import sys
def solve(forest,srow,scol,frow,fcol,ronPrediction):
    q = [(srow,scol,0)]
    forest[srow][scol]='v'
    while len(q):
        r,c,res = q.pop(0)
        if r==frow and c==fcol:
            return res
        for (nr,nc) in get_neighbors(forest,r,c):
            q.append((nr,nc,res+1))
            forest[nr][nc]='v'
    return sys.maxsize

def get_neighbors(forest,row,col):
    neighbors = []
    if row > 0 and (forest[row-1][col]=='.' or forest[row-1][col]=='*'):
        #up
        neighbors.append((row-1,col))        
    if row < len(forest)-1 and (forest[row+1][col]=='.' or forest[row+1][col]=='*'):
        #down
        neighbors.append((row+1,col))        
    if col > 0 and (forest[row][col-1]=='.' or forest[row][col-1]=='*'):
        #left
        neighbors.append((row,col-1))
    if col < len(forest[0])-1 and (forest[row][col+1]=='.' or forest[row][col+1]=='*'):
        #right
        neighbors.append((row,col+1))
    return neighbors


t = int(input())
for i in range(t):
    n,m = tuple(map(int,input().split(' ')))
    forest = []
    srow,scol,frow,fcol = 0,0,0,0
    for j in range(n):
        row = list(input())
        if 'M' in row:
            srow = j
            scol = row.index('M')
        if '*' in row:
            frow = j
            fcol = row.index('*')
        forest.append(row)
    ronPrediction = int(input())
    s = solve(forest,srow,scol,frow,fcol,ronPrediction)
    print(s)
    if s == ronPrediction:
        print('Impressed')
    else:
        print('Opss!')
    

    
