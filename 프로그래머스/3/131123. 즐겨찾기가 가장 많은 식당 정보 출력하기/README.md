# [level 3] 즐겨찾기가 가장 많은 식당 정보 출력하기 - 131123 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131123) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > GROUP BY

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2026년 09월 16일 20:00:36

### 문제 설명

<p style="user-select: auto !important;">다음은 식당의 정보를 담은 <code style="user-select: auto !important;">REST_INFO</code> 테이블입니다. <code style="user-select: auto !important;">REST_INFO</code> 테이블은 다음과 같으며 <code style="user-select: auto !important;">REST_ID</code>, <code style="user-select: auto !important;">REST_NAME</code>, <code style="user-select: auto !important;">FOOD_TYPE</code>, <code style="user-select: auto !important;">VIEWS</code>, <code style="user-select: auto !important;">FAVORITES</code>, <code style="user-select: auto !important;">PARKING_LOT</code>, <code style="user-select: auto !important;">ADDRESS</code>, <code style="user-select: auto !important;">TEL</code>은 식당 ID, 식당 이름, 음식 종류, 조회수, 즐겨찾기수, 주차장 유무, 주소, 전화번호를 의미합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">Column name</th>
<th style="user-select: auto !important;">Type</th>
<th style="user-select: auto !important;">Nullable</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">REST_ID</td>
<td style="user-select: auto !important;">VARCHAR(5)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">REST_NAME</td>
<td style="user-select: auto !important;">VARCHAR(50)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">FOOD_TYPE</td>
<td style="user-select: auto !important;">VARCHAR(20)</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">VIEWS</td>
<td style="user-select: auto !important;">NUMBER</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">FAVORITES</td>
<td style="user-select: auto !important;">NUMBER</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">PARKING_LOT</td>
<td style="user-select: auto !important;">VARCHAR(1)</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">ADDRESS</td>
<td style="user-select: auto !important;">VARCHAR(100)</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">TEL</td>
<td style="user-select: auto !important;">VARCHAR(100)</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">문제</h5>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">REST_INFO</code> 테이블에서 음식종류별로 즐겨찾기수가 가장 많은 식당의 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회하는 SQL문을 작성해주세요. 이때 결과는 음식 종류를 기준으로 내림차순 정렬해주세요.</p>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">예시</h5>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">REST_INFO</code> 테이블이 다음과 같을 때</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">REST_ID</th>
<th style="user-select: auto !important;">REST_NAME</th>
<th style="user-select: auto !important;">FOOD_TYPE</th>
<th style="user-select: auto !important;">VIEWS</th>
<th style="user-select: auto !important;">FAVORITES</th>
<th style="user-select: auto !important;">PARKING_LOT</th>
<th style="user-select: auto !important;">ADDRESS</th>
<th style="user-select: auto !important;">TEL</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">00001</td>
<td style="user-select: auto !important;">은돼지식당</td>
<td style="user-select: auto !important;">한식</td>
<td style="user-select: auto !important;">1150345</td>
<td style="user-select: auto !important;">734</td>
<td style="user-select: auto !important;">N</td>
<td style="user-select: auto !important;">서울특별시 중구 다산로 149</td>
<td style="user-select: auto !important;">010-4484-8751</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">00002</td>
<td style="user-select: auto !important;">하이가쯔네</td>
<td style="user-select: auto !important;">일식</td>
<td style="user-select: auto !important;">120034</td>
<td style="user-select: auto !important;">112</td>
<td style="user-select: auto !important;">N</td>
<td style="user-select: auto !important;">서울시 중구 신당동 375-21</td>
<td style="user-select: auto !important;">NULL</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">00003</td>
<td style="user-select: auto !important;">따띠따띠뜨</td>
<td style="user-select: auto !important;">양식</td>
<td style="user-select: auto !important;">1234023</td>
<td style="user-select: auto !important;">102</td>
<td style="user-select: auto !important;">N</td>
<td style="user-select: auto !important;">서울시 강남구 신사동 627-3 1F</td>
<td style="user-select: auto !important;">02-6397-1023</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">00004</td>
<td style="user-select: auto !important;">스시사카우스</td>
<td style="user-select: auto !important;">일식</td>
<td style="user-select: auto !important;">1522074</td>
<td style="user-select: auto !important;">230</td>
<td style="user-select: auto !important;">N</td>
<td style="user-select: auto !important;">서울시 서울시 강남구 신사동 627-27</td>
<td style="user-select: auto !important;">010-9394-2554</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">00005</td>
<td style="user-select: auto !important;">코슌스</td>
<td style="user-select: auto !important;">일식</td>
<td style="user-select: auto !important;">15301</td>
<td style="user-select: auto !important;">123</td>
<td style="user-select: auto !important;">N</td>
<td style="user-select: auto !important;">서울특별시 강남구 언주로153길</td>
<td style="user-select: auto !important;">010-1315-8729</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">SQL을 실행하면 다음과 같이 출력되어야 합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">FOOD_TYPE</th>
<th style="user-select: auto !important;">REST_ID</th>
<th style="user-select: auto !important;">REST_NAME</th>
<th style="user-select: auto !important;">FAVORITES</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">한식</td>
<td style="user-select: auto !important;">00001</td>
<td style="user-select: auto !important;">은돼지식당</td>
<td style="user-select: auto !important;">734</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">일식</td>
<td style="user-select: auto !important;">00004</td>
<td style="user-select: auto !important;">스시사카우스</td>
<td style="user-select: auto !important;">230</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">양식</td>
<td style="user-select: auto !important;">00003</td>
<td style="user-select: auto !important;">따띠따띠뜨</td>
<td style="user-select: auto !important;">102</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges