
def make_change(coins,n):
    global change
    change = set()

def make_change_recursive(coins,n,usedCoins):
    if n < 0:
        return 0
    if n == 0:
        #print usedCoins
        return 1
    res = 0
    for i in range(len(coins)):
        j = 1
        c = coins[i]
        copyCoins = coins[i+1:]
        while c*j <= n:
            #use coin i, j times
            usedCoins.extend([c]*j)
            res += make_change_recursive(copyCoins, n-c*j, usedCoins)
            j+=1
            usedCoins = usedCoins[:-j]
        #usedCoins.pop(-1)
    return res

def make_change_dynamic(coins,n):
    table = [[1 for col in range(n+1)] for row in range(len(coins)+1)]
    table[0] = [0] * (n+1)
    table[0][0] = 1
    for row in range(1,len(table)):
        for col in range(1,n+1):
            count = 0
            j = 0
            c = coins[row-1]
            while col-j*c>=0:
                count += table[row-1][col-j*c]
                j+=1
            table[row][col]=count
    return table[-1][-1]

n,m = raw_input().strip().split(' ')
n,m = [int(n),int(m)]
coins = map(int,raw_input().strip().split(' '))
#print make_change_recursive(sorted(coins), n,[])
print make_change_dynamic(coins,n)
    
    
