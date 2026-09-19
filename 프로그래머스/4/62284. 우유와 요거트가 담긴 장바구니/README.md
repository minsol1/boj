# [level 4] 우유와 요거트가 담긴 장바구니 - 62284 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/62284) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > Summer／Winter Coding（2019）

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2026년 09월 19일 18:38:53

### 문제 설명

<p style="user-select: auto !important;"><code style="user-select: auto !important;">CART_PRODUCTS</code> 테이블은 장바구니에 담긴 상품 정보를 담은 테이블입니다. <code style="user-select: auto !important;">CART_PRODUCTS</code> 테이블의 구조는 다음과 같으며, <code style="user-select: auto !important;">ID</code>, <code style="user-select: auto !important;">CART_ID</code>, <code style="user-select: auto !important;">NAME</code>, <code style="user-select: auto !important;">PRICE</code>는 각각 테이블의 아이디, 장바구니의 아이디, 상품 종류, 가격을 나타냅니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">NAME</th>
<th style="user-select: auto !important;">TYPE</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">ID</td>
<td style="user-select: auto !important;">INT</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">CART_ID</td>
<td style="user-select: auto !important;">INT</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">NAME</td>
<td style="user-select: auto !important;">VARCHAR</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">PRICE</td>
<td style="user-select: auto !important;">INT</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">데이터 분석 팀에서는 우유(Milk)와 요거트(Yogurt)를 동시에 구입한 장바구니가 있는지 알아보려 합니다. 우유와 요거트를 동시에 구입한 장바구니의 아이디를 조회하는 SQL 문을 작성해주세요. 이때 결과는 장바구니의 아이디 순으로 나와야 합니다.</p>

<h5 style="user-select: auto !important;">예시</h5>

<p style="user-select: auto !important;">예를 들어 <code style="user-select: auto !important;">CART_PRODUCTS</code> 테이블이 다음과 같다면</p>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">CART_PRODUCTS</code> 테이블</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">ID</th>
<th style="user-select: auto !important;">CART_ID</th>
<th style="user-select: auto !important;">NAME</th>
<th style="user-select: auto !important;">PRICE</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">1630</td>
<td style="user-select: auto !important;">83</td>
<td style="user-select: auto !important;">Cereal</td>
<td style="user-select: auto !important;">3980</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">1631</td>
<td style="user-select: auto !important;">83</td>
<td style="user-select: auto !important;">Multipurpose Supply</td>
<td style="user-select: auto !important;">3900</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">5491</td>
<td style="user-select: auto !important;">286</td>
<td style="user-select: auto !important;">Yogurt</td>
<td style="user-select: auto !important;">2980</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">5504</td>
<td style="user-select: auto !important;">286</td>
<td style="user-select: auto !important;">Milk</td>
<td style="user-select: auto !important;">1880</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">8435</td>
<td style="user-select: auto !important;">448</td>
<td style="user-select: auto !important;">Milk</td>
<td style="user-select: auto !important;">1880</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">8437</td>
<td style="user-select: auto !important;">448</td>
<td style="user-select: auto !important;">Yogurt</td>
<td style="user-select: auto !important;">2980</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">8438</td>
<td style="user-select: auto !important;">448</td>
<td style="user-select: auto !important;">Tea</td>
<td style="user-select: auto !important;">11000</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">20236</td>
<td style="user-select: auto !important;">1034</td>
<td style="user-select: auto !important;">Yogurt</td>
<td style="user-select: auto !important;">2980</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">20237</td>
<td style="user-select: auto !important;">1034</td>
<td style="user-select: auto !important;">Butter</td>
<td style="user-select: auto !important;">4890</td>
</tr>
</tbody>
      </table>
<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">83번 장바구니에는 Milk와 Yogurt가 모두 없습니다.</li>
<li style="user-select: auto !important;">286번 장바구니에는 Milk와 Yogurt가 모두 있습니다.</li>
<li style="user-select: auto !important;">448번 장바구니에는 Milk와 Yogurt가 모두 있습니다.</li>
<li style="user-select: auto !important;">1034번 장바구니에는 Milk는 없고 Yogurt만 있습니다.</li>
</ul>

<p style="user-select: auto !important;">따라서 SQL 문을 실행하면 다음과 같이 나와야 합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">CART_ID</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">286</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">448</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges