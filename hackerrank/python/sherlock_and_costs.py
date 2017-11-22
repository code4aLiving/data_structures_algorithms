
def solve(b, s, a):
    if s == len(b):
        res = 0
        for i in range(s-1):
            res += abs(a[i]-a[i+1])
        return res
    #set to 1
    a[s] = 1
    res1 = solve(b, s+1, a)
    #set to b[s]
    a[s]=b[s]
    res2 = solve(b, s+1, a)

    if res1 > res2:
        return res1
    return res2

def solve_dynamic(b):
    table = [[0 for x in range(len(b))] for y in range(2)]
    for n in range(len(b)-2, -1, -1):
        table[0][n] = table[1][n+1] + abs(b[n+1]-1)
        table[1][n] = max(table[0][n+1] + abs(b[n]-1),
                          table[1][n+1] + abs(b[n]-b[n+1]))
    return max(table[0][0], table[1][0])

t = int(input())
for x in range(t):
    n = int(input())
    b = list(map(int, input().strip().split(' ')))
    print(solve(b, 0, [1 for x in range(n)]))
    print(solve_dynamic(b))