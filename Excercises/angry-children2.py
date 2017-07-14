


def solve(n,k,a):
	a = sorted(a)
	sk = sum(a[0:k])
	d = calculate_coeficient(a[0:k])
	res = d
	
	for i in range(k,n):
		d = d + (k-1)*(sk-l[k-i])*(l[i]-l[k-i]) 
		if res > d:
			res = d
	return res

def calculate_coeficient(l):
	res = l[1] - l[2]
	s = 2
	for i in range(2, len(l)):
		res = l[i] * i - s
		s += l[i]
	return res


n = int(input())
k = int(input())
a = []
for i in range(n)
	a.append(int(input()))

print(solve(n,k,a))
