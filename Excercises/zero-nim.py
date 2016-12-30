

def solve(heaps,ps):
    nim_sum = 0
    for p in ps:
        nim_sum ^= p
    #if nim sum is not zero the first player wins

    if nim_sum > 0:# and heaps % 2 == 0:
        return 'W'
    #if nim_sum == 0 and heaps % 2 == 1:
    #    return 'W'
    return 'L'

g = int(raw_input())
for x in xrange(g):
    heaps = int(raw_input())
    ps = map(int,raw_input().split(' '))
    print solve(heaps,ps)
