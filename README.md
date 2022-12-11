# 🧶 Spring KNIT Webservice
![](https://velog.velcdn.com/images/dev_rimkim/post/3a85474b-82dc-4818-b817-f4c84c940137/image.png)

[![Github Badge](https://img.shields.io/badge/GITHUB-181717.svg?&style=for-the-badge&logo=GitHub&logoColor=white&link=https://github.com/Jayrimkim/jay-spring-webservice)](https://github.com/Jayrimkim/jay-spring-webservice)

<img href="https://velog.io/@dev_rimkim/series/%EB%B0%B1%EC%97%94%EB%93%9C-%ED%8F%AC%ED%8A%B8%ED%8F%B4%EB%A6%AC%EC%98%A4-%EB%A7%8C%EB%93%A4%EA%B8%B0" alt="Html" src ="https://img.shields.io/badge/My Blog-FF8800.svg?&style=for-the-badge&logo=Micro.blog&logoColor=white"/>

[사이트 구경하기](https://ec2-13-124-137-216.ap-northeast-2.compute.amazonaws.com:8080)
***

## 프로젝트 소개
#### 기획 의도
> 취미로 뜨개질을 하던 중, '이런 기능을 가진 웹사이트는 없을까?'란 생각에 직접 구현해본 뜨개인들을 위한 취미 웹사이트입니다.

#### 주요 기능
![](https://velog.velcdn.com/images/dev_rimkim/post/6e04d0d8-e0ba-42c7-ac53-2587bf4ee678/image.png)


#### 사용 기술
* 백엔드

 <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">  <img src="https://img.shields.io/badge/Spring data JPA-6DB33F?style=for-the-badge&logo=databricks&logoColor=white">   <img src="https://img.shields.io/badge/amazonaws-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white">  <img src="https://img.shields.io/badge/oauth 2.0-EB5424?style=for-the-badge&logo=Auth0&logoColor=white"> 

* 프론트엔드

<img alt="Html" src ="https://img.shields.io/badge/HTML5-E34F26.svg?&style=for-the-badge&logo=HTML5&logoColor=white"/> <img alt="Css" src ="https://img.shields.io/badge/CSS3-1572B6.svg?&style=for-the-badge&logo=CSS3&logoColor=white"/> <img alt="JavaScript" src ="https://img.shields.io/badge/JavaScriipt-F7DF1E.svg?&style=for-the-badge&logo=JavaScript&logoColor=black"/> <img src="https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=Bootstrap&logoColor=white"> <img src="https://img.shields.io/badge/Mustache-606060?style=for-the-badge&logo=Handlebars.js&logoColor=white">


#### 개발 기간
` 2022.08~2022.11 `
#### 디자인 패턴
MVC 패턴
![](https://velog.velcdn.com/images/dev_rimkim/post/c9ac98ba-bc22-4cf5-a890-0a3bcfcd9bc6/image.jpg)

## 주요 기능 상세 소개

#### 게시판 CRUD
(사진)

Posts 테이블 생성 후,
Dto 클래스를 통해 데이터를 주고받는다.
Service단에서 도메인의 순서를 지정 한 후
Controller단에서 API 요청을 받는다.

JPA Auditing으로 글 작성 시간을 자동화한다.

#### 댓글 CRUD
(사진)

Posts와 reply테이블은 1(Posts):N(Reply)로 조인한다.

게시글이 지워지면 댓글도 지워지도록 설정한다.



#### 페이징
(사진)
게시글이 많은 경우 편리하게 볼 수 있도록 페이징 기능을 구현했다.

#### 검색
(사진)
검색 메소드를 이용해 전체 게시글 중 검색을 구현했다.

#### 스크랩

(사진)
댓글과 비슷한 아이디어로 접근했지만 다른점은, 한 개의 게시물은 한 번만 스크랩 될 수 있다는 것이다. (1:1 조인)

게시글을 읽다 스크랩 버튼을 누르면 스크랩 완료 알림창이 뜨고, 스크랩 조회 전용 페이지로 이동하면 그동안 스크랩한 게시글의 목록이 나온다.

#### 뜨개질 계산기

(사진)

뜨개질로 가방을 만들기 위해서는 원형의 바닥뜨기가 필수이다. 정교한 패턴의 가방을 만들어야 하는 경우, 몇 코로 시작할것인지 계산이 필수적이기 때문에 mustache와 js로 간단하게 프론트엔드단에서 계산기를 구현했다.

버튼을 누르면 계산 결과가 alret창에 나오기 때문에 편하게 데이터를 확인하도록 했다.

#### OAuth 2.0 네이버, 구글 로그인

## 문제와 나아갈 길

#### 트러블 슈팅

###### 댓글 DELETE
버튼을 눌러도 제일 위의 삭제 버튼만 동작하고
그 아래 버튼은 동작하지 않는 에러가 있었는데, postsId와 commentId 값을 다음과 같이 정확하게 넘겨주니 제대로 동작하였다.
` <input type="hidden" id="commentId" value="{{id}}"> `

` <button onclick="main.replyDelete({{post.id}},{{id}})`  삭제 버튼에 onclick 속성을 줌으로써 따로 js파일에 버튼 매핑을 하지 않아도 된다.

#### 개선점

게시글 스크랩시 분류

## 참고

스프링 부트와 AWS로 혼자 구현하는 웹 서비스, 이동욱, 프리렉

dev-coco tistory

유튜브 
