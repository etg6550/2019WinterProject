# Keyword(P128~137)
---
#### @Configuration
> - 빈으로 생성한 자바객체를 스프링컨테이너에 넣기 위한 어노테이션 만약에 쓰지 않을 경우 빈을 스프링컨테이너로 등록을 하지 못한다. 의존성 주입의 차이
#### webSecurityConfigureAdapter
> - cofigure() 오버라이드 하여 웹 보안으로 설정
#### configure()
> - configure(WebSecurity), configure(httpSecurity), configure(AuthenticationManagerBuiler)
> - configure(httpSecurity http) : 스프링 보안에서 인증을 지원하는 메소드

#### Filter
> - client와 server사이에 요청과 응답을 하는데 있어서 중간 역할
#### scope
> - 기능 : drive, email, 로그인
#### principal
> - access token
#### ClientResources 클래스
> * yml의  리소스 정보의 프로퍼티를 객체로 매핑해줌
>  * @ConfigurationProperties : 접두사형 프로퍼티값을 매핑해준다. 이떄 프로퍼티값은 client와 resource
>  * @NestedConfigurationProperty : facebook,google,kakao의 프로퍼티값을 중복으로 매핑시켜준다. ConfigurationProperties 어노테이션을 쓸 경우 각각 소셜미디어마다 프로퍼티를 객체로 매핑을 해주는 클래스들을 다중으로 만들어야함.
#### Security설정
> - @EnableWebSecurity : 웹에서 시큐리티 기능을 사용하겠다는 어노테이션
> - .authorizeRequest() : 권한 요청
> - .andMatchers("/", "/login/별별"............).permitAll() : url을 리스트 형식으로 설정,  설정된 요청들을 누구나 접근할수 있도록 허용시킴
> - .anyRequest().authenticated() : 허용되지않은 이외의 요청들은 인증된 사용자만 접근할수 있다.
> - .headers().frameOptions().disable() : Spring Security와 Spring Boot를 같이 사용하게 되면 H2 데이터 베이스 콘솔 접근이 차단되는 상황을 막기 위해 사용
> - .exceptionHandling().authenticationEntryPoint(new Login....(""/login")) : 인증된 사용자가 아닐경우 설정된 url로 리다이렉트.
> - .formLogin().successFormUrl("/board/list") : 로그인 성공했을 시 /board/list로 바로 넘어간다.
> - .logoutUri(/logout) : 로그아웃을 유발하는 URL
> - /logout.logoutSuccessUrl(/login(설정해놈)) : 로그아웃 후 리다이렉션 할 URL
> - CsrfFilter.class : 사이트간 요청 위조를 방지하는 필터
> - .addFilterBefore(filter, CsrfFilter.class).csrf().disable() :  filter보다 csrfFilter.class를 먼저 실행 시킨다.  
