

def solve(a, r):
    d = {}
    for i in range(len(a)):
        d.setdefault(a[i], []).append(i)
    res = 0
    for i in range(len(a)):
        x = a[i]
        xr = x*r
        if xr not in d:
            continue
        
        js = binary_search(d[xr], i, 0, len(d[xr])-1)
        xrr = xr * r
        if xrr not in d:
            continue
        for j in js:
            res += len(binary_search(d[xrr], j, 0, len(d[xrr])-1))
    return res

def binary_search(arr, x, s, e):
    if (arr[s] > x):
        return arr[s:]
    if (arr[e] < x):
        return []
    if s+1==e:
        return arr[e:e+1]
    mid = (s + e) // 2
    return binary_search(arr, x, mid, e) if arr[mid] < x else binary_search(arr, x, s, mid)    

if __name__ == "__main__":
    n, r = tuple(map(int, input().split(" ")))
    a = list(map(int, input().split(" ")))
    res = solve(a, r)
    print(res)