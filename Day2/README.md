### YAML  
> 깊이에 따라 구분짓기 때문에 list, set, map등 다양한 바인딩형 매핑이 훨씬 간편

- 언더바 표기법 : c++
- 낙타 표기법 : java

- 바인딩 초기화 하는것 ex) a=3;

### 메타데이터
> !) 특정 목적을 위해 만든 데이터.
 !!) 데이터에 관한 구조화된 데이터로, 다른 데이터를 설명해주는 데이터.
 !!!) 상대적으로 이해하기 쉽고, 가독성으로 좋음
 !!!!) 파일 확장자 .yml사용

### @ConfigurationProperties
>다양한 형의 프로퍼티 값을 매핑 할수잇다.
>통째로 들고올때

### @Value
> 프로퍼티의 키를 사용하여 특정한 값을 호출. 키를 정확히 입력해야 하며 값이 없을 경우 예외 처리
yaml파일의 하나씩 값을 가져올때

### SpEL(스프링 표현 언어 Spring Expression Language)
> SpEL은 런타임에 객체 참조에 대해 질의하고 조작하는 기능을 지원하는 언어

### POJO (Plain Old Java Object)
>오래된 방식의 자바 객체
>단순한 자바 객체
### @SpringBootTest
>통합 테스트를 제공하는 기본적인 어노테이션
### @SpringBootConfiguration
>스프링 부트의 설정을 나타내는 어노테이션
### @EnableAutoConfiguration
>자동 설정의 핵심 어노테이션
### @ComponentScan
특정 패키지 경로를 기반으로 @Configuration에서 사용할 @Component설정 클래스를 찾는다.
Spring bean : bean container에서 생성된 객체들

### IOC
>제어의 역전 즉 외부에서 제어를 한다는 것
### bean container
>컨테이너에 의해서 관리되고 어플리케이션의 핵심을 이루는 객체를 bean이라고한다
### bean
>spring container, IOC container에 의해서 instance화 되어 조립되거나 관리되는 객체

### selectImports()
>객체를 자동으로 생성해주는 메소드
