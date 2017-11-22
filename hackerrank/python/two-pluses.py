
def init_table(board):
    table = [[0 for x in range(m)] for y in range(n)]
    i = 0
    for col in range(i,m-i):
        table[i][col] = 1 if board[i][col]=='G' else 0
        table[n-i-1][col] = 1 if board[n-i-1][col]=='G' else 0
    for row in range(i,n-i):
        table[row][m-i-1] = 1 if board[row][m-i-1]=='G' else 0
        table[row][i] = 1 if board[row][i]=='G' else 0
    return table

def update_table2(board,table,row,col,n,m):
    if board[row][col] == 'B':
        #print 'blocked'
        table[row][col]=0
        return
    if row == 0 or row == n-1 or col == 0 or col == m-1:
        #print 'one'
        table[row][col] = 1
    res = 1
    table[row][col]=res
    while row - res >= 0 and board[row-res][col]=='G' and row + res < n and board[row+res][col]=='G' and col-res >= 0 and col+res<m and board[row][col-res]=='G' and board[row][col+res]=='G':
        #print '+2'
        table[row][col]+=2
        res+=1

def update_table(board,table,d):
    #d must be 1 or greater
    for col in range(d,m-d):
        table[d][col] = 0 if board[d][col]=='B' else 1 if is_adj_blocked(d,col,board) else table[d-1][col] + 2
        table[n-d-1][col] = 0 if board[n-d-1][col]=='B' else 1 if is_adj_blocked(n-d-1,col,board) else table[n-d][col]+2

    for row in range(d+1,n-d-1):
        table[row][d] = 0 if board[row][d]=='B' else 1 if is_adj_blocked(row,d,board) else table[row][d-1]+2
        table[row][m-d-1] = 0 if board[row][m-d-1]=='B' else 1 if is_adj_blocked(row,m-d-1,board) else table[row][m-d]+2
        

def is_adj_blocked(row,col,board):
    return board[row-1][col] != 'G' or board[row+1][col]!='G' or board[row][col+1]!='G' or board[row][col-1]!='G'        


def solve(board,n,m):
    res = 0
    table = init_table(board)
    for row in range(n):
        for col in range(m):
            update_table2(board,table,row,col,n,m)
    
    #for i in range(1,min(m,n)/2 + min(m,n)%2):
        #update_table2(board,table,i,n,m)
    for row in range(n):
        for col in range(m):
            if table[row][col] == 0:
                continue
            c1 = table[row][col]
            resBoard = set_cross(table,board,row,col)
            tempTable = init_table(resBoard)
            for row1 in range(n):
                for col1 in range(m):
                    update_table2(resBoard,tempTable,row1,col1,n,m)     
            c2 = get_max(tempTable)
            res = max(res,(c1*2-1)*(c2*2-1))            
    return res

def set_cross(table,board,row,col):
    resBoard = [[0 for x in range(len(board[0]))] for y in range(len(board))]
    for r in range(len(board)):
        for c in range(len(board[0])):
            resBoard[r][c] = board[r][c]
    resBoard[row][col] = 'B'
    i = 1
    while i <= table[row][col]/2:
        resBoard[row-i][col] = 'B'
        resBoard[row+i][col] = 'B'
        resBoard[row][col+i] = 'B'
        resBoard[row][col-i] = 'B'
        i+=1
    return resBoard

def get_max(table):
    res = 0
    for row in table:
        res = max(max(row),res)
    return res

n,m = map(int,raw_input().split(' '))
board = []
for i in range(n):
    row = list(raw_input())
    board.append(row)
print solve(board,n,m)

##t = init_table(board)
##for i in range(n):
##    for j in range(m):
##        update_table2(board,t,i,j,n,m)
##        #print t
###update_table2(board,table,1,1,n,m)
##print t
    
