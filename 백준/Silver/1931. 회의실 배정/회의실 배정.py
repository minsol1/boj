import sys
N = int(input())
time = []
for i in range(N):
    time.append(list(map(int,sys.stdin.readline().split())))
time.sort(key= lambda x:(x[1],x[0]))
current = 0
cnt =0

for i in time:
    if i[1]>=current and current<=i[0]:
        current=i[1]
        cnt+=1
print(cnt)
