def solve(a,k):
    a.sort()
    table = [[0 for x in range(len(a))] for y in range(k)]
    
    for row in range(1,k):
        for col in range(len(a)-k):
            for i in range(k-2):
                table[row][col] += table[row-1][col+i]
            table[row][col] += (a[col]-a[col+k-1])**2

    print table
    return min(table[k-1][:-k])*2

n,k = raw_input().strip().split(' ')
n,k = [int(n),int(k)]
a = map(int,raw_input().strip().split(' '))
print solve(a,k)
