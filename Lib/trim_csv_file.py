
import csv
import sys

def trim_file(in_file,out_file,lines):
    batch_size = 10**3
    with open(in_file, 'r',newline='') as infile:
        spamreader = csv.reader(infile, delimiter=',', quotechar='"')
        with open(out_file,'w',newline='') as outfile:
            spamwriter = csv.writer(outfile, delimiter=',', quotechar='"',
                                    quoting=csv.QUOTE_MINIMAL)
            for row in spamreader:
                if not lines:
                    break
                spamwriter.writerow(row)
                lines-=1


if __name__ == "__main__":
    args = sys.argv
    if len(args) != 4:
        print('You should provide exactly 3 arguments: in_file out_file lines')
    in_file = args[1]
    out_file = args[2]
    lines = int(args[3])
    trim_file(in_file,out_file,lines)
    print('Done: {}'.format(out_file))
