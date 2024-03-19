def dfs(x):
    for i in range(n+1):
        if graph[x][i]==1 and ch[i]==0:
            ch[i]=1
            dfs(i)

    

n,m=map(int,input().split())

graph=[[0]*(n+1) for _ in range(n+1)]

for _ in range(m):
    a,b=map(int,input().split())
    graph[a][b]=1
    graph[b][a]=1

answer=-1
ch=[0]*(n+1)
ch[1]=1
dfs(1)

for x in ch:
    if x==1:
        answer+=1
print(answer)