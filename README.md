# Assignment_API


## 기본제약사항

지원지자체 테이블 생성
지자체 지원정보 Entity 생성 

## API명세서
### 1. 입력
csv 파일의 데이터를 읽어 데이터베이스에 저장 

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
