import sys
from graph import Node

class HeapNode(Node):
    def __init__(self, key, heapKey):
        self.key = key
        self.heapKey = heapKey
        self.index = 0

    def get_heap_key(self):
        return self.heapKey

    def set_heap_key(self,newKey):
        self.heapKey = newKey


class MinPriorityQueue(object):

    def __init__(self):
        self.heapSize = 0
        self.array = []
    
    @classmethod
    def from_keys_only(cls,keys):
        pass

    @classmethod
    def from_id_key_pairs(cls,idKeyPairs):
        pass

    @classmethod
    def from_heapNodes(cls,heapNodes):
        priorityQueue = cls()
        priorityQueue.array = list(heapNodes)

        for i in range(len(priorityQueue.array)):     
            priorityQueue.array[i].index = i      #setting indexes
        
        priorityQueue.heapSize = len(heapNodes)
        priorityQueue.build_heap()
        return priorityQueue

    def parent(self,heapNode):
        if heapNode.index == 0:
            return None
        return self.array[(heapNode.index-1)/2]

    def left(self,heapNode):
        return None if heapNode.index * 2 + 1 >= self.heapSize else self.array[heapNode.index*2 + 1]

    def right(self,heapNode):
        return None if heapNode.index * 2 + 2 >= self.heapSize else self.array[heapNode.index*2 + 2]

    def heapify(self,heapNode):
        l = self.left(heapNode)
        r = self.right(heapNode)
        smallest = None
        if l is not None and heapNode.get_heap_key() > l.get_heap_key():
            smallest = l
        else:
            smallest = heapNode

        if r is not None and heapNode.get_heap_key() > r.get_heap_key():
            smallest = r

        if not smallest == heapNode:
            #exchange them
            self.exchange(smallest,heapNode)
            #recursive call
            self.heapify(heapNode)
    
    def build_heap(self):
        for i in range(self.heapSize/2-1,-1,-1):
            self.heapify(self.array[i])

    def minimum(self):
        return self.array[0] if self.heapSize > 0 else None

    def extract_min(self):
        if self.heapSize <= 0:
            raise Exception("Exception")
        m = self.minimum()
        m.index = -1 #mark the node deleted
        self.array[0] = self.array[self.heapSize - 1]
        self.array[0].index = 0
        self.heapSize -= 1
        self.heapify(self.array[0])
        return m

    def decrease_key(self, heapNode, newKey):
        if heapNode.get_heap_key() <= newKey:
            raise Exception()
        heapNode.set_heap_key(newKey)
        while heapNode.index > 0 and self.parent(heapNode).get_heap_key() > heapNode.get_heap_key():
            self.exchange(heapNode,self.parent(heapNode))
                        

    def insert(self, heapNode):
        self.heapSize += 1
        k = heapNode.get_heap_key()
        heapNode.set_heap_key(sys.maxint)
        self.array[self.heap_size - 1] = heapNode
        heapNode.index = self.heapSize - 1
        self.decrease_key(heapNode,k)

    def exchange(self,node1,node2):
        index1 = node1.index
        index2 = node2.index
        self.array[index1] = node2
        node2.index = index1
        self.array[index2] = node1
        node1.index = index2

    def contains(self, node):
        return node.index >= 0 and node.index < self.heapSize

    def __str__(self):
        return str(self.array)
        
        
