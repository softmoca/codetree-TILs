def max_positive_rectangle(n, m, grid):
    # 누적 합 계산
    prefix_sum = [[0 for _ in range(m + 1)] for _ in range(n + 1)]
    for i in range(1, n + 1):
        for j in range(1, m + 1):
            prefix_sum[i][j] = prefix_sum[i - 1][j] + prefix_sum[i][j - 1] - prefix_sum[i - 1][j - 1] + grid[i - 1][j - 1]

    # 최대 크기 초기화
    max_size = -1

    # 모든 칸을 시작점으로 하여 가능한 직사각형 검사
    for i in range(n):
        for j in range(m):
            # 현재 칸부터 시작하는 직사각형의 최대 크기 계산
            for k in range(i + 1, n + 1):
                for l in range(j + 1, m + 1):
                    # 직사각형 내 모든 숫자가 양수인지 확인
                    if all(grid[p][q] > 0 for p in range(i, k) for q in range(j, l)):
                        # 현재 칸부터 시작하는 직사각형의 크기 계산
                        size = (k - i) * (l - j)

                        # 만약 현재 칸부터 시작하는 직사각형의 크기가 더 크다면 최대 크기 업데이트
                        max_size = max(max_size, size)

    return max_size

# 입력 받기
n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

# 최대 크기 출력
print(max_positive_rectangle(n, m, grid))