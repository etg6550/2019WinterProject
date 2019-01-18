# 전까지 놓쳤던 키워드들 정리
#### ==참고== [경환이꺼](https://github.com/ber01/Study-Spring-Boot/tree/master/keyword)
---
#### Dependency
> - 코드에서 두 모듈간의 연결
> - 두 개의 클래스 간의 관계
#### DI(Dependency Injection)
> - instance의 생성 및 생명 주기를 외부로 맡기는 행위
> - 필요한 경우에 따라 instance를 외부로 부터 주입 받아서 사용
> - instance의 생성 및 관리의 주체가 개발자가 아닌 외부이기 때문에 제어의 역전이 됨

#### REST API
> - REST : 웹에 존재하는 모든 자원에 고유한 URI를 부여해 활용하는 것
> - REST의 특징을 지키는 API
#### JPA
> - 어플리케이션과 JDBC 사이에서 동작하는 ORM의 표준 인터페이스
> - ORM : 데이터베이스와 객체 지향 프로그래밍 언어 간의 호환되지 않는 데이터 변환 기법
> - JDBC : 자바에서 데이터베이스에 접속할 수 있도록 하는 자바 인터페이스
#### Gradle
> - Groovy를 이용한 빌드 자동화 시스템
#### @RestController
> - REST 방식의 데이터 자체를 서비스로 제공
JSP처럼 뷰를 생성하는 것이 아닌 데이터 자체를 반환(단순 문자열, JSON, XML)
#### @GetMapping
> - 요청 URL을 어떠한 메서드가 처리할 지 맵핑
> - controller 내부에서 URI 경로 지정
#### YAML 파일
> - 사람이 쉽게 읽을 수 있는 데이터 직렬화 양식
> - JSON, XML과 같은 가독성을 고려한 데이터 포맷 형식
#### @ConfigurationProperties
> - 다양한 형의 프로퍼티값 매핑
> - 접두사를 사용하요 값을 바인딩
#### @Data
아래 어노테이션을 한 번에 처리하는 어노테이션
#### @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredAndConstructor
> - @ToString : 모든 필드를 출력하는 toString() 메소드 생성
> - @EqualsAndHashCode : hashcode 와 equals 메소드를 생성
> - @Getter/@Setter : getter, setter를 생성하지 않도록 지원
> - @RequiredAndConstructor : 생성자 생성 관련 지원
#### Spring Bean
> - 스프링 컨테이너에서 생성 된 자바 객체
#### @Bean, @Component
> - 목적이 명확하지 않은 자바 객체(Bean)를 생성할 때 사용하는 어노테이션
#### @Bean
> -  개발자가 컨트롤이 불가능한 외부 라이브러리를 Bean으로 등록하고 싶을 때 사용
#### @Component
> -  개발자가 직접 컨트롤이 가능한(생성한) 클래스의 경우 사용
#### H2
> - 자바로 작성된 인 메모리 관계형 데이터베이스 관리 시스템
#### @JUnit
> - 자바의 대표적인 단위 테스트 프레임워크
#### @RunWith
> - JUnit 프레임워크 테스트 실행 방법을 확장할 때 사용
> - Runner 클래스 설정 시 내장 된 Runner 대신 해당 하는 클래스 실행
#### @RestCilentTest
> - REST관련 테스트를 도와주는 어노테이션
> - JSON 형식이 예상대로 응답을 반환하는지 테스트
#### @JsonTest
> - JSON의 직렬화와 역직렬화를 수행하는 라이브러리 제공
> - 문자열로 나열된 JSON 데이터를 객체로 변환하여 변한된 객체의 값 테스트
