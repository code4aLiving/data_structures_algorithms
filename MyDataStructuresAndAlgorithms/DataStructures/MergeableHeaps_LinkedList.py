from LinkedLists import *
import copy

class MergeableMinHeap_UnsortedList(object):

    def __init__(self):
        self._list = DoubleLinkedList()

    def insert(self, x):
        self._list.insert(x)

    def minimun(self):
        return self._list.minimun()

    def extract_min(self):
        _min = self._list._minimun()
        self._list._delete(_min)
        return _min.value

    def union(heap1,heap2):
        h1 = copy.deepcopy(heap1)
        h2 = copy.deepcopy(heap2)
        d = {}
        for x in h1._list:
            d[x] = 0
        _min = h2.extract_min()
        while not _min==None:
            if not d.has_key(_min):
                h1.insert(_min)
                d[_min]=0
            _min = h2.extract_min()

        return h1

    def __str__(self):
        return str(self._list)
            
        
