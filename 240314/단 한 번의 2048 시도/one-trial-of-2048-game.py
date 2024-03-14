arr=[list(map(int,input().split())) for _ in range(4)]
dir=input()



if dir=='L':
    for row in range(4):
        temp=[0]*4
        start_point_col=0
        for col in range(4):
            if arr[row][col]!=0:
                temp[start_point_col]=arr[row][col]
                start_point_col+=1

        for i in range(4):
            arr[row][i]=temp[i]


    for row in range(4):
        for col in range(3):
            if arr[row][col]==arr[row][col+1]:
                arr[row][col]=2*arr[row][col]
                for i in range(col+1,4):
                    if i==3:
                        arr[row][i]=0
                    else:
                        arr[row][i]=arr[row][i+1]
                        arr[row][i+1]=0
                break





if dir=='R':
    for row in range(4):
        temp=[0]*4
        start_point_col=3
        for col in range(3,-1,-1):
            if arr[row][col]!=0:
                temp[start_point_col]=arr[row][col]
                start_point_col-=1

        for i in range(4):
            arr[row][i]=temp[i]

    for row in range(4):
        for col in range(3,0,-1):
            if arr[row][col]==arr[row][col-1]:
        
                arr[row][col]=2*arr[row][col]
                
                for i in range(col-1,-1,-1):
                    if i==0:
                        arr[row][i]=0
                    else:
                        arr[row][i]=arr[row][i-1]
                        arr[row][i-1]=0
                break


if dir=='U':
    for col in range(4):
        temp=[0]*4
        start_point_row=0
        for row in range(4):
            if arr[row][col]!=0:
                temp[start_point_row]=arr[row][col]
                start_point_row+=1
        for i in range(4):
            arr[i][col]=temp[i]

    for col in range(4):
        for row in range(3):
            if arr[row][col]==arr[row+1][col]:
                arr[row][col]=2*arr[row][col]
                for i in range(row+1,4):
                    if i==3:
                        arr[i][col]=0
                    else:
                        arr[i][col]=arr[i+1][col]
                        arr[i+1][col]=0
                
                break

if dir=='D':
    for col in range(4):
        temp=[0]*4
        start_point_row=3
        for row in range(3,-1,-1):
            if arr[row][col]!=0:
                temp[start_point_row]=arr[row][col]
                start_point_row-=1
        for i in range(4):
            arr[i][col]=temp[i]

    for col in range(4):
        for row in range(3,-1,-1):
            if arr[row][col]==arr[row-1][col]:
                arr[row][col]=2*arr[row][col]
  
                
                for i in range(row-1,-1,-1):
                    if i==0:
                        arr[i][col]=0
                    else:
                        arr[i][col]=arr[i-1][col]
                        arr[i-1][col]=0
                break


for i in range(4):
    for j in range(4):
        print(arr[i][j],end=' ')
    print()



# 1. 방향으로 모두 이동
# 2. 매 행/열 마다 temp 배열 사용
# 3.