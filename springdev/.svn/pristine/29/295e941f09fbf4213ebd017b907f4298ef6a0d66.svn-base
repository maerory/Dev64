/article/insert (GET) 	입력폼 출력
/article/insert (POST) 	폼 데이터를 table에 insert
/article/list	(GET)	게시물 리스트 출력
/article/view	(GET)	게시물 상세보기
/article/update (GET)	수정폼 출력
/article/update (POST)	폼 데이터가 최초 비밀번호 일치시 table에 update
/article/delete (GET)	삭제를 위한 비밀번호 입력 폼 출력
/article/delete (POST)	폼 데이터의 글번호 비밀번호 일치시 게시물 delete

Presentation Layer		Service Layer			Persistence Layer
-사용자의 요청 url을 	-비즈니스 로직을 구현	-영속적 데이터 저장
 액션과 매핑             제어문, 업무단위의 구현 file, DB...
                                                 사용방식(framework이 바뀌거나
                                                 DB가 바뀔 수 있음...)

						- ArticleService		- ArticleDAO
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
ArticleController		- ArticleServiceImpl	- ArticleDAOImpl
                                                - ArticleDAOibatis

@Component
@Controller				- @Service				- @Repository
