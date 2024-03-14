n=int(input())
arr=[list(map(int,input().split())) for _ in range(n)]
temp=[[0]*n for _ in range(n)]

row,col=map(int,input().split())

row=row-1
col=col-1

power=arr[row][col]

for i in range(power):

    if row+i<n:
        arr[row+i][col]=0
    if col+i<n:
        arr[row][col+i]=0
    if row-i>=0:
        arr[row-i][col]=0
    if col-i >=0:
        arr[row][col-i]=0



for col in range(n):
    temp_start_row=n-1
    for row in range(n-1,-1,-1):
        if arr[row][col]!=0:
            temp[temp_start_row][col]=arr[row][col]
            temp_start_row-=1
        

for i in range(n):
    for j in range(n):
        print(temp[i][j],end=' ')
    print()