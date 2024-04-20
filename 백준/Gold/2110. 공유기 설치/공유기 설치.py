import sys
input = sys.stdin.readline
n,m=map(int,input().split())
data=[]
for _ in range(n):
    data.append(int(input()))
data.sort()
start=1
end=data[-1]-data[0]
answer=0
while start<=end:
    mid=(start+end)//2
    value=data[0]
    count=1
    

    for i in range(1,len(data)):
        if data[i]>=value+mid:
            count+=1
            value=data[i]
            
    if count<m:
        end=mid-1
    elif count>=m:
        start=mid+1
        answer=mid

print(answer)
