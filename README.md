## 환율 계산기  
## 2022_04_21 ~ 2022_04_22  
## 소개  
와이어바일리 회사 사전과제로 환율 계산기를 만들었습니다.  
미국 -> 한국, 일본, 필리핀 세 나라만 가능합니다.  
환율 정보를 이용하여 currencylayer의 api를 이용하였으며 Retrofit을 이용하였습니다.  
## 앱 사진  
![앱 초기화면](https://user-images.githubusercontent.com/57277631/164611548-6364a688-b5a7-47bf-a87a-263f7b721a4c.PNG)  
올바른 금액을 입력했을때  
![나라 선택](https://user-images.githubusercontent.com/57277631/164611551-2092d02a-4e66-4136-87ac-be47b660a031.PNG)  
나라 선택 화면  
![송금액이 올바르지않습니다](https://user-images.githubusercontent.com/57277631/164611544-28d6173f-d0de-4fa9-bfac-44d2da9b8cf4.PNG)  
송금액이 올바르지 않을때  
  
## 사용된 라이브러리  
* Retrofit + Gson  
  네트워킹을 통해 정보를 받기위해 Retrofit을 사용하였고  
  전송받은 데이터를 Kotlin data class로 쉽게 변환하기위해 Gson컨버터를 사용했습니다.
* Koin  
  의존성 주입을 위해 Koin을 사용하였습니다. 
* DataBinding  
  xml과 Data를 쉽게 연결해주며 불필요한 코드를 줄이기 위해 사용하였습니다.
## 문제와 해결방법  
  1. Json Data class too many arguments  
     https://github.com/hegunhee/WirebarleyTest/issues/2  
  2. 서버에 요청이 잦은 경우  
     https://github.com/hegunhee/WirebarleyTest/issues/3  
       
## 느낀점  
이번 과제를 하면서 Api_key도 properties에 숨기고 Retrofit, RestApi를 다시 공부하는 데 좋은 기회가 되었습니다.  
그리고 달러 입력을 추적하기위해 onTextChanged도 사용해 보았습니다.
