# [level 4] 보호소에서 중성화한 동물 - 59045 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/59045) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > JOIN

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2026년 10월 03일 11:12:30

### 문제 설명

<p style="user-select: auto !important;"><code style="user-select: auto !important;">ANIMAL_INS</code> 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. <code style="user-select: auto !important;">ANIMAL_INS</code> 테이블 구조는 다음과 같으며, <code style="user-select: auto !important;">ANIMAL_ID</code>, <code style="user-select: auto !important;">ANIMAL_TYPE</code>, <code style="user-select: auto !important;">DATETIME</code>, <code style="user-select: auto !important;">INTAKE_CONDITION</code>, <code style="user-select: auto !important;">NAME</code>, <code style="user-select: auto !important;">SEX_UPON_INTAKE</code>는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">NAME</th>
<th style="user-select: auto !important;">TYPE</th>
<th style="user-select: auto !important;">NULLABLE</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">ANIMAL_ID</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">ANIMAL_TYPE</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">DATETIME</td>
<td style="user-select: auto !important;">DATETIME</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">INTAKE_CONDITION</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">NAME</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">SEX_UPON_INTAKE</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">ANIMAL_OUTS</code> 테이블은 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블입니다. <code style="user-select: auto !important;">ANIMAL_OUTS</code> 테이블 구조는 다음과 같으며, <code style="user-select: auto !important;">ANIMAL_ID</code>, <code style="user-select: auto !important;">ANIMAL_TYPE</code>, <code style="user-select: auto !important;">DATETIME</code>, <code style="user-select: auto !important;">NAME</code>, <code style="user-select: auto !important;">SEX_UPON_OUTCOME</code>는 각각 동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부를 나타냅니다. <code style="user-select: auto !important;">ANIMAL_OUTS</code> 테이블의 <code style="user-select: auto !important;">ANIMAL_ID</code>는 <code style="user-select: auto !important;">ANIMAL_INS</code>의 <code style="user-select: auto !important;">ANIMAL_ID</code>의 외래 키입니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">NAME</th>
<th style="user-select: auto !important;">TYPE</th>
<th style="user-select: auto !important;">NULLABLE</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">ANIMAL_ID</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">ANIMAL_TYPE</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">DATETIME</td>
<td style="user-select: auto !important;">DATETIME</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">NAME</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">SEX_UPON_OUTCOME</td>
<td style="user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">보호소에서 중성화 수술을 거친 동물 정보를 알아보려 합니다. 보호소에 들어올 당시에는 중성화<sup id="fnref1" style="user-select: auto !important;"><a href="#fn1" style="user-select: auto !important;">1</a></sup>되지 않았지만, 보호소를 나갈 당시에는 중성화된 동물의 아이디와 생물 종, 이름을 조회하는 아이디 순으로 조회하는 SQL 문을 작성해주세요.</p>

<h5 style="user-select: auto !important;">예시</h5>

<p style="user-select: auto !important;">예를 들어, <code style="user-select: auto !important;">ANIMAL_INS</code> 테이블과 <code style="user-select: auto !important;">ANIMAL_OUTS</code> 테이블이 다음과 같다면</p>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">ANIMAL_INS</code></p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">ANIMAL_ID</th>
<th style="user-select: auto !important;">ANIMAL_TYPE</th>
<th style="user-select: auto !important;">DATETIME</th>
<th style="user-select: auto !important;">INTAKE_CONDITION</th>
<th style="user-select: auto !important;">NAME</th>
<th style="user-select: auto !important;">SEX_UPON_INTAKE</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">A367438</td>
<td style="user-select: auto !important;">Dog</td>
<td style="user-select: auto !important;">2015-09-10 16:01:00</td>
<td style="user-select: auto !important;">Normal</td>
<td style="user-select: auto !important;">Cookie</td>
<td style="user-select: auto !important;">Spayed Female</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">A382192</td>
<td style="user-select: auto !important;">Dog</td>
<td style="user-select: auto !important;">2015-03-13 13:14:00</td>
<td style="user-select: auto !important;">Normal</td>
<td style="user-select: auto !important;">Maxwell 2</td>
<td style="user-select: auto !important;">Intact Male</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">A405494</td>
<td style="user-select: auto !important;">Dog</td>
<td style="user-select: auto !important;">2014-05-16 14:17:00</td>
<td style="user-select: auto !important;">Normal</td>
<td style="user-select: auto !important;">Kaila</td>
<td style="user-select: auto !important;">Spayed Female</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">A410330</td>
<td style="user-select: auto !important;">Dog</td>
<td style="user-select: auto !important;">2016-09-11 14:09:00</td>
<td style="user-select: auto !important;">Sick</td>
<td style="user-select: auto !important;">Chewy</td>
<td style="user-select: auto !important;">Intact Female</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">ANIMAL_OUTS</code></p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">ANIMAL_ID</th>
<th style="user-select: auto !important;">ANIMAL_TYPE</th>
<th style="user-select: auto !important;">DATETIME</th>
<th style="user-select: auto !important;">NAME</th>
<th style="user-select: auto !important;">SEX_UPON_OUTCOME</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">A367438</td>
<td style="user-select: auto !important;">Dog</td>
<td style="user-select: auto !important;">2015-09-12 13:30:00</td>
<td style="user-select: auto !important;">Cookie</td>
<td style="user-select: auto !important;">Spayed Female</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">A382192</td>
<td style="user-select: auto !important;">Dog</td>
<td style="user-select: auto !important;">2015-03-16 13:46:00</td>
<td style="user-select: auto !important;">Maxwell 2</td>
<td style="user-select: auto !important;">Neutered Male</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">A405494</td>
<td style="user-select: auto !important;">Dog</td>
<td style="user-select: auto !important;">2014-05-20 11:44:00</td>
<td style="user-select: auto !important;">Kaila</td>
<td style="user-select: auto !important;">Spayed Female</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">A410330</td>
<td style="user-select: auto !important;">Dog</td>
<td style="user-select: auto !important;">2016-09-13 13:46:00</td>
<td style="user-select: auto !important;">Chewy</td>
<td style="user-select: auto !important;">Spayed Female</td>
</tr>
</tbody>
      </table>
<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">Cookie는 보호소에 들어올 당시에 이미 중성화되어있었습니다.</li>
<li style="user-select: auto !important;">Maxwell 2는 보호소에 들어온 후 중성화되었습니다.</li>
<li style="user-select: auto !important;">Kaila는 보호소에 들어올 당시에 이미 중성화되어있었습니다.</li>
<li style="user-select: auto !important;">Chewy는 보호소에 들어온 후 중성화되었습니다.</li>
</ul>

<p style="user-select: auto !important;">따라서 SQL문을 실행하면 다음과 같이 나와야 합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">ANIMAL_ID</th>
<th style="user-select: auto !important;">ANIMAL_TYPE</th>
<th style="user-select: auto !important;">NAME</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">A382192</td>
<td style="user-select: auto !important;">Dog</td>
<td style="user-select: auto !important;">Maxwell 2</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">A410330</td>
<td style="user-select: auto !important;">Dog</td>
<td style="user-select: auto !important;">Chewy</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto !important;">

<p style="user-select: auto !important;">본 문제는 <a href="https://www.kaggle.com/aaronschlegel/austin-animal-center-shelter-intakes-and-outcomes" target="_blank" rel="noopener" style="user-select: auto !important;">Kaggle의 "Austin Animal Center Shelter Intakes and Outcomes"</a>에서 제공하는 데이터를 사용하였으며 <a href="https://opendatacommons.org/licenses/odbl/1.0/" target="_blank" rel="noopener" style="user-select: auto !important;">ODbL</a>의 적용을 받습니다.</p>

<div class="footnotes" style="user-select: auto !important;">
<hr style="user-select: auto !important;">
<ol style="user-select: auto !important;">

<li id="fn1" style="user-select: auto !important;">
<p style="user-select: auto !important;">중성화를 거치지 않은 동물은 <code style="user-select: auto !important;">성별 및 중성화 여부</code>에 Intact, 중성화를 거친 동물은 <code style="user-select: auto !important;">Spayed</code> 또는 <code style="user-select: auto !important;">Neutered</code>라고 표시되어있습니다.&nbsp;<a href="#fnref1" style="user-select: auto !important;">↩</a></p>
</li>

</ol>
</div>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges