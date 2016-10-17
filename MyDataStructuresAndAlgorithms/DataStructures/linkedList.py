

class LinkedList(object):

	def __init__(self):
		self.head = None
		self.current = None

	def count(self):
	 	if not self.head:
	 		return 0
	 	res = 0
	 	h = self.head
	 	while h:
	 		h = h.next
	 		res+=1
	 	return res

	def insert(self, data, position):
		if position < 0 or position >= self.count():
			raise IndexError
		
		newnode = Node(data)
		if not self.head:
			self.head = newnode
			return

		if position == 0:
			newnode.next = self.head
			self.head = newnode
			return

		prev = self.head
		i = 0
		while i < position-1:
			prev = prev.next
			i+=1
		newnode.next = prev.next
		prev.next = newnode


	def insert_at_front(self,data):
		if not self.head:
			self.head = Node(data)
		else:
			newnode = Node(data,self.head)
			self.head = newnode

	def append(self, data):
		if not self.head:
			self.head = Node(data)
		else:
			h = self.head
			while h.next:
				h = h.next
			h.next = Node(data)

	def __iter__(self):
		self.current = self.head
		return self

	def next(self):
		if not self.current:
			raise StopIteration
		else:
			res = self.current.data
			self.current = self.current.next
			return res

	def __str__(self):
		return ','.join(map(str,self))



class Node(object):
	def __init__(self, data=None, next_node=None):
		self.data = data
		self.next = next_node


l = LinkedList()
print l.count()
l.append(1)
l.append('sergio')
print l.count()

for x in l:
	print x

l.insert_at_front(100)
print l

l.insert('first',0)
l.insert('second',1)
print l

l.insert('last',4)
print l