
class DisjointSetNode:
    def __init__(self,key,rank,parent):
        self.key = key
        self.rank = rank
        self.p = parent
        
    def __hash__(self):
        return hash(self.key)

    def __eq__(self, other):
        return self.key == other.key

    def __str__(self):
        return str(self.key)

class DisjointSetsForest:
    def __init__(self):
        self.d = {}     #d will hold a key : TreeNode relationship
        self.sets = {}  #dictionary of representative elements  key : TreeNode. The sets are disjoint

    def make_disjoint_sets(self,keys):
        d = self.d
        sets = self.sets
        for k in keys:
            node = make_set(k)
            d[k] = node
            sets[k] = node

    def union(self,keyX, keyY):
        if keyX == keyY:
            return
        d = self.d
        sets = self.sets
        nodeX = d[keyX]
        nodeY = d[keyY]

        xRoot = find_set(nodeX)
        yRoot = find_set(nodeY)

        if xRoot == yRoot:
            #they are alreay in the same set
            return
        rootNode = link(xRoot,yRoot)
        if rootNode == xRoot:
            #delete set where keyY was held
            sets.pop(yRoot.key)
        else:
            #delete the set where keyX was held
            sets.pop(xRoot.key)

    def find_set(self,key):
        return find_set(self.d[key])
        

def make_set(key):
    res = DisjointSetNode(key, 0, None)
    res.p = res
    return res

def union(nodeX, nodeY):
    return link(find_set(nodeX),find_set(nodeY))

def link(nodeX, nodeY):
    if nodeX.rank > nodeY.rank:
        nodeY.p = nodeX
        return nodeX
    else:
        nodeX.p = nodeY
        if nodeX.rank == nodeY.rank:
            nodeY.rank += 1
        return nodeY
    

def find_set(node):
    if not node == node.p:
        node.p = find_set(node.p)
    return node.p

##ds = DisjointSetsForest()
##ds.make_disjoint_sets(map(chr,range(65,65+9)))
##ds.union('G','H')
##ds.union('I','C')
##print ds.find_set('C').key,ds.find_set('I').key, list(ds.sets.keys())
##ds.union('F','G')
##ds.union('A','B')
##print ds.find_set('C').key,ds.find_set('I').key, list(ds.sets.keys())
##ds.union('I','G')

def solve(graph):
    pass

t = int(raw_input().strip())
for a0 in xrange(t):
    n,m = raw_input().strip().split(' ')
    n,m = [int(n),int(m)]
    graph = {}
    for a1 in xrange(m):
        x,y = raw_input().strip().split(' ')
        x,y = [int(x),int(y)]
        graph.setdefault(x,[y]).append(y)
        graph.setdefault(y,[x]).append(x)
        

