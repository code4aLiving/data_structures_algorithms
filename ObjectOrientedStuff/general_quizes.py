x = 0
y = 0
z = 0
def incr(x):
    global y
    y = x + 1
    z = x + 1
    return y
incr(5)
print x, y, z
