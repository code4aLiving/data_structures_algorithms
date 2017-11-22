import sys

class Fraction(object):
    def __init__(self, p, q):
        self.p = p
        self.q = q        
    
    def __eq__(self, fraction):
        return self.p==fraction.p and self.q == fraction.q

    def __ne__(self, fraction):
        return self.p != fraction.p or self.q != fraction.q

    def __gt__(self, fraction):
        if self.get_value() > fraction.get_value():
            return True
        elif self.get_value() < fraction.get_value():
            return False
        else:
            return self.p > fraction.p    

    def __ge__(self, fraction):
        if self.get_value() > fraction.get_value():
            return True
        elif self.get_value() < fraction.get_value():
            return False
        else:
            return self.p >= fraction.p and self.q >= fraction.q
    
    def __lt__(self, fraction):
        return fraction > self

    def __le__(self, fraction):
        return True if self==fraction else self < fraction

    def __str__(self):
        return "{0}/{1}".format(self.p,self.q)

    def get_value(self):
        return float(self.p)/float(self.q)
    
    def simplify(self):
        d = max(self.p,self.q)
        while d > 1:
            if not self.p % d and not self.q % d:
                self.p //= d
                self.q //= d
            d = min(d-1,max(self.p,self.q))

    def inverse(self):
        return Fraction(self.q,self.p)

def printpq(pq):
    print("priority queue")
    for x in pq:
        print(x[0],x[1])
    print("priority queue")
    
def mst_prim(graph,root,edges):
    #initialize and build heap
    pq = [(Fraction(100,1),v) for v in graph if not v == root]
    pq.insert(0,(Fraction(0,0),root))
    priorityIndex = {}
    parents = {}
    tree = set()
    i = 0
    for p,v in pq:
        priorityIndex[v] = i
        parents[v] = None
        i+=1
    #print pq
    #print priorityIndex
    res = Fraction(0,0)
    while len(pq) > 0:
        #print pq
        w,u = extract_min(pq,priorityIndex)
        print("Min {} {}".format(w,u))
        #print w,u
        tree.add(u)
        res = w
        
        #print(priorityIndex)
        printpq(pq)
        #print(res)
        for v in graph[u]:
            if v not in tree:
                fraction_uv = edges[(u,v)]
                print("Fraction {},{} {}".format(u,v,fraction_uv))
                fraction_queue = pq[priorityIndex[v]][0]
                print("Fraction queue {}".format(fraction_queue))
                if fraction_queue > fraction_uv:
                    print('Update with the new value')
                    parents[v] = u
                    i = priorityIndex[v]
                    pq[i] = (fraction_uv,v)
                    push_up(pq,i,priorityIndex)
        printpq(pq)
    return res

def push_up(pq,index,priorityIndex):
    #print index,pq
    while index > 0 and pq[(index-1)//2][0] >= pq[index][0]:
        _,v = pq[(index-1)//2]
        _,smallest = pq[index]
        temp = pq[index]
        pq[index] = pq[(index-1)//2]
        pq[(index-1)//2] = temp
        priorityIndex[v] = index
        priorityIndex[smallest] = (index-1)//2
        index = (index-1)//2
        
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

graph = {}
edges = {}
n,m = input().strip().split(' ')
n,m = [int(n),int(m)]
for a0 in range(m):
    u,v,a,b = input().strip().split(' ')
    u,v,a,b = [int(u),int(v),int(a),int(b)]
    graph.setdefault(u,[]).append(v)
    graph.setdefault(v,[]).append(u)
    f = Fraction(b,a)
    edges[(u,v)]= f
    edges[(v,u)]= f

#print(graph)
#print(edges)

res = mst_prim(graph,0,edges)
res.simplify()
print(res.inverse())


    
    
    
