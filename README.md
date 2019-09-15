직원관리 프로그램
=====
모 회사 면접 문제로 나왔던 문제인데 언어를 공부하기 좋은 예제인 것 같아 기록한다.
- - -
## 목차
1. [요구사항](#요구사항)
	* [원본](#원본)
	* [사용자 인터페이스](#사용자-인터페이스)
2. [버전별 특이사항](#버전별-특이사항)
3. [고려사항](#고려사항)
4. [기록](#기록)
	* [설정 파일 분리](#설정-파일-분리)

## 요구사항
### 원본
<img src="./img/comtrue.png" width="600" height="700"></br>

##### [목차로 이동](#목차)

### 사용자 인터페이스
즉, 콘솔 메뉴다.

| 인터페이스 | 동작 | 입력값 |
| :--: | -- | -- |
| 0 | Exit(종료) | |
| 1 | C(직원 정보 입력) | 이름, 전화번호, 직급, 이메일(직원번호는 자동증가) |
| 2 | R(직원 리스트) | |
| 3 | R(직원 상세 정보 출력) | |
| 4 | U(직원 정보 수정) | 직원번호 |
| 5 | D(직원 정보 삭제) | 직원번호(삭제된 직원번호 공란 유지) |

##### [목차로 이동](#목차)

## 버전별 특이사항
각 버전별로 어떤 기능이 구현되어 있는지 기록

* v_1.0
	* CRUD 구현(설계 없이 기능 구현에만 초점)
* v_2.0
	* Flow: I/O 최소화
		* 실행
			* 설정 정보 읽어 파일 확인
			* 파일 → 메모리(I/O)
		* CRUD: 메모리 작업
		* 종료: 메모리 → 파일(I/O)
	* 출력 유연성: 인터페이스 사용
		* 출력 형식 다변화
			* 리스트 출력, 상세 정보 출력 등
			* 이후 고려: 콘솔 출력, 웹 출력 등
	* 입력 형식 설정: [설정 파일 분리](#설정-파일-분리)
		* 자주 변경되지 않는 공통 정보의 경우 프로퍼티 파일 이용 권장
			* 자바 파일로 지정하면 정보 변경 시, 재컴파일의 불편함 존재
		* 저장 형식: 메모장, 엑셀 등
			* 단, 입력 ≠ 저장(종료 = 저장)
	* 유틸 패키지 생성
		* [static 멤버 사용](https://github.com/nara1030/ThisIsJava/blob/master/docs/etc/static_vs_non-static.md)
* v_3.0
	* 단위 테스트(예외 처리: 입력 등)

##### [목차로 이동](#목차)

## 고려사항


##### [목차로 이동](#목차)

## 기록
### 설정 파일 분리
설정 파일(.properties) 사용하는 방법을 적는다. 코딩중 겪고 있는 문제점을 바로 아래 적었다.

> * 공통 정보(DB 접속 정보, 저장 파일 위치 등)를 하드코딩하지 않기 위해 설정 정보를 분리했으나 `설정 정보 로딩 과정에서 하드코딩 발생`  
> * 로컬에서만 실행하지 않기 위해 상대경로를 사용하고 싶은데 절대경로(하드코딩) 사용

* 필요성
	* 소스에 직접 값(설정 정보 및 공통 정보)을 하드코딩한다면 (변수가 많을 시) 유지보수가 힘들어짐
	* 이런 정보들을 자바 파일에 지정한다면, 변경시 재컴파일의 불편함 발생
* 예
	* DB 접속정보, 특정 모듈의 경로 정보, 로그파일의 위치 정보 등
	* `DB.properties`
		* 다음 코드가 많이 등장  
			```java
			Reader reader = Resource.getResourceAsReader(resource);
			```
		* 여기서 [Resource](http://www.gisdeveloper.co.kr/?p=5168)는 myBatis 라이브러리
	* 일반 설정 파일
		* 방법1  
			```java
			// 프로퍼티 파일 스트림에 담기
			FileInputStream fis = new FileInputStream(resource);
			// 프로퍼티 파일 로딩
			properties.load(new java.io.BufferedInputStream(fis));
			```
		* 방법2  
			```java
			String config = "xxx.properties";
			ClassLoader currentThreadClassLoader = Thread.currentThread().getContextClassLoader();
			currentThreadClassLoader.getResource(config);
			```
			* [자바 - 경로 및 사용법 정리](https://hamait.tistory.com/360)
			* [자바 - Properties 설정파일 사용하기](https://daily-study.tistory.com/7)
* 개념
	* Properties는 HashTable을 상속받아 구현한 컬렉션
	* `HashMap`: Object, Object  
	  `Properties`: String, String
* 기타
	* `#`: 주석
	* 한글 출력: 유니코드 작성
	* 경로: 절대 vs 상대
		* 상대경로
			* `/`: 루트
			* `./`: 현재 위치
			* `../`: 현재 위치 상단 폴더

##### [목차로 이동](#목차)
