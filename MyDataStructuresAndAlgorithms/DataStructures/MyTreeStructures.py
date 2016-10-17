
class BinaryTreeNode(object):
    def __init__(self,value,left=None,right=None,parent=None):
        self.value = value
        self.right = right
        self.left = left
        self.parent = parent
    def __str__(self):
        return str(self.value)

class BinarySearchTree(object):
    def __init__(self):
        self.root = BinaryTreeNode(None)

    def insert(self,value):
        newNode = BinaryTreeNode(value)
        x = self.root
        y = None
        while x != None and x.value != None:
            y = x
            if value < x.value:
                #insert in the left subtree
                x = x.left
            else:
                #insert in the right subtree
                x = x.right
        newNode.parent = y
        if y == None:
            #The tree is empty
            self.root = newNode
        elif newNode.value < y.value:
            #Insert as left child
            y.left = newNode
        else:
            #insert as right child
            y.right = newNode          
        
    def search(self,value):
        return self._search(self.root,value)

    def _search(self,node,value):
        v = node.value
        if v == None or v==value:
            return node
        if value < v:
            return self._search(node.left,value)
        else:
            return self._search(node.right,value)

    def inorder_tree_walk(self):
        if self.root.value:
            for x in self._inorder_tree_walk(self.root):
                yield x        
    
    def _inorder_tree_walk(self,node):
        if node!=None:            
            if node.left:
                for x in self._inorder_tree_walk(node.left):
                    yield x
            yield node.value
            if node.right:
                for x in self._inorder_tree_walk(node.right):
                    yield x
        

    def inorder_tree_walk_iterative(self):
        pass

    def preorder_tree_walk(self):
        if self.root.value:
            for x in self._preorder_tree_walk(self.root):
                yield x
        

    def _preorder_tree_walk(self,node):
        if node != None:
            yield node.value
            if node.left:
                for x in self._preorder_tree_walk(node.left):
                    yield x
            if node.right:
                for x in self._preorder_tree_walk(node.right):
                    yield x
        

    def postorder_tree_walk(self):
        if self.root.value:
            for x in self._postorder_tree_walk(self.root):
                yield x

    def _postorder_tree_walk(self,node):
        if node != None:
            if node.left:
                for x in self._postorder_tree_walk(node.left):
                    yield x
            if node.right:
                for x in self._postorder_tree_walk(node.right):
                    yield x
            yield node.value

bst = BinarySearchTree()
bst.insert(6)
bst.insert(5)
bst.insert(7)
bst.insert(5)
bst.insert(2)
bst.insert(8)
    
    
