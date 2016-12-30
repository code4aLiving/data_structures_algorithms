
def shift_in_place(l,n):
    n = n % len(l)
    temp = l[0]
    i = n
    while i > 0:
        temp2 = l[i]
        l[i] = temp
        temp = temp2
        i = i + n if i + n < len(l) else i + n - len(l)
    l[i]=temp
    return l
    
