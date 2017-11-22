
def answer(x,y):
    sumX = sum(x)
    sumY = sum(y)
    if len(x) > len(y):
        return sumX-sumY
    return sumY-sumX
