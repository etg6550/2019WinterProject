## 5장 외워보기
---

#### SocialType.java
~~~java
public enum SocialType {
  FACEBOOK("facebook"),
  GOOGLE("google"),
  KAKAO("kakao");

  private final String ROLE_PREPIX = "ROLE_";
  private String name;

  SocialType(String name) {
    this.name = name;
  }

  public String getRoleType() {return ROLE_PREPIX + name.toUpperCase();}

  public String getValue() {return name;}

  public boolean isEquals(String authority) {return getRoleType.equals(authority);}
}
~~~
#### Board.java
~~~java
@Getter
@NoArgsConstructer
@Entity
@Table
public class User implements serializble {

  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idx;

  @Column
  private String name;

  @Column
  private String password;

  @column
  private String email;

  @Column
  @Enumerated(EnumType.STRING)
  private SocialType SocialType; //어떤 소셜미디어로 인증 받았는지 여부를 구분

  @Column
  private LocalDateTime createdDate;

  @Column
  private LocalDateTime updatedDate;

  @Column
  private String principal; // Oauth2 인증으로 제공받는 키 값

  @Builder
  public User(){
    ~
    ~
    ~
  }
}
~~~
#### ClientResources.java
~~~java
public class ClientResources {//yml파일의 리소스 정보를 객체로 매핑해주는 class

  @NestedConfigurationProperty //단일값이 아닌 중복으로 바인딩 해주는 어노테이션
  private AuthorizationCodeResourceDetails client = new AuthorizationCodeResourceDetails; //yml파일의 client 하위키값을 매핑해주는 객체

  @NestedConfigurationProperty
  private ResourceServerProperties resource = new ResourceServerProperties; //yml파일의 resource 하위의 키값인 userInfoUri 값을 받음

  public AuthorizationCodeResourceDetails getClient() {return client;}

  public ResourceServerProperties getResource() {return resource;}
}
~~~
#### SecurityConfig.java
~~~java
@Configuration
@EnableWebSecurity //웹에서 시큐리티 기능 사용하겠다는 어노테이션
public class SecurityConfig extends WebSecurityConfigureAdapter { //최적화설정
  //P136~137 시큐리티 설정
  @Override
  protected void configure(HttpSecurity http) throws Expection { //
    http
      .authorizeRequests()
        .antMatchers("/", "/css/**", "/login/**", "/console/**", "/images/**", "/console **").permitAll() // 패턴을 리스트형식으로 설정, 누구든지 접근이 가능함
      .anyRequest().authenticated() //이외의 요청들은 인증된 사용자만 접근 가능
    .and()
      .headers().frameOptions().disable() //응답에 해당하는 header를 설정
    .and()
      .exceptionHandling() // 로그인화면으로 되돌아온다
      .authenticatedEntryPoint(new LoginUrlAuthenticationEntryPoint("/login")) // url설정한 /login으로 설정
    .and()
      .formLogin()
      .syccessForwardUrl("/board/list") // 로그인을 성공적으로 하였다면 url설정한 /board/list로 설정
    .and()
      .logout() //로그아웃에 대한 설정
      .logoutUrl("/logout") //로그아웃 url
      .logoutSuccessUrl("/login") //로그아웃 성공했을때 다음으로 넘어갈 url
      .deleteCookies("JSESSIONID") //쿠키 삭제
      .invalidateHttpSession(true) // 세션 무효화
    .and()
      .addFilterBefore(filter, CsrfFilter.class) //문자인코딩보다 보안필터를 우선순위로 둔다
      .csrf().disable();
  }


  //p135 접두사형으로 각 소셜미디어 하위값 매핑하고 빈으로 등록
  @Bean
  @ConfigurationProperties("facebook")
  public ClientResources facebook() {
    return ClientResource;
  }

  @Bean
  @ConfigurationProperties("google")
  public ClientResources google() {
    return ClientResource;
  }

  @Bean //사용자가 컨트롤이 불가능한 외부라이브러리를 빈으로 등록하고싶을때
  @ConfigurationProperties("kakao") //접두사형 하위 키값을 매핑
  public ClientResources kakao() {
    return ClientResource;
  }
}
~~~
