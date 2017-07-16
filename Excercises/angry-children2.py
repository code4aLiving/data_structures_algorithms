

def solve(n,k,a):
	a = sorted(a)
	sk = sum(a[0:k])
	d = calculate_coeficient(a[0:k])
	res = d
	
	for i in range(k,n):
		d = d + (k-1)*(a[i-k] + a[i]) - 2*(sk-a[i-k]) 
		if res > d:
			res = d
			print("best result so far",res,i)
		sk -= a[i-k]
		sk += a[i]
	return res

def calculate_coeficient(l):
	res = l[1] - l[0]
	s = sum(l[0:2])
	print(res,s)
	for i in range(2, len(l)):
		res += l[i] * i - s
		s += l[i]
		print(res, s, i)
	print("sum is %d" % res)
	return res

n = int(input())
k = int(input())
a = []
for i in range(n):
	a.append(int(input()))

print(solve(n,k,a))
