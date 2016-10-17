import sys
sys.path.insert(0, '../DataStructures/')
from graph import *
from dfs import *
from collections import deque

def topological_sort(graph):
    for u in graph.get_vertices():
        u.colour = 'WHITE'
        u.parent = None
    global time
    time = 0
    top_sort = deque()
    for u in graph.get_vertices():
        if u.colour == 'WHITE':
            dfs_visit_build_topological_sort(graph, u, top_sort)
    return top_sort

def dfs_visit_build_topological_sort(graph, u, top_sort):
    global time
    time += 1
    u.d = time
    u.colour = 'GRAY'
    for v in graph.get_adjs(u):
        if v.colour == 'WHITE':
            v.parent = u
            dfs_visit_build_topological_sort(graph,v,top_sort)
    u.colour = 'BLACK'
    time += 1
    u.f = time
    top_sort.appendleft(u)

def test_topological_sort():
    vertices = raw_input().strip().split(' ')
    n = int(raw_input('Enter the number of edges '))
    edges = []
    for i in range(n):
        (u,v) = raw_input().strip().split(' ')
        edges.append((u,v))

    graph = DirectedGraph(vertices, edges, DFSGraphNode)
    top_sort = topological_sort(graph)

    for x in top_sort:
        print x
