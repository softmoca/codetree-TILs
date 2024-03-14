n,m=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]
boom_col=[]
tmep=[[0]*n for _ in range(n)]

def boom_cross(start_row,start_col,power):

    for i in range(n):
        for j in range(n):
            if (i==start_row or j==start_col)  and abs(i-start_row) + abs(j-start_col)<=power:
                arr[i][j]=0
    
    
def drop():
    for col in range(n):
        tmp=[0]*n
        start_tmp=n-1
        for row in range(n-1,-1,-1):
            if arr[row][col]!=0:
                tmp[start_tmp]=arr[row][col]
                start_tmp-=1
        for row in range(n):
            arr[row][col]=tmp[row]

for _ in range(m):
    boom_col.append(int(input()))

for x in boom_col:
    flag=0
    for row in range(n):
        if arr[row][x-1]!=0:
            power=arr[row][x-1]-1
            start_row=row
            start_col=x-1
            flag=1
            break
    if flag==1:
        boom_cross(start_row,start_col,power)

        drop()

for i in range(n):
    for j in range(n):
        print(arr[i][j],end=' ')
    print()