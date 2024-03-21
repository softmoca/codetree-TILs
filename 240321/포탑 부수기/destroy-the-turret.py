from collections import deque

n, m, k = tuple(map(int, input().split()))
board = [list(map(int, input().split())) for _ in range(n) ]
rec = [ [0] * m for _ in range(n)] # 최근 턴에 대한 정보 저장

dxs, dys = [0, 1, 0, -1], [1, 0, -1, 0] # 레이저 이동 경로
dxs2, dys2 = [ 0, 0, -1, -1, -1, 1, 1, 1], [ -1, 1, 0, -1, 1, 0, -1, 1] # 포탑의 경로
 
turn = 0

# 빛의 공격을 할 때 방문 여부와 경로 방향을 기록해줍니다.
vis = [[0] * m for _ in range(n)]
back_x = [[0] * m for _ in range(n)]
back_y = [ [0] * m for _ in range(n)]


#공격과 무관했는지 여부를 저장하니다.
is_active = [[False] * m for _ in range(n)]

# 살아있는 포탑을 관리
live_turret = []


def init():
    global turn
    
    turn += 1
    for i in range(n):
        for j in range(m):
            vis[i][j] = False
            is_active[i][j] = False

# 가장 약한 포탑이 n+m만큼 강해지는 각성
def awake():
    # 우선순위대로 정렬해서 찾기
    live_turret.sort(key=lambda x : (x[3], -x[2], -(x[0] + x[1]), -x[1]))

    weak_turret = live_turret[0]
    x, y, r, p = weak_turret

    board[x][y] += n + m
    rec[x][y] = turn
    p = board[x][y]
    r = rec[x][y]
    is_active[x][y] = True

    live_turret[0] = (x, y, r, p)

# 레이저 공격 진행
def laser_attack():
    weak_turret = live_turret[0]
    sx, sy, _, power = weak_turret
    strong_turret = live_turret[-1]
    ex, ey, _, _ = strong_turret

    # bfs를 사용해 최단 경로 관리
    q = deque()
    vis[sx][sy] = True
    q.append((sx, sy))

    can_attack = False

    while q:
        x, y = q.popleft()

        if x == ex and y == ey: # 가장 강한 포탑에 도달할 수 있으면 멈춘다.
            can_attack = True
            break

        for k in range(4):
            nx=(x+dxs[k] +n)%n
            ny=(y+dys[k] +m)%m



            if vis[nx][ny]: 
                continue

            if board[nx][ny] == 0: 
                continue

            vis[nx][ny] = True
            back_x[nx][ny] = x
            back_y[nx][ny] = y
            q.append((nx, ny))

    if can_attack:
        board[ex][ey] -= power
        if board[ex][ey] < 0: 
            board[ex][ey] = 0
        is_active[ex][ey] = True

        cx = back_x[ex][ey]
        cy = back_y[ex][ey]

        while not (cx == sx and cy == sy):
            board[cx][cy] -= power // 2
            if board[cx][cy] < 0: 
                board[cx][cy] = 0
            is_active[cx][cy] = True

            next_cx = back_x[cx][cy]
            next_cy = back_y[cx][cy]

            cx = next_cx
            cy = next_cy
    return can_attack


def bomb_attack():
    weak_turret = live_turret[0]
    sx, sy, _, power = weak_turret

    strong_turret = live_turret[-1]
    ex, ey, _, _ = strong_turret

    for dx2, dy2 in zip(dxs2, dys2):
        nx = (ex + dx2 + n) % n
        ny = (ey + dy2 + m) % m


        if nx == ex and ny == ey:
            board[nx][ny] -= power
            if board[nx][ny] < 0: 
                board[nx][ny] = 0
            is_active[nx][ny] = True
        else:
            board[nx][ny] -= power // 2
            if board[nx][ny] < 0: 
                board[nx][ny] = 0
            is_active[nx][ny] = True


def reserve():
    for i in range(n):
        for j in range(m):
            if is_active[i][j]: 
                continue
            if board[i][j] == 0: 
                continue
            board[i][j] += 1



for _ in range(k):
    live_turret = []
    for i in range(n):
        for j in range(m):
            if board[i][j]:
                live_turret.append((i, j, rec[i][j], board[i][j]))
    

    if len(live_turret) <= 1: 
        break

    init()

    awake()

    is_suc = laser_attack()
    if not is_suc: 
        bomb_attack()

    reserve()

ans = 0
for i in range(n):
    for j in range(m):
        ans = max(ans, board[i][j])

print(ans)