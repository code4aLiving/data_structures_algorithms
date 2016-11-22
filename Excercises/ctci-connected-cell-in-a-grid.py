def get_biggest_region(grid):
    global visited
    visited = set()
    res = 0
    for row in range(len(grid)):
        for column in range(len(grid[0])):
            if grid[row][column] == 0 or (column,row) in visited:
                continue
            print visited,column,row
            res = max(res,region_count(grid,column,row))
    return res

def region_count(grid,column,row):
    global visited
    y = len(grid)
    x = len(grid[0])
    if (column,row) in visited:
        return 0
    visited.add((column,row))
    count = 1
    for rw in range(max(0,row-1),min(row+2,y)):
        for col in range(max(0,column-1),min(column+2,x)):
            if grid[rw][col] == 0:
                continue
            count += region_count(grid,col,rw)
    return count
    

n = int(raw_input().strip())
m = int(raw_input().strip())
grid = []
for grid_i in xrange(n):
    grid_temp = map(int, raw_input().strip().split(' '))
    grid.append(grid_temp)
print get_biggest_region(grid)
