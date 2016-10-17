import sys
from heapq import *

class TreeNode:
    def __init__(self,value,parent,adjValuesWeights):
        self.id = value
        self.p = parent
        self.key = sys.maxint
        self.adj = adjValuesWeights
        self.removed = False

    def w(self,v):
        if v is None:
            return sys.maxint
        adj = [x[0] for x in self.adj]
        ws = [x[1] for x in self.adj]
        if v.id not in adj:
            return sys.maxint
        return ws[adj.index(v.id)]

    def __hash__(self):
        return hash(self.id)

    def __eq__(self,other):
        return self.id == other.id

    def __ne__(self, other):
        return not self.id == other.id

    def __str__(self):
        return '{0} {1}'.format(self.value,self.adj)

    def get_key_for_heap(self):
        return self.key

    def get_id(self):
        return self.id

class Heap(object):
    def __init__(self, nodes, NodeClass):
        self.q = map(lambda x: (x.get_key_for_heap(),x), nodes)
        heapify(self.q)
        self.d = {}
        for n in nodes:
            self.d[n.id] = n
        self.heapCount = len(nodes)
        self.NodeClass = NodeClass

    def contains(self,nodeId):
        return self.d.has_key(nodeId)

    def pop(self):
        key,node = heappop(self.q)
        while node.removed:
            key,node = heappop(self.q)
        self.d.pop(node.id)
        self.heapCount -= 1
        return (key,node.id)

    def heap_size(self):
        return self.heapCount

    def heap_update_key(self,node,newKey):
        d = self.d
        d[node.id].removed = True
        d.pop(node.id)
        newNode = NodeClass(node.get_id(),node.p,node.adj)
        newNode.key = newKey
        d[newNode.get_id()] = newNode
        heappush(self.q,(newNode.key,newNode))
