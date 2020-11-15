- 원격저장소 연결 끊기
1. git remote -v
2. git remote remove origin(1에서 사용한 명령어의 결과로 나온 이름을 사용해야 함 origin이 아닐수도 있음)

- intellij 터미널 gitbash 사용하기
1. Settings창의 검색필드에 Terminal이라고 쳐서 터미널 설정 변경 메뉴로 이동
2. Shell path 에서 "C:\Program Files\Git\bin\sh.exe(shell이 설치된 경로)" -login -i 
3. 큰 따옴표로 경로 감싸고 옵션에 - 줘야 함.

- intellij 톰캣 한글 깨짐 방지 설정
1. 톰캣 Setting VM Option 에서 -Dfile.encoding=UTF-8
2. 액션검색에서 Edit Custom VM Options.. 찾아서 -Dfile.encoding=UTF-8 추가
3. File > Settings 에서 Editor > File Encodings  이동하여 encoding 옵션 변경

- Log 설정
1. 스프링 따로 설정하지 않는 한 아파치의 JCL(단순 로깅 인터페이스) 사용함
2. 구현체 라이브러리(log4j)가 있어야 로깅 사용 가능하다.
3. logback은 JCL 이 아닌 slf4j(로깅인터페이스)의 구현체이다.
4. 그래서 스프링에서 logback 사용하기 위해서는 JCL과 slf4j를 이어주는 라이브러리(jcl-over-slf4j)가 필요하다.
5. Spring framework -> JCL -> jcl-over-slf4j -> slf4j -> logback 이런 구조를 사용해야 함.
6. logback 사용하기 위해서 commons-logging 빌드에서 exclude 설정해야함.
7. logback-classic 의존성에 추가하면 의존하는 라이브러리 slf4j-api 도 자동으로 내려받음.
8. 결론 commons-logging exclude, logback-classic, jcl-over-slf4j 의존성 추가.
9. 마지막으로 의존관계 설정이 종료되면 logback.xml 설정파일 추가.
10. logback 공식 사이트 http://logback.qos.ch/documentation.html

- JUNIT5 설정
1. https://javacan.tistory.com/entry/JUnit-5-Intro
2. https://do-study.tistory.com/98