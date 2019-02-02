## 4장 외워보기
---

#### BoardType.java
~~~java
public enum BoardType { //자바 열거형 객체
  notice("공지사항"),
    free("자유게시판");

    private String value;

    BoardType(String value) {
      this.value = value;
    }
    public String getValue() {
      return this.value;
    }
}
~~~
#### Board.java
~~~java
@Getter //get함수를 자동생성
@NoArgsConstructer // 파라미터가 없는 기본생성자를 만들어줌
@Entity // entity클래스의 테이블 정보를 JPA에게 전달
@Table // entity와 db테이블을 매핑
public class board implements serializble {

  @Id //entity클래스의 필드를 테이블의 기본키로 설정
  @Column //필드의정보를 column에 매핑
  @GeneratedValue(strategy = GenerationType.IDENTITY) //스프링 2.x버전이상부턴 table을 쓰기떄문에 identity를 명시적으로 표현해야함
  private Long idx;

  @Column
  private String title;
  @column
  private String subTitle;
  @Column
  private String content;
  @Column
  @Enumerated(EnumType.String) //enum형 객체를 string형으로 변환하여 db에 저장
  private BoardType boardType;
  @Column
  private LocalDateTime createdDate;
  @Column
  private LocalDateTime updatedDate;
  @OneToOne(fetch = FetchType.LAZY) //user객체를 조회하는 시점이 아닌 객체가 실제로 사용될떄 조회
  private User user;

  @Builder
}
~~~

#### User.java
~~~java
@Getter
@NoArgsConstructer
@Entity
@Table
public class user implements Serializable {

  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idx;

  @Column
  private String name;
  @Column
  private String password;
  @Column
  private String email;
  @Column
  private LocalDateTime createdDate;
  @Column
  private LocalDateTime updatedDate;

  @Builder

}
~~~

#### JpaMappingTest.java
~~~java
@RunWith(SpringRunner.class) //Junit확장을 해줌
@DataJpaTest //jpa테스트 전용 어노테이션, 테스트 끝나면 롤백을 자동으로 해준다
public class jpaMappingTest {
  private final String testTitle = "xx";
  private final String email = "havi@gmail.com";

  @Autowired //타입을 이용해서 의존객체를 삽입시켜줌
  BoardRepository boardRepository;
  @Autowired
  UserRepository userRepository;

  @Before
  public void init() {
    User user = userRepository.save(User.builder()
    .name("havi")
    .password()
    .email(email)
    .createdDate(LocalDateTime.now())
    .build());

    boardRepository.save(Board.builder()
    .title(testTitle)
    .subTitle("")
    .content("")
    .boardType(BoardType.free)
    .createdDate(LocalDateTime.now())
    .updatedDate(LocalDateTime.now())
    .user(user).build());
  }

  @Test
  public void test() {
    User user = userRepository.findByEmail(email);
    assertThat(user.getName, is("havi"));
    ~
    ~
    Board board = boardRepository.findByUser(user);
    assertThat(board.getTitle, is(testTitle));
    ~
    ~
    ~
  }
}
~~~
#### BoardRepository.java, UserRepository.java
~~~java
public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmail(String email);
}

public interface BoardRepository extends JpaRepository<Board, Long> {
  Board findByUser(User user);
}
~~~
#### BoardService.java
~~~java
@Service
public class BoardService {
  private final BoardRepository boardRepository;

  public BoardService(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }
  public Page<Board> findBoardList(Pageable pageable) {
    pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1, pageable.getPageSize())
    return boardRepository.findAll(pageable);
  }
  public Board findBoardByIdx(Long idx) {
    return boardRepository.findById(idx).orElse(new Board());
  }
}
~~~
#### BoardController.java
~~~java
@Controller
@RequestMapping("/board")
public class BoardController {
  @Autowired //boardService 의존성 주입
  BoardService boardService;

  @GetMapping({"", "/"}) //중괄호를 이용하여 매핑 경로를 여러개로 줄수있다.
  public String board(@RequestParam(value = "idx", defaultValue = "0") Long idx,
    Model model) { //idx파라미터를 필수로 받고, 디폴트값 0(null)
      model.addAttribute("board", boardService.findBoardByIdx(idx));
      return "/board/form";
    }
  @GetMapping("/list")
  public String list(@PageableDefault Pageable pageable, Model model) { //페이징 처리에 대한 규정을 정할수있다.
    model.addAttribute("boardList", boardService.findBoardList(pageable));
    return "/board/list";
  }
}
~~~
