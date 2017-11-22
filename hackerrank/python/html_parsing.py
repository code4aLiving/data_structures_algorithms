

def parse(html):
	res = []
	label = ""
	for c in html:
		if c == ">":
			label += c
			res.append(label)
			label = ""
		if len(label) or c == "<":
			label += c
	return res

if __name__=="__main__":
	text = "<html><head><title>My Page</title></head><body>Hello</body></html>"
	print(parse(text))
	
	
