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