def binary_search(arr,s,e,x):
    if s == e:
        return s
    middle = (s+e)/2
    if x <= arr[middle]:
        return binary_search(arr,s,middle,x)
    return binary_search(arr,middle+1,e,x)


def test_binary_search():
    a1 = [0]
    print a1,binary_search(a1,0,len(a1)-1,0)
    a2 = [0,1]
    print a2,0,binary_search(a2,0,len(a2),0)
    print a2,1,binary_search(a2,0,len(a2),1)
    print a2,2,binary_search(a2,0,len(a2),2)
    a3 = [0,1,2,2,2,5]
    print a3,2,binary_search(a3,0,len(a3),2)
    print [],3,binary_search([],0,len([]),3)
    a4 = [-10,-7,-5,-4,-4,0,0,1,2,5,6,7,9,10]
    print a4,0,binary_search(a4,0,len(a4),0)
