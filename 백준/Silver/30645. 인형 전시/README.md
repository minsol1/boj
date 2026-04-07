# [Silver II] 인형 전시 - 30645 

[문제 링크](https://www.acmicpc.net/problem/30645) 

### 성능 요약

메모리: 147260 KB, 시간: 1116 ms

### 분류

그리디 알고리즘, 정렬

### 제출 일자

2026년 4월 7일 12:04:19

### 문제 설명

<p style="text-align: center; user-select: auto !important;"><img alt="" height="426" src="https://u.acmicpc.net/bf22dde9-1535-469c-876f-f37469872f9f/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-10-15%20154438.png" width="568" style="user-select: auto !important;"></p>

<p style="user-select: auto !important;">탁자 위에 인형을 전시하려고 한다. 탁자는 위에서 보았을 때 <em style="user-select: auto !important;">R</em>개의 행과 <em style="user-select: auto !important;">C</em>개의 열을 가진 <em style="user-select: auto !important;">R</em> ×<em style="user-select: auto !important;"> C</em>개의 칸을 가진 2차원 배열이며, 각 칸에 하나의 인형을 전시할 수 있다. 현재 전시할 수 있는 인형은 N개이며, 탁자 위에 N개의 인형을 모두 전시할 필요는 없다.</p>

<p style="user-select: auto !important;">탁자를 정면으로 보면 1행에 놓은 인형들이 맨 앞쪽에 있는 방향으로 보게 되는데, 같은 열에 있는 인형들에 대해 앞쪽 행에 인형을 놓은 경우 앞쪽 인형보다 뒤쪽 행에 있고 높이가 앞쪽 인형의 높이 이하인 인형은 앞쪽 인형에 가려져 보이지 않게 된다.</p>

<p style="user-select: auto !important;">이때, 탁자에 인형들을 적당히 배치했을 때 탁자의 정면 방향에서 보이는 인형의 개수의 최댓값을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p style="user-select: auto !important;">첫 번째 줄에 탁자의 행의 개수 <em style="user-select: auto !important;">R</em>과 열의 개수 <em style="user-select: auto !important;">C</em>가 주어진다.</p>

<p style="user-select: auto !important;">두 번째 줄에 탁자에 전시할 수 있는 인형의 개수 <em style="user-select: auto !important;">N</em>이 주어진다.</p>

<p style="user-select: auto !important;">세 번째 줄에 <em style="user-select: auto !important;">N</em>개의 인형의 높이 h<sub style="user-select: auto !important;">1</sub>, h<sub style="user-select: auto !important;">2</sub>, …, h<sub style="user-select: auto !important;">N</sub>이 주어진다.</p>

### 출력 

 <p style="user-select: auto !important;">탁자의 정면 방향에서 보이는 인형의 개수의 최댓값을 출력한다.</p>

