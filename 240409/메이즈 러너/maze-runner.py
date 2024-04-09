n,m,k=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]
next_arr=[[0]*n for _ in range(n)]
person=[]
dx=[-1,1,0,0]
dy=[0,1,0,-1]


for _ in range(m):
    row,col=map(int,input().split())
    person.append([row-1,col-1])
    
exit_row,exit_col=map(int,input().split())
exit_row-=1
exit_col-=1
answer=0

def move_all():
    global answer
    for i in range(m):
        if person[i]==[exit_row,exit_col]:
            continue

        row,col=person[i]

        if exit_row != row:
            if exit_row<row:
                next_row=row-1
                if arr[next_row][col]==0:
                    person[i]=[next_row,col]
                    answer+=1
                    continue
            if exit_row>row:
                next_row=row+1      
                if arr[next_row][col]==0:
                    person[i]=[next_row,col]
                    answer+=1
                    continue

        if exit_col !=col:
            if exit_col<col:
                next_col=col-1
                if arr[row][next_col]==0:
                    person[i]=[row,next_col]
                    answer+=1
                    continue
            if exit_col>col:
                next_col=col+1
                if arr[row][next_col]==0:
                    person[i]=[row,next_col]
                    answer+=1
                    continue


def find_smallest_square():
    for ss in range(1,n):
        for srow in range(n):
            for scol in range(n):
                erow=srow+ss
                ecol=scol+ss

                if not(srow<=exit_row<=erow and scol<=exit_col<=ecol):
                    continue
                
                for i in range(m):
                    if (srow<=person[i][0] <=erow and scol<=person[i][1]<=ecol):
                        if person[i][0]==exit_row and person[i][1]==exit_col:
                            continue


                        return srow,scol,ss
                

def rotate_arr(srow,scol,ss):
    for row in range(srow,srow+ss+1):
        for col in range(scol,scol+ss+1):
            if arr[row][col]:
                arr[row][col]-=1
    
    for row in range(srow,srow+ss+1):
        for col in range(scol,scol+ss+1):
            ox=row-srow
            oy=col-scol

            rx=oy
            ry=ss-ox
            next_arr[rx+srow][ry+scol]=arr[row][col]
    for row in range(srow,srow+ss+1):
        for col in range(scol,scol+ss+1):
            arr[row][col]=next_arr[row][col]


def rotate_person(srow,scol,ss):
    global exit_row,exit_col

    for i in range(m):
        tx=person[i][0]
        ty=person[i][1]

        if srow<=tx<=srow+ss and scol <=ty<=scol+ss:
            ox,oy=tx-srow,ty-scol
            rx,ry=oy,ss-ox
            person[i][0]=rx+srow
            person[i][1]=ry+scol

    if srow <= exit_row <= srow + ss and scol <= exit_col <= scol + ss:
        # Step 1. (sx, sy)를 (0, 0)으로 옮겨주는 변환을 진행합니다. 
        ox, oy = exit_row - srow, exit_col - scol
        # Step 2. 변환된 상태에서는 회전 이후의 좌표가 (x, y) . (y, square_n - x - 1)가 됩니다.
        rx, ry = oy, ss - ox 
        # Step 3. 다시 (sx, sy)를 더해줍니다.
        exit_row=rx + srow
        exit_col= ry + scol



for _ in range(k):

    move_all()

    is_all_pass=True
    for i in range(m):
        if person[i]!=[exit_row,exit_col]:
            is_all_pass=False
    if is_all_pass:
        break

    srow,scol,ss=find_smallest_square()
    rotate_arr(srow,scol,ss)

    rotate_person(srow,scol,ss)


print(answer)
print(exit_row+1,exit_col+1)