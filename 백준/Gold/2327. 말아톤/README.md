# [Gold III] 말아톤 - 2327 

[문제 링크](https://www.acmicpc.net/problem/2327) 

### 성능 요약

메모리: 12980 KB, 시간: 148 ms

### 분류

다이나믹 프로그래밍, 배낭 문제

### 제출 일자

2026년 4월 10일 14:42:28

### 문제 설명

<p style="user-select: auto !important;">오늘은 즐거운 체육 대회이다. 학생들은 그룹 달리기에 출전할 팀을 선발하려고 한다. 그룹달리기는 말아톤과 같은 형식이다. 모든 팀의 구성원들이 출발지점에서 골인지점을 향해 동시에 출발을 한다. 팀의 성적은 그 팀의 구성원 중 가장 늦게 도착한 사람의 도착시간으로 하기 때문에 구성원 중 달리기 속도가 가장 느린 사람이 가장 빠르게 되도록 팀을 선발해야 한다. 이번 대회에서는 팀을 선발할 때 특별한 제약조건이 하나 있는데 그것은 출전 팀 구성원들의 키를 모두 더했을 때 정확히 H가 되어야 한다는 것이다. 키의 합이 H만 된다면 구성원이 몇 명이 되든 상관이 없다.</p>

<p style="user-select: auto !important;">학생 중에서 그룹달리기에 출전할 팀을 선발하는 프로그램을 작성하시오.</p>

### 입력 

 <p style="user-select: auto !important;">첫 번째 줄엔 H와 학생 수인 N이 주어진다.</p>

<p style="user-select: auto !important;">두 번째 줄부터 학생들의 정보 h<sub style="user-select: auto !important;">i</sub>, s<sub style="user-select: auto !important;">i</sub>가 주어지는데 h<sub style="user-select: auto !important;">i</sub>는 i번째 학생의 키이며 s<sub style="user-select: auto !important;">i</sub>는 i번째 학생의 달리기 속도이다.</p>

### 출력 

 <p style="user-select: auto !important;">출전 팀 구성원 중 가장 느린 사람의 달리기 속도를 출력하시오.</p>

