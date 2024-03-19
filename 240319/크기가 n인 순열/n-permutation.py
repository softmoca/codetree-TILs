def dfs(x):
    if x==n:
        for i in range(len(res)):
            print(res[i],end=' ')
        print()
    else:
        for i in range(1,n+1):
            if ch[i]==0:
                res[x]=i
                ch[i]=1
                dfs(x+1)
                ch[i]=0

n=int(input())

ch=[0]*(n+1)
res=[0]*(n)
dfs(0)