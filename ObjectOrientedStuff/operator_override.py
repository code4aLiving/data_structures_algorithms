
class Node:
    def __init__(self,value,prev=None,nextNode=None):
        self.value = value
        self.prev = prev
        self.next = nextNode
    
class List:
    def __init__(self):
        pass
    def append(self,x):
        pass
    

class LinkedList(List):    
    def __init__(self):
        List.__init__(self)
        self.nil = Node(None)
        self.nil.prev = self.nil
        self.nil.next = self.nil

    def append(self,x):
        node = Node(x,self.nil.prev,self.nil)
        self.nil.prev = node
        if self.nil.next == self.nil:
            self.nil.next = node

    def insert(self,x):
        node = Node(x,self.nil,self.nil.next)
        self.nil.next.prev = node
        self.nil.next = node

    def __add__(self,other):
        pass

    
    
