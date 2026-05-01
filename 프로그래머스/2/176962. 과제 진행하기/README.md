# [level 2] 과제 진행하기 - 176962 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/176962) 

### 성능 요약

메모리: 100 MB, 시간: 58.72 ms

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2026년 05월 01일 15:20:04

### 문제 설명

<p style="user-select: auto !important;">과제를 받은 루는 다음과 같은 순서대로 과제를 하려고 계획을 세웠습니다.</p>

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">과제는 시작하기로 한 시각이 되면 시작합니다.</li>
<li style="user-select: auto !important;">새로운 과제를 시작할 시각이 되었을 때, 기존에 진행 중이던 과제가 있다면 진행 중이던 과제를 멈추고 새로운 과제를 시작합니다.</li>
<li style="user-select: auto !important;">진행중이던 과제를 끝냈을 때, 잠시 멈춘 과제가 있다면, 멈춰둔 과제를 이어서 진행합니다.

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">만약, 과제를 끝낸 시각에 새로 시작해야 되는 과제와 잠시 멈춰둔 과제가 모두 있다면, 새로 시작해야 하는 과제부터 진행합니다.</li>
</ul></li>
<li style="user-select: auto !important;">멈춰둔 과제가 여러 개일 경우, 가장 최근에 멈춘 과제부터 시작합니다.</li>
</ul>

<p style="user-select: auto !important;">과제 계획을 담은 이차원 문자열 배열 <code style="user-select: auto !important;">plans</code>가 매개변수로 주어질 때, 과제를 끝낸 순서대로 이름을 배열에 담아 return 하는 solution 함수를 완성해주세요.</p>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">제한사항</h5>

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">3 ≤ <code style="user-select: auto !important;">plans</code>의 길이 ≤ 1,000

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;"><code style="user-select: auto !important;">plans</code>의 원소는 [name, start, playtime]의 구조로 이루어져 있습니다.

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">name : 과제의 이름을 의미합니다.

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">2 ≤ name의 길이 ≤ 10</li>
<li style="user-select: auto !important;">name은 알파벳 소문자로만 이루어져 있습니다.</li>
<li style="user-select: auto !important;">name이 중복되는 원소는 없습니다.</li>
</ul></li>
<li style="user-select: auto !important;">start : 과제의 시작 시각을 나타냅니다.

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">"hh:mm"의 형태로 "00:00" ~ "23:59" 사이의 시간값만 들어가 있습니다.</li>
<li style="user-select: auto !important;">모든 과제의 시작 시각은 달라서 겹칠 일이 없습니다.</li>
<li style="user-select: auto !important;">과제는 "00:00" ... "23:59" 순으로 시작하면 됩니다. 즉, 시와 분의 값이 작을수록 더 빨리 시작한 과제입니다.</li>
</ul></li>
<li style="user-select: auto !important;">playtime : 과제를 마치는데 걸리는 시간을 의미하며, 단위는 분입니다.

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">1 ≤ playtime ≤ 100</li>
<li style="user-select: auto !important;">playtime은 0으로 시작하지 않습니다.</li>
</ul></li>
<li style="user-select: auto !important;">배열은 시간순으로 정렬되어 있지 않을 수 있습니다.</li>
</ul></li>
</ul></li>
<li style="user-select: auto !important;">진행중이던 과제가 끝나는 시각과 새로운 과제를 시작해야하는 시각이 같은 경우 진행중이던 과제는 끝난 것으로 판단합니다.</li>
</ul>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">입출력 예</h5>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">plans</th>
<th style="user-select: auto !important;">result</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">[["korean", "11:40", "30"], ["english", "12:10", "20"], ["math", "12:30", "40"]]</td>
<td style="user-select: auto !important;">["korean", "english", "math"]</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">[["science", "12:40", "50"], ["music", "12:20", "40"], ["history", "14:00", "30"], ["computer", "12:30", "100"]]</td>
<td style="user-select: auto !important;">["science", "history", "computer", "music"]</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">[["aaa", "12:00", "20"], ["bbb", "12:10", "30"], ["ccc", "12:40", "10"]]</td>
<td style="user-select: auto !important;">["bbb", "ccc", "aaa"]</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">입출력 예 설명</h5>

<p style="user-select: auto !important;">입출력 예 #1</p>

<p style="user-select: auto !important;">"korean", "english", "math"순으로 과제를 시작합니다. "korean" 과제를 "11:40"에 시작하여 30분 후인 "12:10"에 마치고, 즉시 "english" 과제를 시작합니다. 20분 후인 "12:30"에 "english" 과제를 마치고, 즉시 "math" 과제를 시작합니다. 40분 후인 "01:10"에 "math" 과제를 마칩니다. 따라서 "korean", "english", "math" 순으로 과제를 끝내므로 차례대로 배열에 담아 반환합니다.</p>

<p style="user-select: auto !important;">입출력 예 #2</p>

<p style="user-select: auto !important;">"music", "computer", "science", "history" 순으로 과제를 시작합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">시각</th>
<th style="user-select: auto !important;">진행 중 과제</th>
<th style="user-select: auto !important;">잠시 멈춘 과제</th>
<th style="user-select: auto !important;">설명</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">"12:20"</td>
<td style="user-select: auto !important;">"music"</td>
<td style="user-select: auto !important;">[ ]</td>
<td style="user-select: auto !important;">"music"을 시작합니다.</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">"12:30"</td>
<td style="user-select: auto !important;">"computer"</td>
<td style="user-select: auto !important;">["music"]</td>
<td style="user-select: auto !important;">"music"을 잠시 멈추고(남은 시간 30분) "computer"를 시작합니다</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">"12:40"</td>
<td style="user-select: auto !important;">"science"</td>
<td style="user-select: auto !important;">["music", "computer"]</td>
<td style="user-select: auto !important;">"computer"를 잠시 멈추고(남은 시간 90분) "science"를 시작합니다</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">"13:30"</td>
<td style="user-select: auto !important;">"computer"</td>
<td style="user-select: auto !important;">["music"]</td>
<td style="user-select: auto !important;">"science"를 끝내고 가장 최근에 멈춘 "computer"를 다시 시작합니다</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">"14:00"</td>
<td style="user-select: auto !important;">"history"</td>
<td style="user-select: auto !important;">["music", "computer"]</td>
<td style="user-select: auto !important;">"computer"를 잠시 멈추고(남은 시간 60분) "history"를 시작합니다</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">"14:30"</td>
<td style="user-select: auto !important;">"computer"</td>
<td style="user-select: auto !important;">["music"]</td>
<td style="user-select: auto !important;">"history"를 끝내고 가장 최근에 멈춘 "computer"를 다시 시작합니다"</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">"15:30"</td>
<td style="user-select: auto !important;">"music"</td>
<td style="user-select: auto !important;">[ ]</td>
<td style="user-select: auto !important;">"computer"를 끝내고 가장 최근에 멈춘 "music"을 다시 시작합니다"</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">"16:00"</td>
<td style="user-select: auto !important;">-</td>
<td style="user-select: auto !important;">[ ]</td>
<td style="user-select: auto !important;">"music"을 끝냅니다</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">따라서 ["science", "history", "computer", "music"] 순서로 과제를 마칩니다.</p>

<p style="user-select: auto !important;">입출력 예 #3</p>

<p style="user-select: auto !important;">설명 생략</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges