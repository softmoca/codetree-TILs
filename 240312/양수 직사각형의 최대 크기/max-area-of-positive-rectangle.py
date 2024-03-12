def largest_positive_rectangle(n, m, grid):
    max_area = 0
    
    for i in range(n):
        for j in range(m):
            min_value = float('inf')
            for k in range(i, n):
                for l in range(j, m):
                    if grid[k][l] <= 0:
                        break
                    min_value = min(min_value, grid[k][l])
                    area = (k - i + 1) * (l - j + 1)
                    max_area = max(max_area, area)
                    if min_value * (k - i + 1) > max_area:
                        break
    
    if max_area == 0:
        return -1
    else:
        return max_area

# 입력 받기
n, m = map(int, input().split())
grid = []
for _ in range(n):
    row = list(map(int, input().split()))
    grid.append(row)

# 결과 출력
print(largest_positive_rectangle(n, m, grid))