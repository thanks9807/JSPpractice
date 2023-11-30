# JSPpractice
Spring의 소중함을 알기위한 jsp개발

가상머신으로 mysql-server 세팅 후 실시.

1. JDBC 다운로드

mysql-connector J 다운로드
공식 홈페이지에서 다운 받을 수 있음.
하지만 Gradle를 통해 추가할 수 있음

build.gradle 파일의 depandency부분에
implementation group: 'com.mysql', name: 'mysql-connector-j', version: '8.0.33'
추가

주요 클래스 3가지
1. Connection conn = null; //연결하는 객체
2. Statement statement = null; //sql 을 실행하는 객체
3. ResultSet resultSet = null; //sql 결과를 저장하는 객체

tomcat donwmload 후 압축해제
tomcat / lib파일에 mysql-connecter.jar 파일 추가

자카르타 프로젝트 생성
후 tomcat lib에서 jsp와 servlet api를
프로젝트 라이브러리에 추가

intelliJ 왼쪽 상단 햄버거 누르고 Run->
Edit configuration -> + 누르고 Tomcat local
압축해제한 Tomcat 파일을 설정
deployment에서 아래  fix 누르고 exployed 선택

build. gradle에서
자카르타 import 된 거 지우고
compileOnly group: 'javax.servlet', name: 'javax.servlet-api', version: '4.0.1'
추가

src/main/java/com/example/jsptest/HelloServlet.java 
@WebServlet("/login") 으로 uri패턴 매핑하고 
각각의 HTTP 요청에 맞는 매소드 추가
일단 GET은 
doGet(HttpServletRequest request, HttpServletResponse response) throws IOException 


