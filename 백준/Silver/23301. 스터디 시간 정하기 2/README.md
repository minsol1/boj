# [Silver IV] 스터디 시간 정하기 2 - 23301 

[문제 링크](https://www.acmicpc.net/problem/23301) 

### 성능 요약

메모리: 16232 KB, 시간: 112 ms

### 분류

구현, 브루트포스 알고리즘

### 제출 일자

2026년 4월 6일 14:24:28

### 문제 설명

<p style="user-select: auto !important;">의찬이는 여러 참가자들을 모아 알고리즘 대회 준비 스터디를 진행하고자 한다. 스터디에 많은 참가자들이 모였지만, 각자 가능한 시간들이 달라 의찬이는 스터디 시간을 정하는데 어려움을 겪고 있다. 의찬이는 바쁘면서도 한가하기 때문에 최대한 다른 참가자들의 시간에 맞춰서 스터디를 진행하고자 한다. <em style="user-select: auto !important;">T</em>시간 동안 스터디를 진행하고자 할 때 참가자들의 시간 만족도를 구해 시간 만족도가 최대인 시간을 찾아주려고 한다.</p>

<p style="user-select: auto !important;">시간 만족도는 스터디 시간 동안 각 참가자들이 참여할 수 있는 시간들의 합이다.</p>

<p style="user-select: auto !important;">예를 들어 스터디를 4시간 동안 진행하려 하고 1번, 2번, 3번 참가자들의 가능한 시간들이 아래 그림과 같다고 하자</p>

<p style="text-align: center; user-select: auto !important;"><img alt="" src="https://upload.acmicpc.net/75d67214-cc62-45ce-b6a9-90832a4c985e/-/preview/" style="height: 281px; width: 700px; user-select: auto !important;"></p>

<p style="text-align: center; user-select: auto !important;"><그림 1> 참가자별로 스터디가 가능한 시간 예시</p>

<p style="user-select: auto !important;">1번 참가자는 시각 0부터 시각 6까지의 시간에 스터디가 가능하다.</p>

<p style="user-select: auto !important;">2번 참가자는 시각 1부터 시각 3까지, 시각 4부터 시각 6까지의 시간에 스터디가 가능하다.</p>

<p style="user-select: auto !important;">3번 참가자는 시각 4부터 시각 8까지의 시간에 스터디가 가능하다.</p>

<p style="user-select: auto !important;">스터디를 시각 2부터 시각 6까지 진행한다면 시간 만족도는 4 + (1 + 2) + 2 = 9 가 되며, 이는 시간 만족도가 최대인 시간이다.</p>

<p style="user-select: auto !important;">참가자들이 스터디에 참여할 수 있는 시간들을 입력받아 시간 만족도가 최대인 시간을 찾아 출력한다. 시간 만족도가 최대인 시간이 여러 개라면 시작 시간이 가장 빠른 시간을 출력한다.</p>

### 입력 

 <p style="user-select: auto !important;">첫째 줄에는 스터디에 참가하고자하는 참가자 수 <em style="user-select: auto !important;">N</em>과 스터디 시간 <em style="user-select: auto !important;">T</em>가 주어진다. (1 ≤ <em style="user-select: auto !important;">N</em> ≤ 1000, 1 ≤ <em style="user-select: auto !important;">T</em> ≤ 1000)</p>

<p style="user-select: auto !important;">다음 줄부터 참가하고자 하는 참가자들의 시간 정보가 <em style="user-select: auto !important;">N</em>개 주어진다.</p>

<p style="user-select: auto !important;">각 정보의 첫째 줄에는 가능한 시간의 수 <em style="user-select: auto !important;">K</em>가 주어진다. <i style="user-select: auto !important;">K</i>는 1이상의 자연수이고 입력받은 모든 <i style="user-select: auto !important;">K</i>의 합은 5000을 넘지 않는다.</p>

<p style="user-select: auto !important;">각 정보의 두번째 줄부터 <em style="user-select: auto !important;">K</em>개의 줄에 걸쳐 가능한 시간의 시작 시각 <em style="user-select: auto !important;">S<sub style="user-select: auto !important;">i</sub></em>와 끝나는 시각 <em style="user-select: auto !important;">E<sub style="user-select: auto !important;">i</sub></em>가 주어진다. 이때 <em style="user-select: auto !important;">E<sub style="user-select: auto !important;">i</sub></em> < <em style="user-select: auto !important;">S<sub style="user-select: auto !important;">i+1</sub></em> (1 ≤ <em style="user-select: auto !important;">i</em> < <em style="user-select: auto !important;">K</em>)을 만족한다. (0 ≤ <em style="user-select: auto !important;">S<sub style="user-select: auto !important;">i</sub></em> < <em style="user-select: auto !important;">E<sub style="user-select: auto !important;">i</sub></em> ≤ 1000)</p>

### 출력 

 <p style="user-select: auto !important;">시간 만족도가 최대인 시간을 찾아 시작 시각과 끝나는 시각을 공백 한 칸을 사이에 두고 출력한다. 시간 만족도가 최대인 시간이 여러 개라면 시작 시간이 가장 빠른 시간을 출력한다.</p>

