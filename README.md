# Assignment_API


## 개발 환경 구성
- Spring 
- MySQL
- JPA

## 빌드 및 실행방법 

## 문제분석
csv 파일로 된 데이터에서 각 레코드를 데이터베이스에 저장하는 API개발
검색, 조회, 수정 등 API기능명세에 있는 기능 구현
각 기능별 Unit Test 개발

제약사항
- 지원지자체 테이블 생성하여 지자체 코드 생성
- 지자체 지원정보 Entity 생성 (JPA 사용) 
- ORM 사용
- 모든 입/출력은 JSON 으로 .. 

## 문제해결방법

## API명세서
### 1. 입력
csv 파일의 데이터를 읽어 데이터베이스에 저장 --> 명확한 요구사항 다시 한번 물어볼것..
POST /add 한 후 text 로 입력..? 


### 2. 모든 지원 정보 조회
<pre><code>GET /all</pre></code>

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
<pre><code>POST /region </pre></code>

- Request 
<pre><code>
{
   ""region"": ""강릉시""
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

### 4. 지자체 정보 수정
<pre><code>PUT /region/{id} </pre></code>

- Request 
<pre><code>{
   ""rate"": ""5.0""
}</pre></code>

- Response 
<pre><code>SUCCESS { "code" : 200, "message" : "Success" }</pre></code>
<pre><code>FAIL { "code" : 500, "message" : "Fail" }</pre></code>

### 5. 최대지원한도 내림차순 검색 
<pre><code>POST /highlimit </pre></code>

- Request 
<pre><code>{
   ""number"": ""3""
}</pre></code>

- 데이터베이스 입력 시 highlimit 컬럼을 추가하여 text 에서 최대지원한도를 숫자로 저장 
- 쿼리로 n 개의 지원 정보를 highlimit 컬럼의 내림차순으로 정렬하여 보여주기 

### 6. 이차보전 최소 보전비율 검색
<pre><code> GET/lowrate </pre></code>

- 데이터베이스 입력 시 lowrate 컬럼을 추가하여 text 에서 최대지원한도를 숫자로 저장 

