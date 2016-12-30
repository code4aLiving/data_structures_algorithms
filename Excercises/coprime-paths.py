import sys

class Node:
    def __init__(self,key,value):
        self.key = key
        self.value = value
        self.primes = set()

    def decompose_in_primes():
        pass

def solve(nodes,edges):
    
    pass

n,q = input().strip().split(' ')
n,q = [int(n),int(q)]
nodes = [int(nodes_temp) for nodes_temp in input().strip().split(' ')]

edges = []
graph = {}
for edges_i in range(n-1):
    (u,v) = [int(edges_temp) for edges_temp in input().strip().split(' ')]
    graph.setdefault(u,[v])
    grap
for a0 in range(q):
    u = int(input().strip())
    v = int(input().strip())
