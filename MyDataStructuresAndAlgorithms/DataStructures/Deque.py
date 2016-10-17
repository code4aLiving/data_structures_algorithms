
class Deque:
    def __init__(self,n):
        self.a = [None for x in range(n)]
        self.head = n/2 - 1
        self.tail = n/2
        self.n = n

    def insert_front(self,x):
        if self.head == self.tail:
            raise Exception('overflow')
        self.a[self.head] = x
        if self.head == 0:
            self.head = self.n - 1
        else:
            self.head -= 1

    def enque(self,x):
        if self.head == self.tail:
            raise Exception('overflow')
        self.a[self.tail] = x
        if self.tail == self.n - 1:
            self.tail = 0
        else:
            self.tail += 1
        
    def deque(self):
        if self.head + 1 == self.tail:
            raise Exception('underflow')
        if self.head == self.n - 1:
            self.head = 0
        else:
            self.head += 1
        return self.a[self.head]

    def pop(self):
        if self.head + 1 == self.tail:
            raise Exception('underflow')
        if self.tail == 0:
            self.tail = self.n - 1
        else:
            self.tail -= 1

        return self.a[self.tail]

    def __str__(self):
        return str(self.a)
        
