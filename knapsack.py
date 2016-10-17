import sys
def knapsack_recursive(c,p,w,index):
    if c < 0:
        return -sys.maxint
    if len(p)-index == 0:
        return 0
    if len(p)-index==1:
        if w[index]<=c:
            return p[index]
        else:
            return -sys.maxint

    return max(p[index] + knapsack_recursive(c-w[index],p,w,index+1),knapsack_recursive(c,p,w,index+1))

def_knapsack_bottom_up(c,p,w):
    table = [[0 for x in range(len(p)] for y in range(c)]]
    
             

c=10
p=[1,3,3,8,4]
w=[1,5,3,9,2]

print knapsack_recursive(c,p,w,0)
    
