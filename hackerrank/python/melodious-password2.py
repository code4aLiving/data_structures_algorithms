import string
def get_passwords(n,len2,len1):
    if n == 0:
        yield ''
    elif n == 1:
        for p1 in len1:
            yield p1
    else:
        for p2 in len2:
            for password in get_passwords(n-2,len2,len1):
                yield p2+password

def solve(n):
    vowels = ['a','e','i','o','u']
    consonants = list(set(list(string.ascii_lowercase)) - set(vowels + ['y']))
    len2v = []
    len2c = []
    res = []
    for v in vowels:
        for c in consonants:
            len2v.append('{}{}'.format(v,c))
            len2c.append('{}{}'.format(c,v))
    print('finished precomputation')
    if not n%2:
        for p in get_passwords(n,len2v,vowels):
            res.append(p)
            res.append(p[::-1])
    else:
        for p in get_passwords(n,len2v,vowels):
            res.append(p)            
        for p in get_passwords(n,len2c,consonants):
            res.append(p)
    print("\n".join(res))
        
n = int(input())
solve(n)
