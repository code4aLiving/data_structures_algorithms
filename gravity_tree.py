class TreeNode:
    def __init__(self, key, children):
        self.key = key
        self.children = list(children)
        self.visited = False
        self.parent = None
        self.vertexCount = 0
        self.gravity = 0
        self.sumDistance = 0
    def __str__(self):
        return "key:{0} parent:{1}, children:{2} vertexCount:{3} sumDistance:{4} gravity:{5}".format(self.key,self.parent,self.children,self.vertexCount,self.sumDistance,self.gravity)
    def is_leaf(self):
        return len(self.children)==0

def init_tree_vertices(tree):
    for v in tree:
        node = tree[v]
        level = 0
        while not v == None:
            node.vertexCount+=1
            node.sumDistance += level
            node.gravity += level ** 2
            level+=1
            if node.parent == None:
                break
            node = tree[node.parent]

def less_common_ancestor(tree,u,v):
    if u == v:
        return u
    
    rootPathu = get_root_path(tree,u)
    rootPathuSet = set(rootPathu)
    rootPathv = get_root_path(tree,v)
    for vertex in rootPathv:
        if vertex in rootPathu:
            return vertex,rootPathu.index(vertex),rootPathv.index(vertex)

def closest_ancestor(tree,u,v):
    if u == v:
        return u,0,0
    nodeU = tree[u]
    nodeV = tree[v]
    pathU = []
    pathV = []

    if u > v:        
        while True:
            #node u
            pathU.append(nodeU.key)
            if nodeU.key == v:
                #Common ancestor is v
                return v,pathU,len(pathU)-1,0
            if nodeU.parent == None:
                break
            nodeU = tree[nodeU.parent]
            
        while True:
            pathV.append(nodeV.key)
            if nodeV.key == u:
                #Common ancestor is u
                return u,pathV,0,len(pathV)-1
            if nodeV.parent == None:
                break
            nodeV = tree[nodeV.parent]
    else:
        while True:
            pathV.append(nodeV.key)
            if nodeV.key == u:
                #Common ancestor is u
                return u,pathV,0,len(pathV)-1
            if nodeV.parent == None:
                break
            nodeV = tree[nodeV.parent]
        while True:
            #node u
            pathU.append(nodeU.key)
            if nodeU.key == v:
                #Common ancestor is v
                return v,pathU,len(pathU)-1,0
            if nodeU.parent == None:
                break
            nodeU = tree[nodeU.parent]

    s = set()
    if len(pathU) > len(pathV):
        s = set(pathV)
        for i in range(len(pathU)):
            if pathU[i] in s:
                return pathU[i],[],i,pathV.index(pathU[i])
    else:
        s = set(pathU)
        for i in range(len(pathV)):
            if pathV[i] in s:
                return pathV[i],[],pathU.index(pathV[i]),i

def get_root_path(tree,v):
    node = tree[v]
    path = []
    while True:
        path.append(node.key)
        if node.parent == None:
            break
        node = tree[node.parent]
    return path
import math
def gravity(tree,u,v):
    if u == v:
        return tree[u].gravity
    #lca,du,dv = less_common_ancestor(tree,u,v)
    lca,pathUtoV,du,dv = closest_ancestor(tree,u,v)
    #print lca
    duv = du + dv
    if lca == v:
        if tree[v].vertexCount == tree[u].vertexCount + duv - 1:
            #just a linked list
            g = tree[u].gravity + duv*(duv+1)*(2*duv+1)/6
        else:        
            g = tree[u].gravity
            #uRootPath = get_root_path(tree,u)
            prev = tree[u]
            d = 1
            while True:
                x = pathUtoV[d]
                gxPrima = tree[x].gravity - prev.vertexCount - prev.gravity - 2*prev.sumDistance
                sumXPrima = tree[x].sumDistance - prev.sumDistance - prev.vertexCount
                countXPrima = tree[x].vertexCount - prev.vertexCount
                g += gxPrima + 2*d*sumXPrima + countXPrima*(d**2)
                if x == v:
                    break
                d += 1
                prev = tree[x]                
    else:
        g = tree[v].gravity + 2*duv*tree[v].sumDistance + tree[v].vertexCount*(duv**2)
    return g

def gravity_list(tree,u,v):
    pass

def count_leaves(tree):
    res = 0
    for key in tree:
        if tree[key].is_leaf():
            res+=1
    return res

n = int(raw_input())
vertices = map(int,raw_input().split(' '))
tree = {}

for i in range(1,n+1):
    tree[i] = TreeNode(i,[])
    
for i in range(n-1):
    tree[vertices[i]].children.append(i+2)
    tree[i+2].parent=vertices[i]

if count_leaves(tree)==1:
    raise Exception()
else:
    init_tree_vertices(tree)

q = int(raw_input())
rs = [0 for x in range(q)]
for i in range(q):
    u,v = map(int,raw_input().split(' '))
    r = gravity(tree,u,v)
    #rs[i]=r
    print r
##for r in rs:
##    print r

##print gravity(tree,2,1)
##for x in tree:
##    print tree[x]
##
##print 5,4,less_common_ancestor(tree,5,4),closest_ancestor(tree,5,4)
##print 3,5,less_common_ancestor(tree,3,5),closest_ancestor(tree,3,5)
##print 1,4,less_common_ancestor(tree,1,4),closest_ancestor(tree,1,4)
