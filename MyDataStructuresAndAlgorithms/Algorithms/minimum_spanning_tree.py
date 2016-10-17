import sys
sys.path.insert(0, '../DataStructures/')
from heapq import *
from disjoint_sets_forest import *
from min_heap import *
from heap import *
from graph import *


class TreeNode(HeapNode):
    def __init__(self, key, heapKey = sys.maxint):
        HeapNode.__init__(self, key, heapKey)
        self.parent = None


def mst_prim(graph,root):
    #initialize and build heap
    A = set()
    root.set_heap_key(0)
    q = MinPriorityQueue.from_heapNodes(graph.get_vertices())
       
    while q.heapSize > 0:
        u = q.extract_min()
        A.add(u)
        for v in graph.get_adjs(u):
            if q.contains(v) and graph.get_weight(u,v) < v.get_heap_key():
                v.parent = u
                q.decrease_key(v,graph.get_weight(u,v))
    return A

def mst_kruskal(vertices, edges):
    #print vertices, edges
    A = set()
    disjointSets = DisjointSetsForest()
    disjointSets.make_disjoint_sets(list(vertices))
    print disjointSets.d.keys()
    edges.sort()
    for (w,u,v) in edges:
        rootU = disjointSets.find_set(u)
        rootV = disjointSets.find_set(v)
        #print u,rootU.key,v,rootV.key
        if not rootU == rootV:
            A.add((u,v))
            print 'union ',u,v
            disjointSets.union(u,v)            
    return A


def test_mst_prim():
    vertices = raw_input().split(' ')
    e = int(raw_input())
    edges = []
    weights = []
    for i in range(e):
        (u,v,w) = map(str,raw_input().split(' '))
        w = float(w)
        edges.append((u,v))
        weights.append(w)
    graph = WeightedGraph(vertices, edges, weights, TreeNode)
    root = graph.get_node(raw_input())
    A = mst_prim(graph,root)
    res = 0
    for u in A:
        print u.key, u.get_heap_key(), u.parent.key if u.parent is not None else 'Nil'
        res += u.get_heap_key()
    print res

def test_mst_kruskal():
    e = int(raw_input('Enter the number of edges in the graph'))
    print 'enter the edges u v w one per line'
    edges = []
    vertices = set()
    for i in range(e):
        u,v,w = map(str,raw_input().strip().split(' '))
        edges.append((int(w),u,v))
        vertices.add(u)
        vertices.add(v)

    A = mst_kruskal(vertices,edges)
    for u,v in A:
        print u, v
