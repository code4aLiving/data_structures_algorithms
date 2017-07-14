class Node:
    def __init__(key,value):
        self.key = key
        self.value = value
        self.primes = set()

    def __eq__(self,other):
        return self.key == other.key

    def __hash__(self):
        return hash(self.key)

def SoE(n):
    boolTable = [True for x in range(n-1)]
    primes = []
    for x in xrange(2,n+1):
        if boolTable[x-2]:
            i = 2
            primes.append(x)
            while x*i <= n:
                boolTable[x*i-2]=False
                i+=1
    return primes

def decompose_in_primes(primes,graph):
    pass

def solve(graph,u,v):
    path = get_path(graph,u,v)
    return relative_primes(path)


n,q = input().strip().split(' ')
n,q = [int(n),int(q)]
nodes = [int(nodes_temp) for nodes_temp in input().strip().split(' ')]
edges = []
for edges_i in range(n-1):
   edges_t = [int(edges_temp) for edges_temp in input().strip().split(' ')]
   edges.append(edges_t)

graph = {}
primes = SoE(int(sqrt(max(nodes))))
for u,v in edges:
    nU = Node(u,nodes[u-1])
    nV = Node(v,nodes[v-1])
    graph.setdefault(nU,[nV]).append(nV)

for key,value in graph.iteritems():
    for p in primes:
        pass

for a0 in range(q):
    u = int(input().strip())
    v = int(input().strip())
    print solve(graph,u,v)
    
    
    
