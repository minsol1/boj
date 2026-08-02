# [level 2] 택배 배달과 수거하기 - 150369 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/150369) 

### 성능 요약

메모리: 91.7 MB, 시간: 45.23 ms

### 구분

코딩테스트 연습 > 2023 KAKAO BLIND RECRUITMENT

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2026년 08월 02일 14:00:51

### 문제 설명

<p style="user-select: auto !important;"><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/7ce63a07-3abd-40a1-87cc-c1f664393aa0/%E1%84%8C%E1%85%A2%E1%84%92%E1%85%A1%E1%86%AF%E1%84%8B%E1%85%AD%E1%86%BC%20%E1%84%90%E1%85%A2%E1%86%A8%E1%84%87%E1%85%A2%20%E1%84%89%E1%85%A1%E1%86%BC%E1%84%8C%E1%85%A1.png" title="" alt="재할용 택배 상자.png" style="user-select: auto !important;"></p>

<p style="user-select: auto !important;">당신은 일렬로 나열된 <code style="user-select: auto !important;">n</code>개의 집에 택배를 배달하려 합니다. 배달할 물건은 모두 크기가 같은 재활용 택배 상자에 담아 배달하며, 배달을 다니면서 빈 재활용 택배 상자들을 수거하려 합니다. <br style="user-select: auto !important;">
배달할 택배들은 모두 재활용 택배 상자에 담겨서 물류창고에 보관되어 있고, <code style="user-select: auto !important;">i</code>번째 집은 물류창고에서 거리 <code style="user-select: auto !important;">i</code>만큼 떨어져 있습니다. 또한 <code style="user-select: auto !important;">i</code>번째 집은 <code style="user-select: auto !important;">j</code>번째 집과 거리 <code style="user-select: auto !important;">j - i</code>만큼 떨어져 있습니다. (1 ≤ <code style="user-select: auto !important;">i</code> ≤ <code style="user-select: auto !important;">j</code> ≤ <code style="user-select: auto !important;">n</code>) <br style="user-select: auto !important;">
트럭에는 재활용 택배 상자를 최대 <code style="user-select: auto !important;">cap</code>개 실을 수 있습니다. 트럭은 배달할 재활용 택배 상자들을 실어 물류창고에서 출발해 각 집에 배달하면서, 빈 재활용 택배 상자들을 수거해 물류창고에 내립니다. 각 집마다 배달할 재활용 택배 상자의 개수와 수거할 빈 재활용 택배 상자의 개수를 알고 있을 때, 트럭 하나로 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리를 구하려 합니다. <strong style="user-select: auto !important;">각 집에 배달 및 수거할 때, 원하는 개수만큼 택배를 배달 및 수거할 수 있습니다.</strong></p>

<p style="user-select: auto !important;">다음은 <code style="user-select: auto !important;">cap</code>=4 일 때, 최소 거리로 이동하면서 5개의 집에 배달 및 수거하는 과정을 나타낸 예시입니다. </p>

<p style="user-select: auto !important;"><strong style="user-select: auto !important;">배달 및 수거할 재활용 택배 상자 개수</strong> </p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;"></th>
<th style="user-select: auto !important;">집 #1</th>
<th style="user-select: auto !important;">집 #2</th>
<th style="user-select: auto !important;">집 #3</th>
<th style="user-select: auto !important;">집 #4</th>
<th style="user-select: auto !important;">집 #5</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">배달</td>
<td style="user-select: auto !important;">1개</td>
<td style="user-select: auto !important;">0개</td>
<td style="user-select: auto !important;">3개</td>
<td style="user-select: auto !important;">1개</td>
<td style="user-select: auto !important;">2개</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">수거</td>
<td style="user-select: auto !important;">0개</td>
<td style="user-select: auto !important;">3개</td>
<td style="user-select: auto !important;">0개</td>
<td style="user-select: auto !important;">4개</td>
<td style="user-select: auto !important;">0개</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><strong style="user-select: auto !important;">배달 및 수거 과정</strong></p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;"></th>
<th style="user-select: auto !important;">집 #1</th>
<th style="user-select: auto !important;">집 #2</th>
<th style="user-select: auto !important;">집 #3</th>
<th style="user-select: auto !important;">집 #4</th>
<th style="user-select: auto !important;">집 #5</th>
<th style="user-select: auto !important;">설명</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">남은 배달/수거</td>
<td style="user-select: auto !important;">1/0</td>
<td style="user-select: auto !important;">0/3</td>
<td style="user-select: auto !important;">3/0</td>
<td style="user-select: auto !important;">1/4</td>
<td style="user-select: auto !important;">2/0</td>
<td style="user-select: auto !important;">물류창고에서 택배 3개를 트럭에 실어 출발합니다.</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">남은 배달/수거</td>
<td style="user-select: auto !important;">1/0</td>
<td style="user-select: auto !important;">0/3</td>
<td style="user-select: auto !important;">3/0</td>
<td style="user-select: auto !important;"><strong style="user-select: auto !important;">0</strong>/4</td>
<td style="user-select: auto !important;"><strong style="user-select: auto !important;">0</strong>/0</td>
<td style="user-select: auto !important;">물류창고에서 5번째 집까지 이동하면서(거리 5) 4번째 집에 택배 1개를 배달하고, 5번째 집에 택배 2개를 배달합니다.</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">남은 배달/수거</td>
<td style="user-select: auto !important;">1/0</td>
<td style="user-select: auto !important;">0/3</td>
<td style="user-select: auto !important;">3/0</td>
<td style="user-select: auto !important;">0/<strong style="user-select: auto !important;">0</strong></td>
<td style="user-select: auto !important;">0/0</td>
<td style="user-select: auto !important;">5번째 집에서 물류창고까지 이동하면서(거리 5) 4번째 집에서 빈 택배 상자 4개를 수거한 후, 수거한 빈 택배 상자를 물류창고에 내리고 택배 4개를 트럭에 싣습니다.</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">남은 배달/수거</td>
<td style="user-select: auto !important;"><strong style="user-select: auto !important;">0</strong>/0</td>
<td style="user-select: auto !important;">0/3</td>
<td style="user-select: auto !important;"><strong style="user-select: auto !important;">0</strong>/0</td>
<td style="user-select: auto !important;">0/0</td>
<td style="user-select: auto !important;">0/0</td>
<td style="user-select: auto !important;">물류창고에서 3번째 집까지 이동하면서(거리 3) 1번째 집에 택배 1개를 배달하고, 3번째 집에 택배 3개를 배달합니다.</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">남은 배달/수거</td>
<td style="user-select: auto !important;">0/0</td>
<td style="user-select: auto !important;">0/<strong style="user-select: auto !important;">0</strong></td>
<td style="user-select: auto !important;">0/0</td>
<td style="user-select: auto !important;">0/0</td>
<td style="user-select: auto !important;">0/0</td>
<td style="user-select: auto !important;">3번째 집에서 물류창고까지 이동하면서(거리 3) 2번째 집에서 빈 택배 상자 3개를 수거한 후, 수거한 빈 택배 상자를 물류창고에 내립니다.</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">16(=5+5+3+3)의 거리를 이동하면서 모든 배달 및 수거를 마쳤습니다. 같은 거리로 모든 배달 및 수거를 마치는 다른 방법이 있지만, 이보다 짧은 거리로 모든 배달 및 수거를 마치는 방법은 없습니다. </p>

<p style="user-select: auto !important;">트럭에 실을 수 있는 재활용 택배 상자의 최대 개수를 나타내는 정수 <code style="user-select: auto !important;">cap</code>, 배달할 집의 개수를 나타내는 정수 <code style="user-select: auto !important;">n</code>, 각 집에 배달할 재활용 택배 상자의 개수를 담은 1차원 정수 배열 <code style="user-select: auto !important;">deliveries</code>와 각 집에서 수거할 빈 재활용 택배 상자의 개수를 담은 1차원 정수 배열 <code style="user-select: auto !important;">pickups</code>가 매개변수로 주어집니다. 이때, 트럭 하나로 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리를 return 하도록 solution 함수를 완성해 주세요.</p>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">제한사항</h5>

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">1 ≤ <code style="user-select: auto !important;">cap</code> ≤ 50</li>
<li style="user-select: auto !important;">1 ≤ <code style="user-select: auto !important;">n</code> ≤ 100,000</li>
<li style="user-select: auto !important;"><code style="user-select: auto !important;">deliveries</code>의 길이 = <code style="user-select: auto !important;">pickups</code>의 길이 = <code style="user-select: auto !important;">n</code>

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;"><code style="user-select: auto !important;">deliveries[i]</code>는 i+1번째 집에 배달할 재활용 택배 상자의 개수를 나타냅니다.</li>
<li style="user-select: auto !important;"><code style="user-select: auto !important;">pickups[i]</code>는 i+1번째 집에서 수거할 빈 재활용 택배 상자의 개수를 나타냅니다. </li>
<li style="user-select: auto !important;">0 ≤ <code style="user-select: auto !important;">deliveries</code>의 원소 ≤ 50</li>
<li style="user-select: auto !important;">0 ≤ <code style="user-select: auto !important;">pickups</code>의 원소 ≤ 50</li>
</ul></li>
<li style="user-select: auto !important;">트럭의 초기 위치는 물류창고입니다.</li>
</ul>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">입출력 예</h5>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">cap</th>
<th style="user-select: auto !important;">n</th>
<th style="user-select: auto !important;">deliveries</th>
<th style="user-select: auto !important;">pickups</th>
<th style="user-select: auto !important;">result</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">4</td>
<td style="user-select: auto !important;">5</td>
<td style="user-select: auto !important;">[1, 0, 3, 1, 2]</td>
<td style="user-select: auto !important;">[0, 3, 0, 4, 0]</td>
<td style="user-select: auto !important;">16</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">7</td>
<td style="user-select: auto !important;">[1, 0, 2, 0, 1, 0, 2]</td>
<td style="user-select: auto !important;">[0, 2, 0, 1, 0, 2, 0]</td>
<td style="user-select: auto !important;">30</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">입출력 예 설명</h5>

<p style="user-select: auto !important;"><strong style="user-select: auto !important;">입출력 예 #1</strong></p>

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">문제 예시와 동일합니다.</li>
</ul>

<p style="user-select: auto !important;"><strong style="user-select: auto !important;">입출력 예 #2</strong></p>

<p style="user-select: auto !important;"><strong style="user-select: auto !important;">배달 및 수거할 재활용 택배 상자 개수</strong> </p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;"></th>
<th style="user-select: auto !important;">집 #1</th>
<th style="user-select: auto !important;">집 #2</th>
<th style="user-select: auto !important;">집 #3</th>
<th style="user-select: auto !important;">집 #4</th>
<th style="user-select: auto !important;">집 #5</th>
<th style="user-select: auto !important;">집 #6</th>
<th style="user-select: auto !important;">집 #7</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">배달</td>
<td style="user-select: auto !important;">1개</td>
<td style="user-select: auto !important;">0개</td>
<td style="user-select: auto !important;">2개</td>
<td style="user-select: auto !important;">0개</td>
<td style="user-select: auto !important;">1개</td>
<td style="user-select: auto !important;">0개</td>
<td style="user-select: auto !important;">2개</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">수거</td>
<td style="user-select: auto !important;">0개</td>
<td style="user-select: auto !important;">2개</td>
<td style="user-select: auto !important;">0개</td>
<td style="user-select: auto !important;">1개</td>
<td style="user-select: auto !important;">0개</td>
<td style="user-select: auto !important;">2개</td>
<td style="user-select: auto !important;">0개</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><strong style="user-select: auto !important;">배달 및 수거 과정</strong></p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;"></th>
<th style="user-select: auto !important;">집 #1</th>
<th style="user-select: auto !important;">집 #2</th>
<th style="user-select: auto !important;">집 #3</th>
<th style="user-select: auto !important;">집 #4</th>
<th style="user-select: auto !important;">집 #5</th>
<th style="user-select: auto !important;">집 #6</th>
<th style="user-select: auto !important;">집 #7</th>
<th style="user-select: auto !important;">설명</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">남은 배달/수거</td>
<td style="user-select: auto !important;">1/0</td>
<td style="user-select: auto !important;">0/2</td>
<td style="user-select: auto !important;">2/0</td>
<td style="user-select: auto !important;">0/1</td>
<td style="user-select: auto !important;">1/0</td>
<td style="user-select: auto !important;">0/2</td>
<td style="user-select: auto !important;">2/0</td>
<td style="user-select: auto !important;">물류창고에서 택배 2개를 트럭에 실어 출발합니다.</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">남은 배달/수거</td>
<td style="user-select: auto !important;">1/0</td>
<td style="user-select: auto !important;">0/2</td>
<td style="user-select: auto !important;">2/0</td>
<td style="user-select: auto !important;">0/1</td>
<td style="user-select: auto !important;">1/0</td>
<td style="user-select: auto !important;">0/2</td>
<td style="user-select: auto !important;"><strong style="user-select: auto !important;">0</strong>/0</td>
<td style="user-select: auto !important;">물류창고에서 7번째 집까지 이동하면서(거리 7) 7번째 집에 택배 2개를 배달합니다.</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">남은 배달/수거</td>
<td style="user-select: auto !important;">1/0</td>
<td style="user-select: auto !important;">0/2</td>
<td style="user-select: auto !important;">2/0</td>
<td style="user-select: auto !important;">0/1</td>
<td style="user-select: auto !important;">1/0</td>
<td style="user-select: auto !important;">0/<strong style="user-select: auto !important;">0</strong></td>
<td style="user-select: auto !important;"><strong style="user-select: auto !important;">0</strong>/0</td>
<td style="user-select: auto !important;">7번째 집에서 물류창고까지 이동하면서(거리 7) 6번째 집에서 빈 택배 상자 2개를 수거한 후, 수거한 빈 택배 상자를 물류창고에 내리고 택배 2개를 트럭에 싣습니다.</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">남은 배달/수거</td>
<td style="user-select: auto !important;">1/0</td>
<td style="user-select: auto !important;">0/2</td>
<td style="user-select: auto !important;"><strong style="user-select: auto !important;">1</strong>/0</td>
<td style="user-select: auto !important;">0/1</td>
<td style="user-select: auto !important;"><strong style="user-select: auto !important;">0</strong>/0</td>
<td style="user-select: auto !important;">0/0</td>
<td style="user-select: auto !important;">0/0</td>
<td style="user-select: auto !important;">물류창고에서 5번째 집까지 이동하면서(거리 5) 3번째 집에 택배 1개를 배달하고, 5번째 집에 택배 1개를 배달합니다.</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">남은 배달/수거</td>
<td style="user-select: auto !important;">1/0</td>
<td style="user-select: auto !important;">0/<strong style="user-select: auto !important;">1</strong></td>
<td style="user-select: auto !important;">1/0</td>
<td style="user-select: auto !important;">0/<strong style="user-select: auto !important;">0</strong></td>
<td style="user-select: auto !important;">0/0</td>
<td style="user-select: auto !important;">0/0</td>
<td style="user-select: auto !important;">0/0</td>
<td style="user-select: auto !important;">5번째 집에서 물류창고까지 이동하면서(거리 5) 4번째 집에서 빈 택배 상자 1개를 수거하고 2번째 집에서 빈 택배 상자 1개를 수거한 후, 수거한 빈 택배 상자를 물류창고에 내리고 택배 2개를 트럭에 싣습니다.</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">남은 배달/수거</td>
<td style="user-select: auto !important;"><strong style="user-select: auto !important;">0</strong>/0</td>
<td style="user-select: auto !important;">0/1</td>
<td style="user-select: auto !important;"><strong style="user-select: auto !important;">0</strong>/0</td>
<td style="user-select: auto !important;">0/0</td>
<td style="user-select: auto !important;">0/0</td>
<td style="user-select: auto !important;">0/0</td>
<td style="user-select: auto !important;">0/0</td>
<td style="user-select: auto !important;">물류창고에서 3번째 집까지 이동하면서(거리 3) 1번째 집에 택배 1개를 배달하고, 3번째 집에 택배 1개를 배달합니다.</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">남은 배달/수거</td>
<td style="user-select: auto !important;">0/0</td>
<td style="user-select: auto !important;">0/<strong style="user-select: auto !important;">0</strong></td>
<td style="user-select: auto !important;">0/0</td>
<td style="user-select: auto !important;">0/0</td>
<td style="user-select: auto !important;">0/0</td>
<td style="user-select: auto !important;">0/0</td>
<td style="user-select: auto !important;">0/0</td>
<td style="user-select: auto !important;">3번째 집에서 물류창고까지 이동하면서(거리 3) 2번째 집에서 빈 택배 상자 1개를 수거한 후, 수거한 빈 택배 상자를 물류창고에 내립니다.</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">30(=7+7+5+5+3+3)의 거리를 이동하면서 모든 배달 및 수거를 마쳤습니다. 같은 거리로 모든 배달 및 수거를 마치는 다른 방법이 있지만, 이보다 짧은 거리로 모든 배달 및 수거를 마치는 방법은 없습니다. <br style="user-select: auto !important;">
따라서, 30을 return 하면 됩니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges