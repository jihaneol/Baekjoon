n=int(input())
data=list(map(int,input().split()))
data.reverse()

dp=[1]*n

for i in range(1,n):
    for j in range(i):
        if data[j]<data[i]:
            dp[i] = max(dp[i],dp[j]+1)
            
print(n-max(dp))
