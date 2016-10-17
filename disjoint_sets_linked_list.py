
class SetNode:
    def __init__(self):
        self.head = None
        self.tail = None
        self.count = 0
    def __str__(self):
        return "head:{0} tail:{1} count:{2}".format(self.head,self.tail,self.count)

class ListNode:
    def __init__(self, setNode, value, nextNode = None):
        self.set = setNode
        self.value = value
        self.next = nextNode

    def __str__(self):
        return str(self.value)

class DisjointSets_LinkedList:

    def __init__(self):
        self.d = {}     #d will hold a key : listNode relationship
        self.sets = {}  #dictionary of representative : SetNode. The sets are disjoint
    
    def make_disjoint_sets(self,keys):
        for x in keys:
            setX,nodeX = make_set(x)
            self.d[x]=nodeX
            self.sets[x] = setX

    def find_set(self,key):
        listNode = d[x]
        return find_set(listNode)

    def union(self, keyX, keyY):
        nodeX = self.d[keyX]
        nodeY = self.d[keyY]
        largestSet, smallestSet = union(nodeX,nodeY)
        if smallestSet is not None:
            self.sets.pop(smallestSet.head.value)       


def make_set(x):
    """ Builds a set consisiting of one node with value x
        Returns:
            A tuple of (SetNode, ListNode) representing the set and the representative node of the set respectively
    """
    setX = SetNode()
    nodeX = ListNode(setX,x)
    setX.head = nodeX
    setX.tail = nodeX
    setX.count = 1
    return setX,nodeX

def find_set(nodeX):
    return nodeX.set.head

def union(nodeX,nodeY):
    """Performs the union of two sets. The smallest one is concatenated to the largest
        Returns:
            A tuple (largestSet, smallestSet). After the union        
    """
    largestSet = nodeX.set if nodeX.set.count >= nodeY.set.count else nodeY.set
    smallestSet = nodeX.set if nodeX.set.count < nodeY.set.count else nodeY.set
    if largestSet.head == smallestSet.head:
        #the two elements belong to the same set already
        return None, None

    largestSet.tail.next = smallestSet.head
    largestSet.tail = smallestSet.tail
    node = smallestSet.head
    while node is not None:
        node.set = largestSet
        node = node.next
    
    largestSet.count += smallestSet.count
    return largestSet, smallestSet


operations = int(raw_input('Enter the number of unions to perform '))
l = raw_input('Enter the unique list of keys identifying the elements ').split(' ')
disjointSets = DisjointSets_LinkedList()
disjointSets.make_disjoint_sets(l)

for i in range(operations):
    (x,y) = raw_input().split(' ')
    disjointSets.union(x,y)
##    for key,value in disjointSets.sets.iteritems():
##        print value

for key,value in disjointSets.sets.iteritems():
    print value
