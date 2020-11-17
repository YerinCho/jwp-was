# 웹 애플리케이션 서버

## 1단계 요구사항
 - 접속시 webapp 디렉토리의 index.html 파일을 읽어 클라이언트에 응답한다.
 - 모든 Request Header 출력하기
 - “회원가입” 메뉴를 클릭하면 http://localhost:8080/user/form.html 으로 이동하면서 회원가입할 수 있다. 
 - form 태그 method를 get에서 post로 수정한 후 회원가입 기능이 정상적으로 동작하도록 구현한다.
 - “회원가입”을 완료하면 /index.html 페이지로 이동
    - 브라우저의 URL이 /index.html로 변경
 - Stylesheet 파일을 지원

## 2단계 요구사항
 - WAS 기능 요구사항
    - 다수의 사용자 요청에 대해 Queue 에 저장한 후 순차적으로 처리가 가능하도록 해야 한다.
    - 서버가 모든 요청에 대해 Thread를 매번 생성하는 경우 성능상 문제가 발생할 수 있다. 
    - Thread Pool을 적용해 일정 수의 사용자 동시에 처리가 가능하도록 한다.
 - RequestHandler 리팩토링
    - HTTP 메소드, URL, 헤더, 본문을 분리   
    - 응답 처리에 대한 중복 제거
    - url 요청 분기처리
 
## 진행 방법
* 웹 애플리케이션 서버 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
