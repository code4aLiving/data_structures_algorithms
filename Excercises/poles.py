

def solve(n,k):
    table = [[0 for x in range(n+1)] for x in range(k+1)]
    for col in range(1,n+1):
        for row in range(1,k+1):
            if col == row:
                table[row][col]=0
            elif col > row:
                table[row][col]=10**7
            elif k==1:
                table[row][col] = movePoles(1,col-1)
            else:
                r = -10**7
                for i in range(col):
                    r = min(r,table[row-1][i] + 
            
    
