# Assignment_API


## 개발 환경 구성
- JDK 1.8
- Spring 2.1.3
- h2 database

## 빌드 및 실행방법 
- 소스코드 다운로드
- STS실행 -> File > Import > Maven > Existing Maven Project > 다운로드한 소스코드 폴더 선택 > Finish
- Maven dependency 다운로드 후 
- Run as Spring Boot 로 빌드 후 실행 


## 문제해결방법
1. 데이터 파일에서 각 레코드를 데이터베이스에 저장하는 API 개발
  - csv 파일 파싱을 위해 openCSV 라이브러리 사용
  - 각 row 값을 읽어 새로운 지자체 명이 나왔을 시에 지자체 (Region) 테이블에 레코드 추가. 지자체 코드 (RegionCode) 값은 자동 생성되도록 개발 
  - 각 row 값을 읽어 지원정보 (Program) 테이블에 데이터 추가함 
  - 성공 시 입력 완료된 Program 목록 출력 (json)
2. 지원하는 지자체 목록 검색 API 개발
  - Program 테이블에 저장되어있는 모든 지자체 목록 출력 (findAll)
  - 요구사항 출력 정보에 없는 수정된날짜, 생성된 날짜 는 테이블에 있지만 출력하지 않음 
3. 지원하는 지자체명을 입력 받아 해당 지자체의 지원정보를 출력하는 API 개발
  - region 이름을 받아와 Program 에 저장된 regionCode로 검색 
  - 해당 지자체의 지원정보 출력
  

4. (미완료)지원하는지자체정보수정기능API개발
5. (미완료)지원한도 컬럼에서 지원금액으로 내림차순 정렬(지원금액이 동일하면 이차보전 평균 비율이 적은 순서)하여 특정 개수만 출력하는 API 개발
  - 각 row 값을 CSV 에서 입력 할 때 지원한도 컬럼 값이 string 이므로 저장 당시 미리 지원금액을 파싱하여 숫자로 저장 
  - 지원값이 추천금액 내 일경우 0으로 입력 
  - 내림차순 정렬 시 저장해둔 숫자로 쿼리를 돌려 특정 개수 출력 
6. (미완료)이차보전 컬럼에서 보전 비율이 가장 작은 추천 기관명을 출력하는 API 개발
  - 각 row 값을 CSV 에서 입력 당시 이차보전 컬럼값의 보전비율 의 평균값을 숫자로 미리 입력
  - 미리 입력해둔 값으로 API 개발 시 호출 

## API명세서
### 1. 입력
<pre><code>POST /loadCSV </pre></code>

출력 - 입력 성공한 모든 지자체 정보 출력 
<pre><code>
[  
  {
      "region": "강릉시",
      "target": "강릉시 소재 중소기업으로서 강릉시장이 추천한 자",
      "usage": "운전",
      "limit": "추천금액 이내",
      "rate": "3.00%",
      "institute": "강릉시",
      "mgmt": "강릉지점",
      "reception": "강릉시 소재 영업점"
   },
   {

      "region": "횡성군",
      "target": "횡성군 소재 중소기업으로서 횡성군수의 융자 추천을 받은 자",
      "usage": "운전",
      "limit": "1 억원 이내",
      "rate": "4.00%",
      "institute": "횡성군",
      "mgmt": "원주지점",
      "reception": "횡성군이 지정한 영업점"
   }
]
</pre></code>

### 2. 모든 지원 정보 조회
<pre><code>GET /all </pre></code>

<pre><code>
[  
  {
      "region": "강릉시",
      "target": "강릉시 소재 중소기업으로서 강릉시장이 추천한 자",
      "usage": "운전",
      "limit": "추천금액 이내",
      "rate": "3.00%",
      "institute": "강릉시",
      "mgmt": "강릉지점",
      "reception": "강릉시 소재 영업점"
   },
   {

      "region": "횡성군",
      "target": "횡성군 소재 중소기업으로서 횡성군수의 융자 추천을 받은 자",
      "usage": "운전",
      "limit": "1 억원 이내",
      "rate": "4.00%",
      "institute": "횡성군",
      "mgmt": "원주지점",
      "reception": "횡성군이 지정한 영업점"
   }
]
</pre></code>

### 3. 지원지자체 이름으로 지원내역 검색
<pre><code>POST /program </pre></code>

- Request 
<pre><code>
{
   "region": "강릉시"
}
</pre></code>

- Response
<pre><code>
[  
  {
      "region": "강릉시",
      "target": "강릉시 소재 중소기업으로서 강릉시장이 추천한 자",
      "usage": "운전",
      "limit": "추천금액 이내",
      "rate": "3.00%",
      "institute": "강릉시",
      "mgmt": "강릉지점",
      "reception": "강릉시 소재 영업점"
   }
  ]
</code></pre>

### 4. 지자체지원정보 수정 - 미완성
<pre><code>PUT /program/{id} </pre></code>

- Request 
<pre><code>{
   ""rate"": ""5.0""
}</pre></code>

- Response 
<pre><code>SUCCESS { "code" : 200, "message" : "Success" }</pre></code>
<pre><code>FAIL { "code" : 500, "message" : "Fail" }</pre></code>

### 5. 최대지원한도 내림차순 검색 - 미완성
<pre><code>POST /highlimit </pre></code>

- Request 
<pre><code>{
   ""number"": ""3""
}</pre></code>

- 데이터베이스 입력 시 highlimit 컬럼을 추가하여 text 에서 최대지원한도를 숫자로 저장 
- 쿼리로 n 개의 지원 정보를 highlimit 컬럼의 내림차순으로 정렬하여 보여주기 

### 6. 이차보전 최소 보전비율 검색 - 미완성
<pre><code> GET/lowrate </pre></code>

- 데이터베이스 입력 시 lowrate 컬럼을 추가하여 text 에서 최대지원한도를 숫자로 저장 

