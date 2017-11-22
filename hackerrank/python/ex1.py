
def do_private(sl):
    if len(sl) == 0 or len(sl) == 1:
        return sl
    for i in range(len(sl)-1):
        if sl[i] == sl[i+1]:
            sl.pop(i)
            sl.pop(i)
            return do_private(sl)
    return sl

def do(s):
    sl = list(s)
    res = do_private(sl)
    if len(res) == 0:
        print 'Empty String'
    else:
        print ''.join(res)

    
   
s = raw_input()
do(s)
