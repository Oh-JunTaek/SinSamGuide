# 프로젝트 구조

## 1. 메인 화면
메인 화면은 크게 다음 세 가지 요소로 구성됩니다:

- **장수 이미지**: 사용자가 환경 설정 메뉴에서 변경 가능합니다.
- **버튼들**: 이 버튼들은 버전 업데이트 시 삭제되거나 추가될 수 있습니다.
- **햄버거 메뉴**: 화면의 한쪽 구석에 위치합니다.

## 2. 말풍선 내용
말풍선에 들어갈 내용은 대분류 - 소분류 순으로 정리합니다:

- **기본 가이드**
  - 기본 공략
  - 제작자 Tip
- **이벤트**
  - 메인 이벤트
  - 시즌 이벤트
  - 특수 이벤트
  - 소비 이벤트
- **컨텐츠**
  - 메인 컨텐츠
  - 시즌 컨텐츠
- **도감**
- **자유게시판**

## 3. 햄버거 메뉴
햄버거 메뉴에는 다음 항목들이 포함됩니다:

- 환경 설정
- 앱 정보
- 알림 설정


# 기능 구현

## 1. 알림 기능

사용자에게 다양한 알림을 보내기 위한 기능을 구현합니다. 현재 구현할 알림의 종류는 다음과 같습니다:

- **새 버전 소식 받기**: 약 45일 간격으로 업데이트가 진행됩니다. 이 알림을 활성화한 사용자에게는 새 버전이 출시될 시 알림을 보냅니다.
- **시즌 알림 받기**: 시즌 종료되기 전 알림을 보내줍니다. 하위 메뉴로는 시즌 보상 마감 알림과 시즌 종료 마감 알림이 있습니다.
  - **시즌 보상 마감 알림**: "천하통일 보상까지 2시간 남았습니다. 적대 세력의 방해를 조심하세요."라는 알림을 제작자가 설정한 시간에 보냅니다.
  - **시즌 종료 마감 알림**: "시즌 신청을 잊지 마세요. 곧 시즌이 종료됩니다"라는 알림을 보냅니다.
- **까먹지 마세요 알림**: 사용자가 원하는 시간에 알림을 보내줍니다. "잊은 이벤트가 없는지 확인해 주세요"라는 알림을 보냅니다. 20시, 21시, 22시, 23시, 23시30분 중 선택하도록 합니다(복수 선택 가능).
- **서버 점검 알림**: 시즌이 시작될 때마다 사용자에게 알림을 보냅니다. 제작자가 설정한 시간에 알림을 보냅니다. (앱 업데이트 때마다 알림 보내는 시간을 설정해야 하므로 이에 대한 기능을 구현하거나 관리가 용이하게 만듭니다.)
- **깜빡 금지 알림**: 요일마다 다양한 이벤트가 진행되기 때문에, 이 알림을 활성화한 사용자에게는 주요 이벤트 시작하기 30분 전에 알림을 보냅니다. 요일별로 다른 알림을 보내야 합니다.

- 
