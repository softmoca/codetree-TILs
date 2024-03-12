def count_one_block(start_col):
    return sum(arr[row][start_col:start_col+3])


def count_one_col_bolck(start_row,start_col):
    summ=0
    for i in range(3):
        summ=summ+arr[start_row+i][col]
    return summ

        
# ㄴ 블럭
def count_block1(row,col):
    return arr[row][col]+arr[row+1][col]+arr[row+1][col+1]

# ㄱ 블럭
def count_block2(row,col):
    return arr[row][col]+arr[row][col+1]+arr[row+1][col+1]

# 역 ㄴ 블럭
def count_block3(row,col):
    return arr[row+1][col]+arr[row][col+1]+arr[row+1][col+1]

# 역 ㄱ 블럭
def count_block4(row,col):
    return arr[row][col]+arr[row+1][col]+arr[row][col+1]

n,m=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]


# 1자 블럭
# 가로
Maxx=0
for row in range(n):
    for col in range(m):
        if col+3>m:
            continue
        cnt=count_one_block(col)
        Maxx=max(Maxx,cnt)

# 세로
for row in range(n):
    if row+3>n:
        continue
    for col in range(m):
        
        cnt=count_one_col_bolck(row,col)
        Maxx=max(Maxx,cnt)
        
for row in range(n-1):
    for col in range(m-1):
        Maxx=max(Maxx,count_block1(row,col),count_block2(row,col),count_block3(row,col),count_block4(row,col))


print(Maxx)