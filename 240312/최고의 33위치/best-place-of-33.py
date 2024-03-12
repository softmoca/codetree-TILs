def count_coin(row_s,col_s):
    summ=0
    for row in range(row_s,row_s+3):
        for col in range(col_s,col_s+3):
            summ=summ+arr[row][col]
    return summ




n=int(input())
arr=[list(map(int,input().split())) for _ in range(n)]

Maxx=0

for row in range(n):
    for col in range(n):
        if row+3>n or col +3>n:
            continue

        cnt=count_coin(row,col)
        Maxx=max(Maxx,cnt)
print(Maxx)