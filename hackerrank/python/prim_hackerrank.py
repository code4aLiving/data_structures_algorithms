# Enter your code here. Read input from STDIN. Print output to STDOUT
import sys
 
    
def mst_prim(graph,root,edges):
    #initialize and build heap
    pq = [(sys.maxint,v) for v in graph if not v == root]
    pq.insert(0,(0,root))
    priorityIndex = {}
    parents = {}
    tree = set()
    vertices = graph.keys()
    for i in range(len(vertices)):
        priorityIndex[vertices[i]] = i
        parents[vertices[i]] = None
    #print pq
    res = 0
    while len(pq) > 0:
        #print pq
        w,u = extract_min(pq,priorityIndex)
        print w,u
        tree.add(u)
        res += w
        for v in graph[u]:
            if v not in tree and edges[(u,v)] < pq[priorityIndex[v]]:
                parents[v] = u
                i = priorityIndex[v]
                pq[i] = (edges[(u,v)],v)
                push_up(pq,i,priorityIndex)            
    return res

def push_up(pq,index,priorityIndex):
    print index,pq
    while index > 0 and pq[(index-1)/2][0] >  pq[index][0]:
        _,v = pq[(index-1)/2]
        _,smallest = pq[index]
        temp = pq[index]
        pq[index] = pq[(index-1)/2]
        pq[(index-1)/2] = temp
        priorityIndex[v] = index
        priorityIndex[smallest] = (index-1)/2
        index = (index-1)/2
        
def extract_min(pq, priorityIndex):
    w,v = pq[0]
    pq[0] = pq[-1]
    priorityIndex[pq[0][1]]=0
    pq.pop(-1)
    if len(pq) > 0:
        heapify(pq, 0, priorityIndex)
    return w,v

def heapify(pq, index, priorityIndex):
    
    wv,v = pq[index]
    wl,l = pq[index * 2 + 1] if index*2 +1 < len(pq) else (None,None)
    wr,r = pq[index * 2 + 2] if index*2 +2 < len(pq) else (None,None)
    #print wv,wl,wr
    smallest = None
    if l is not None and wl < wv:
        smallest = l
    else:
        smallest = v
    if r is not None and wr < wv:
        smallest = r

    if not smallest == v:
        i = priorityIndex[v]
        j = priorityIndex[smallest]
        temp = pq[j]
        pq[j] = pq[i]
        pq[i] = temp
        priorityIndex[v] = j
        priorityIndex[smallest] = i
        heapify(pq, j, priorityIndex)
    


n,m = map(int,raw_input().split(' '))
edges = {}
priority = {}
graph = {}
for i in range(m):
    (u,v,w) = map(str,raw_input().split(' '))
    if graph.has_key(u):
        graph[u].append(v)
    else:
        graph[u]=[v]
    if graph.has_key(v):
        graph[u].append(u)
    else:
        graph[v]=[u]
    
    w = int(w)
    edges[(u,v)] = w

root = raw_input()
priority[root] = (0,0)

print mst_prim(graph,root,edges)

