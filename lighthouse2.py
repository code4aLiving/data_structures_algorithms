


n = int(raw_input())
matrix = []
for i in range(n):
    r = list(raw_input())
    row=[]
    for i in range(len(r)):
        row.append(-1 if r[i]=='*' else 0)
    
    matrix.append(row)

print matrix
