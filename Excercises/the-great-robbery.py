import sys
from collections import deque

def solve(matrix,sCol,sRow,dCol,dRow,rows,columns):
    auxMatrix = [[-sys.maxint for x in xrange(columns)] for x in xrange(rows)]
    auxMatrix[sRow][sCol]=matrix[sRow][sCol]
    queue = deque([(sCol,sRow)])
    while len(queue) > 0:
        col,row = queue.popleft()
        for (nCol,nRow) in get_neigbors(col,row,columns,rows):
            value = min(matrix[nRow][nCol],auxMatrix[row][col])
            if auxMatrix[nRow][nCol] < value:
                #its value can be improved
                auxMatrix[nRow][nCol] = value
                if nCol == dCol and nRow == dRow:
                    continue
                queue.append((nCol,nRow))
            #print_matrix(auxMatrix)
    #print_matrix(auxMatrix)
    return auxMatrix[dRow][dCol]
    

def get_neigbors(col,row,columns,rows):
    if row > 0:
        yield (col,row-1)
    if row < rows-1:
        yield (col,row+1)
    if col > 0:
        yield (col-1,row)
    if col < columns-1:
        yield (col+1,row)
    
def print_matrix(m):
    for row in m:
        print row


rows,columns = map(int,raw_input().split(' '))
sCol,sRow = map(int,raw_input().split(' '))
dCol,dRow = map(int,raw_input().split(' '))
matrix = []

for i in xrange(rows):
    col = map(int,raw_input().split(' '))
    matrix.append(col)
#print_matrix(matrix)
print solve(matrix,sCol,sRow,dCol,dRow,rows,columns)
    

