# KEYWORD P138~P143
---
#### @EnableOAuth2Client
> - 빈을 두개생성 해야하는 어노테이션
#### Oauth2ClientContext
> - 엑세스토큰을 받기 위한 변수,
#### BasicAuthenticationFilter
> - http 기본인증 헤더를 감시하여 처리하는 필터
#### FilterRegistrationBean
> - 필터를 추가해야 하는 인터페이스
#### oauth2ClientFilterRegistration
> - 현재의 요청과 컨텍스트를 저장하는 필터 빈을 생성하는 메소드
#### (OAuth2ClientContextFilter filter)
> -  파라미터 : 요청처리동안에 인증을 필요하는 경우 Ouath2 redirect url을 관리한다
#### Oauth2RestTemplate
> - accesstoken request 타입 빈  
#### oauth2Filter()
> - 로그인과 관련된 필터, 페이스북,구글,카카오 관련된 필터
#### CompositeFilter
> - 복합필터를 생성하는 클래스

~~~java
@Bean //사용자가 컨트롤 불가능 하면 외부 라이브러리에서 빈을 등록할떄 쓰는 어노테이션
  public FilterRegistrationBean oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {//필터를 추가하기위해 쓰는 인터페이스, 파라미터 : 요청처리동안에 인증을 필요하는 경우 Ouath2 redirect url을 관리한다
      FilterRegistrationBean registration = new FilterRegistrationBean();//현재 요청과 컨텍스트를 저장하는 필터 빈
      registration.setFilter(filter); // 우선순위를 정해줌
      registration.setOrder(-100);
      return registration;
  }

  private Filter oauth2Filter() {
      CompositeFilter filter = new CompositeFilter(); // 복합필터로 만듬
      List<Filter> filters = new ArrayList<>(); // filters라는 어레이리스트 생성
      filters.add(oauth2Filter(facebook(), "/login/facebook", FACEBOOK)); // 어레이리스트에 순서대로 추가
      filters.add(oauth2Filter(google(), "/login/google", GOOGLE));
      filters.add(oauth2Filter(kakao(), "/login/kakao", KAKAO));
      filter.setFilters(filters);
      return filter;
  }

  private Filter oauth2Filter(ClientResources client, String path, SocialType socialType) {
      OAuth2ClientAuthenticationProcessingFilter filter =
              new OAuth2ClientAuthenticationProcessingFilter(path); //Oauth2 클라이언트용 인증 처리 핕터 생성
      OAuth2RestTemplate template = new OAuth2RestTemplate(client.getClient(), oAuth2ClientContext);//권한서버와의 통신을 위해 생성,(클라이언트의 프로퍼티 하위 매핑값과 엑세스토큰을 받는 변수를 가지고옴)
      filter.setRestTemplate(template);
      filter.setTokenServices(new UserTokenService(client, socialType)); //엑세스토큰 검증을 위해서 UserTokenService를 필터의 토큰서비스로 등록
      filter.setAuthenticationSuccessHandler((request, response, authentication) -> response.sendRedirect("/" + socialType.getValue() + "/complete")); //엑세스토큰의 인증이 성공되었을때 필터에 URL설정
      filter.setAuthenticationFailureHandler((request, response, exception) -> response.sendRedirect("/error")); //엑세스토큰의 인증이 실패시 필터에 URL설정
      return filter; //필터로 반환
  }
  ~~~
