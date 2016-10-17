
class Node(object):
    def __init__(self, value, prev=None, next_node=None):
        self.value = value
        self.prev = prev
        self.next = next_node
        

class DoubleLinkedList(object):

    def __init__(self):
        self._nil = Node(None)
        self._nil.next = self._nil
        self._nil.prev = self._nil
        self._current = None
    
    def insert(self,x):
        n = Node(x,prev=self._nil,next_node=self._nil.next)
        self._nil.next.prev = n
        self._nil.next = n

    def search(self,x):
        current = self._nil.next
        while not current==self._nil:
            if current.value == x:
                return current
            current = current.next
        return None

    def delete(self,x):
        node = search(x)
        if node == None:
            raise Exception('{0} does not exist'.format(x))
        self._delete(node)

    def _delete(self,node):
        node.prev.next = node.next
        node.next.prev = node.prev

    def is_empty(self):
        return slef._nil.next == self._nil

    def __iter__(self):
        self._current = self._nil.next
        return self
    
    def next(self):
        if self._current == self._nil:
            raise StopIteration
        res = self._current.value
        self._current = self._current.next
        return res
    
    def minimun(self):
        _min = self._minimun()
        if _min == self._nil:
            return None
        return _min.value

    def _minimun(self):
        res = self._nil.next
        current = self._nil.next
        while not current == self._nil:
            if current.value < res:
                res = current
            current = current.next
        return res

    def __str__(self):
        return ','.join(map(str,self))
            
        
            
        

        
