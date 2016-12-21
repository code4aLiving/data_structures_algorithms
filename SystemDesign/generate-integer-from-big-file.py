import sys

def generate_integer(fileName):
    with open(fileName,'r') as f:
        maximum = -sys.maxint
        i = 0
        line = f.readline()
        while line:
            value = int(line)
            if maximum < value:
                maximum = value
            line = f.readline()
            if i > 10**4 and not i%10**4:
                print i,maximum
        return maximum + 1


def generate_file(size):
    with open('integers','w') as f:
        for i in xrange(size):
            f.write("{}\n".format(i))

                

        
        
