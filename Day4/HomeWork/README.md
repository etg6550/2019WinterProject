# 어노테이션
---

#

### @Getter
> -   클래스내 모든 필드의 Getter 메소드를 자동생성한다.
### @Id
> -   해당 테이블의 PK 필드를 나타낸다
### @NoArgsConstructor
> - 파라미터가 없는 기본 생성자를 생성해준다.
### @Entity
> -   테이블과 링크될 클래스임을 나타낸다.
> -   언더스코어 네이밍(언더바)으로 이름을 매칭한다.
> -   ex) SalesManager.java -> sales_manager table
### @Column
> -   테이블의 컬럼을 나타내면, 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 된다.
> -   사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있을경우 사용한다.
> -   문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나(ex: title), 타입을 TEXT로 변경하고 싶거나(ex: content) 등의 경우에 사용된다
### @Builder
> -   해당 클래스의  빌더패턴 클래스를 생성한다.

> - $빌더패턴$이란. 객체의 생성과정과 표현방법을 분리하여, 객체를 단계별 동일한 생성 절차로 복잡한 객체로 만드는 패턴이다.
>     (->빌드패턴을 쓰는 경우는 생성자나 생성자나 static 팩토리 메소드에서 많은 매개변수를 갖게 되는 클래스를 설계할 때는 필더 패턴이 좋은 선택이다. 이유는 코드의 작성이 쉽고 가독성이 좋기 때문이다.)
> -   생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함한다.
---
> - 예를 들어 아래 생성자의 경우 지금 채워야할 필드가 무엇인지 명확히 지정할수가 없다

<img src ="캡처.PNG">

> - 하지만 빌더를 사용하면 어느 필드에 어떤 값을 채워야 할지 명확하게 인지할 수 있다.

<img src ="1.PNG">

### Serializable(직렬화)
 > - 자바 직렬화란 자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부의 자바 시스템에서도 사용할 수 있도록 바이트(byte) 형태로 데이터 변환하는 기술과 바이트로 변환된 데이터를 다시 객체로 변환하는 기술(역직렬화)
> - 객체를 직렬화하여 전송 가능한 형태로 만드는 것을 의미한다. 객체들의 데이터를 연속적인 데이터로 변형하여 Stream을 통해 데이터를 읽도록 해준다.
> - 이것은 주로 객체들을 통째로 파일로 저장하거나 전송하고 싶을 때 주로 사용된다.


### @Table
> - 별도의 이름을 가진 데이터베이스 테이블과 매핑할 수 있다.
> -  기본적으로 $@Entity$로 선언된 클래스의 이름은 실제 데이터베이스의 테이블 명과 일치하는 것을 매핑한다.
> - $@Entity$ 클래스명과 데이터베이스의 테이블명이 다르면 @Table(name="XXX") 같은 형식으로 작성하면 이름을 다르게 해서 매핑가능하다.