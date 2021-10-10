# airapi
**2021-October ~ September**

**Spring**

## 스토리 보드
서울시/부산시 미세먼지 정보(대기질 정보) Open API를 하나의 API로 연동

## REST API
* airapi_RESTAPI에 첨부
* 요청과 응답을 snake case 로 통일

![image](https://user-images.githubusercontent.com/76150392/136699513-92a54dfc-d080-4d98-b2ec-6efce98110d5.png)

## PostMan 응답결과
* 서울시 전체

![image](https://user-images.githubusercontent.com/76150392/136699599-1aded25d-8b92-4681-ab01-a505e53f8196.png)

* 서울시 강동구

![image](https://user-images.githubusercontent.com/76150392/136699626-b8a31873-c3fb-4514-973b-b917b6d09dbf.png)

* 부산시 전체

![image](https://user-images.githubusercontent.com/76150392/136699644-1b812c65-a56d-41e2-b1da-76a4aa47ed6f.png)

* 부산시 온천동

![image](https://user-images.githubusercontent.com/76150392/136699674-9c59cb48-3d36-4fe2-a4fd-f3c4c02903c8.png)

## 신경 썼던 부분
* AirQualityApi interface 는 인터페이스만 보고서는 어떤 기능이 있는지 알기가 어려웠었다. 인터페이스만 보고서도 어떤 기능들이 구현되는지 명확하게 알 수 있게 AirQualityApi를 수정하였다.
```
public interface SeoulAirQualityApi {
    String serviceKey = "-------------";
    @GET( serviceKey + "/json/DailyAverageCityAir/1/25/{date}?START_INDEX=1&END_INDEX=25")
    Call<SeoulAirQualityApiDto.GetAirQualityResponse> getAirQuality(@Path("date") String date);
}
```

* AirQualityGradeUtil 와 같은 Util Class 는 모두 static method로 변경하고 생성자는 private 으로 instance화 하지 않아야한다. (https://dololak.tistory.com/715)
```
public class AirQualityGradeUtil {
    private AirQualityGradeUtil() {
    }
    ...
}
```

## 개선해야 할 부분

* public method 는 처음 보는 사람도 흐름을 읽기 쉽게 만들어야 한다. 되도록 로직은 public method에 두지 않도록 하고 "최소한의 의미있는 동작"들을 별도 메소드(private)로 나눠야 한다.
* Dto 를 만들고 값을 넣을 때 기본 생성자와 setter를 사용하였는데 이는 지양해야할 안티패턴 이다. spring 서버는 항상 multi-thread 환경에서 동작하기 때문에 thread-safe 를 중요하게 생각해야 하는데 setter는 thread-safe 하지 않기 때문이다. Builder 사용법을 익혀서 이 문제를 해결해야 한다.


## What I've learned
* REST_API 작성법
* Postman 사용법
* retrofit2 - 현업에서 최근 가장 많이 사용되는 서드파티 API 연동 라이브러리
* API 통합
