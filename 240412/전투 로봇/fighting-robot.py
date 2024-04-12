#  한칸에는 최대 하나의 몬스터만 존재
#     - 초기 레벨 2, 1초에 상하좌우 인접칸 이동

#     - 자신레벨보다 큰 몬스터 칸은 못지나간다. 같거나 작으면 이동가능
#     # 이동 규칙
#        1) 없앨수 있는 몬스터가 있으면 해당 몬스터를 없애러 간다.
#        2) 없앨수 있는 몬스터가 하나 이상이라면, 거리가 가장 작은은 곳으로 이동 -> bfs
#        3) 거리== 해당 칸으로 가는데 지나가야하는 칸의 수
#        4) 행이 작은게 우선순위 그다음은 열이 작은거
#
#    종료 조건 : 없앨수 있는 몬스터가 없다면 종료
#    출력 : 걸린 시간

# 시물레이션
# 0)
# 9인 값 찾고 좌표 저장 후 해당 칸 0으로 변경(이동가능하게)      robot_row, robot_col에 저장
# 로봇 레벨 나타내는 level 변수
# 레벨 마다 잡은 몬스터를 나타내는 catch_cnt변수
#
# 1) 자신보다 레벨 낮은 몬스터 찾기  bfs -> 방문 체크 2차원배열
# 2) 없다면 종료  -> 후보 리스트 len으로 판별
# 3) 있다면 최소행, 최소열의 몬스터로 이동  ->  후보 리스트 저장 후 행작고,열작은 순 정렬       step배열(거리) 로 robot_row,col 변경 ,  second 후보 리스트[0]값 만큼  +

from collections import deque

n=int(input())
arr=[list(map(int,input().split())) for i in range(n)]
ch=[[0]*n for i in range(n)]
step=[[0]*n for i in range(n)]
level=2
catch_cnt=0
robot_row=-1
robot_col=-1
dx=[-1,0,1,0]
dy=[0,1,0,-1]
nestest_monster=[]
second=0
def find_robot():
    global  robot_row,robot_col

    for row in range(n):
        for col in range(n):
            if arr[row][col] == 9:
                robot_row = row
                robot_col = col
                arr[row][col] = 0
                return
def reset_ch_step():
    global  nestest_monster
    nestest_monster = []
    for row in range(n):
        for col in range(n):
            ch[row][col] = 0
            step[row][col] = 0

def bfs(robot_row,robot_col,nestest_monster):

    reset_ch_step()
    q=deque()
    q.append([robot_row,robot_col])

    ch[robot_row][robot_col]=1
    while q:

        row,col=q.popleft()
        if 1<=arr[row][col]<level:
            nestest_monster.append([row,col])

        for k in range(4):
            nx=row+dx[k]
            ny=col+dy[k]

            if 0<=nx<n and 0<=ny<n and ch[nx][ny]==0 and arr[nx][ny]<=level:
                ch[nx][ny]=1
                q.append([nx,ny])

# 초기 로봇 위치 찾기
find_robot()

while True:

    # 1) 자신보다 레벨 낮은 몬스터 찾기
    reset_ch_step()
    q = deque()
    q.append([robot_row, robot_col])
    ch[robot_row][robot_col] = 1
    while q:

        row,col=q.popleft()
        if 1<=arr[row][col]<level:
            nestest_monster.append([row,col])

        for k in range(4):
            nx=row+dx[k]
            ny=col+dy[k]

            if 0<=nx<n and 0<=ny<n and ch[nx][ny]==0 and arr[nx][ny]<=level:
                ch[nx][ny]=1
                step[nx][ny]=step[row][col]+1
                q.append([nx,ny])

    # nestest에서 최단 거리 찾기
    nn=[]
    min_dist=1000
    nestest_monster.sort(key=lambda x: (x[0], x[1]))

    for row, col in nestest_monster:
        if step[row][col]<=min_dist:
            min_dist=step[row][col]

    for row,col in nestest_monster:
        if step[row][col]==min_dist:
            nn.append([row,col])

    nn.sort(key=lambda x: (x[0], x[1]))




    # 없다면 종료
    if len(nestest_monster)==0:
        break

    # 잡고 레벨 체크
    catch_cnt+=1
    if catch_cnt==level:
        level+=1
        catch_cnt=0

    nestest_monster_row = nn[0][0]
    nestest_monster_col = nn[0][1]
    robot_row = nestest_monster_row
    robot_col = nestest_monster_col
    second+=step[nestest_monster_row][nestest_monster_col]  # 시간 증가
    arr[nestest_monster_row][nestest_monster_col]=0       # 잡은 몬스터는 0으로 변경



print(second)