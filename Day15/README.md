## 5장
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
#### SecurityCinfig.java
~~~java
@Configuration
public class SecurityConfig {

  @Bean
  @ConfigurationProperties("facebook")
  public ClientResource facebook() {
    return ClientResource;
  }

  @Bean
  @ConfigurationProperties("google")
  public ClientResource google() {
    return ClientResource;
  }

  @Bean //사용자가 컨트롤이 불가능한 외부라이브러리를 빈으로 등록하고싶을때
  @ConfigurationProperties("kakao") //접두사형 하위 키값을 매핑
  public ClientResource kakao() {
    return ClientResource; 
  }

}
