#python 3
from heapq import *

class Heap:
    def __init__(self):
        self.array = []
        
    def peek(self):
        arr = self.array
        if len(arr)==0:
            raise Exception("No items in the heap")
        return arr[0]
        

class MinHeap:
    def __init__(self):
        Heap.__init__(self)
        
    def add(self, x):
        heappush(self.array,x)

    def pop(self):
        return heappop(self.array)
  
class MaxHeap:
    def __init__(self):
        pass
    def peek(self):
        pass
    def add(self, x):
        pass
    def pop(self):
        pass
    pass
