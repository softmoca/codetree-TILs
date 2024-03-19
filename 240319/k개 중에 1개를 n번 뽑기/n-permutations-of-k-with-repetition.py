def dfs(x):
    if x==n+1:
        for i in range(len(answer)):
            print(answer[i],end=' ')
        print()
        return
    else:
        for i in range(1,k+1):
            answer.append(i)
            dfs(x+1)
            answer.pop()


k,n=map(int,input().split())

answer=[]

dfs(1)