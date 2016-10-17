from LinkedLists import *

class Cache(object):
    def __init__(self, capacity):
        self.capacity = capacity
        self.d = {}
        self.nil = Node(None)
        self.nil.next = self.nil
        self.nil.prev = self.nil

    def search(self,key):
        if not self.d.has_key(key):
            return None
        resNode = self.d[key]
        if not resNode.prev == self.nil:
            #Move the node to the top of the linked list
            self._delete(resNode)
            self._insert(resNode)
        return resNode.value[1]

    def insert(self,key,value):
        node = Node((key,value),self.nil,self.nil.next)
        if self.d.has_key(key):
            #The key already exists, update the value
            node = self.d[key]
            node.value = (key,value)
        elif len(self.d) < self.capacity:
            #The cache is not full
            self.d[key]=node
        else:
            #The cache is full
            #pop the last node of the list
            lastNode = self.d.pop(self.nil.prev.value[0])
            lastNode.next = self.nil
            #insert the new node in the dictionary
            self.d[key] = node

        #make the new node the first
        self.nil.next.prev = node
        self.nil.next = node
        

    def remove(self,key):
        if not d.has_key(key):
            raise Exception('The key is not present in the dictionary')
        resNode = self.d.pop(key)
        self._delete(resNode)        

    def _delete(self,node):
        node.prev.next = node.next
        node.next.prev = node.prev

    def _insert(self,node):
        node.next = self.nil.next
        node.prev = self.nil
        self.nil.next.prev = node
        self.nil.next = node
        
    
    
        
