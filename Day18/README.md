# 게시글 리스트 띄우기(쿼리문짜서)
---
## ```리스트 다띄우기```
####
#### BoardService.java
~~~java
public List<Board> findBoardList(Pageable pageable) {
       pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.
               getPageNumber() - 1, pageable.getPageSize());
       return boardRepository.findAll();
   }
~~~
#### BoardRepository.java
~~~java
   public interface BoardRepository extends JpaRepository<Board, Long> {
       List<Board> findAll();
   }
~~~
## ```리스트 역순으로 띄우기```
####
#### BoardService.java
~~~java
public List<Board> findBoardList(Pageable pageable) {
      pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.
              getPageNumber() - 1, pageable.getPageSize());
      return boardRepository.findByOrderByIdxDesc();
  }
~~~
#### BoardRepository.java
~~~java
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByOrderByIdxDesc();
}
~~~
## ```pageable쓰고 리스트 역순으로 띄우기```
####
#### BoardService.java
~~~java
public Page<Board> findBoardList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.
                getPageNumber() - 1, pageable.getPageSize());
        return boardRepository.findByOrderByIdxDesc(pageable);
    }
~~~
#### BoardRepository.java
~~~java
public interface BoardRepository extends JpaRepository<Board, Long> {
    Page<Board> findByOrderByIdxDesc(Pageable pageable);
}
~~~
