# 1. 시작점 보다 작으면서 인접해서 이동할수 있는 체크한 temp배열 만들기                   check_bfs
# 2. tmep 배열 중 가장 큰 좌상단 값 찾기 -> 좌표 찾기    -> 큰값없으면 리턴 
# 3. bfs로 찾기
#

from collections import deque


def find_next_post():
    maxx=0
    max_pos=[-1,-1]
    for row in range(n):
        for col in range(n):
            if temp[row][col]==1:
                maxx=max(maxx,arr[row][col])

    #print(maxx)        
    if maxx==0:
        return False
    
    for row in range(n):
        for col in range(n):
            if temp[row][col]==1 and arr[row][col]==maxx:
                return [row,col]



def check_bfs(start_row,start_col):
    flag=0
    q=deque()
    q.append([start_row,start_col])
    temp[start_row][start_col]=1

    while q:
        x,y=q.popleft()
        for k in range(4):
            nx=x+dx[k]
            ny=y+dy[k]

            if 0<=nx<n and 0<=ny<n and temp[nx][ny]==0 and arr[start_row][start_col]>arr[nx][ny]:
                flag=1
                temp[nx][ny]=1
                q.append([nx,ny])

    if flag==0:
        return False
    else:
        return True



n,k=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]
temp=[[0]*n for _ in range(n)]
ch=[[0]*n for _ in range(n)]
q=deque()
dx=[-1,0,1,0]
dy=[0,1,0,-1]

start_row,start_col=map(int,input().split())
q.append([start_row-1,start_col-1])
start_col-=1
start_row-=1
#print(start_row,start_col)
for w in range(k):
    
    for  row in range(n):
        for col in range(n):
            temp[row][col]=0

    if check_bfs(start_row,start_col)==False:
        print('break1', start_row+1,start_col+1)
        break
    temp[start_row][start_col]=0
    # for x in temp:
    #     print(x)
    
    
    if find_next_post()==False:
        print('break2', start_row+1,start_col+1)
        break
   

    start_row,start_col=find_next_post()
    # print('e',w,start_row,start_col)
    # print()
else:
    print(start_row+1,start_col+1)