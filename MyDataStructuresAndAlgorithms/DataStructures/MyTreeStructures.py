
class Node(object):
    def __init__(self,value,parent=None):
        self.value = value
        self.parent = parent

    def __eq__(self,other):
        return self.value==other.value

    def __hash__(self):
        return hash(self.value)

class BinaryTreeNode(Node):
    def __init__(self,value,left=None,right=None,parent=None):
        Node.__init__(self,value,parent)
        self.right = right
        self.left = left
        self.parent = parent
    def __str__(self):
        return str(self.value)

class TrieNode(Node):
    def __init__(self,value,parent=None,isFinalWord=False):
        Node.__init__(self,value,parent)
        self.isFinalWord = isFinalWord
        self.children = dict()
        self.prefixOf = 0

    def has_child(self,val):
        return self.children.has_key(val)    
        

class Trie(object):
    def __init__(self):
        self.root = TrieNode('^')

    def add(self,word):
        node,i = self.__find__(word)
        lastMatchNode = node
        if i == len(word):
            raise Exception('The word already exists on the trie')
        while i < len(word)-1:
            node.children[word[i]]=TrieNode(word[i],parent=node)
            node = node.children[word[i]]
            node.prefixOf+=1
            i+=1

        node.children[word[i]]=TrieNode(word[i],parent=node,isFinalWord=True)
        node.children[word[i]].prefixOf+=1

        while lastMatchNode is not None:
            lastMatchNode.prefixOf+=1
            #print 'lastMatchNode',lastMatchNode.value,lastMatchNode.prefixOf,lastMatchNode.parent
            lastMatchNode = lastMatchNode.parent        
        
    '''
    Return the number of words that start with the given prefix
    '''
    def find_count(self, prefix):
        node,i = self.__find__(prefix)
        if node == self.root or i < len(prefix):
            return 0
        return node.prefixOf

    '''
    Returns the last node that matches a prefix of word, and the index in word
    that failed to match
    If no match is found returns root,-1
    '''
    def __find__(self, word):
        #print 'finding', word
        node = self.root
        i = 0
        while i < len(word):
            if not node.has_child(word[i]):
                return node,i
            node = node.children[word[i]]
            i+=1
        #print 'first not matching char found at',i,node.value,node.prefixOf
        return node,i

    def count(self):
        return self.root.prefixOf

    def list_words(self):
        res = []
        for k,node in self.root.children.iteritems():
            res.extend(self.__suffixes__(node))
        return res

    def __suffixes__(self,node):
        res = []
        if node.isFinalWord:
            res.append(node.value)
        for k,child in node.children.iteritems():
            suffixes = self.__suffixes__(child)
            res.extend([node.value + x for x in suffixes])
        return res
        

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

def bst_test():    
    bst = BinarySearchTree()
    bst.insert(6)
    bst.insert(5)
    bst.insert(7)
    bst.insert(5)
    bst.insert(2)
    bst.insert(8)

def trie_test():
    trie = Trie()
    trie.add('hack')
    trie.add('hackerrank')
    print trie.count()
    raw_input()
    print trie.list_words()
    print trie.find_count('hac')
    print trie.find_count('hak')
        
    
