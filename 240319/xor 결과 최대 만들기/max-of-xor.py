def chec_xor(res):
    result=0
    for x in res:
        result^=x
    return result

def dfs(x,s):
    global max_answer
    if x==m:
        max_answer=max(max_answer,chec_xor(res))
        



    else:
        for i in range(s,n):
            res[x]=arr[i]
            dfs(x+1,i+1)

n,m=map(int,input().split())
arr=list(map(int,input().split()))
res=[0]*m
max_answer=0
dfs(0,0)

print(max_answer)