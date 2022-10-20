# Senior-Danger-Analysis-Care-App (SDA 보호자앱)

## 서울시립대학교, 컴퓨터과학부 - 컴퓨터과학종합설계

일상생활 데이터 분석 기반 시니어 케어 시스템 개발  
( Development of Senior Care System based on Daily Life Data )

---

## 소프트웨어 프로그램 소스

[Github] SDA 단말기앱 https://github.com/h-spear/Senior-Danger-Analysis  
[Github] SDA 보호자앱 https://github.com/h-spear/Senior-Danger-Analysis-Care-App  
[Github] SDA MODEL https://github.com/ttjh1234/CSproject_SDA

---

## 개발 과제 요약

어르신들의 건강 및 안전 케어에 대한 관심이 높아지고 있으며, 이를 위한 다양한 서비스가 검토되고 있다. 특히 어르신들의 거주 공간에서 생활 정보를 바탕으로 어르신들의 응급 안전 대응 및 건강 관리를 할 수 있다면 이는 매우 효과적인 서비스가 될 것이다. 본 개발의 목표는 디스플레이형 AI 단말기를 활용하여 65세 이상의 시니어를 대상으로 일상 생활 데이터를 모으고, 앞에서 말한 서비스 중 실시간 행동 분석을 통한 어르신들의 안전 케어 및 위험 상황 판단에 대한 스마트 서비스를 제공하는 시스템을 개발하는 것이다.

### **기술적 기대 효과**

기존의 연구되었던 실시간 행동 분석 관련 프로젝트에서는 CCTV나 IP 카메라에 연결된 RTSP 서버는 행동인식 서버에 실시간으로 동영상을 전송하고, 촬영된 영상은 스마트폰과 같은 사용자의 애플리케이션으로 전송하여 모니터링하는 기법을 사용하고 있다. 하지만, 다수의 CCTV와 연결된 서버는 많은 영상 처리 및 저장과 관련하여 실시간 성능 및 수용력에 한계를 지니며 병목 현상이 이루어지는 문제가 있다. 해당 프로젝트에서는 AI 단말기 내에서 프레임 추출, 행동 분류, 알림 전송 기능을 실행하고 처리하는 형식으로 구현하여 병목 현상을 방지할 수 있을 것이다. 이러한 면에서 많은 사용자들을 수용할 수 있는 수용력을 가진다. 또한 일련의 진행과정에서 서버와의 통신과정이 제외되기 때문에 시간이 단축될 것이다.

### **경제적 및 사회적 파급효과**

AI 단말기가 시니어들의 주거공간에 보급되고 있는 가운데, 여러 기기들에서 처리하는 것이 아닌, 해당 단말기를 통해 서비스를 제공하므로 추가적인 단말기 구입 비용이 절약된다. 앱 내에서 진행되는 서비스 특성상 서버 구현에 드는 비용도 없다. 또한, 현재 국가 주도 및 지자체에서 어르신들의 건강 관리 및 위험 상황들을 파악 및 예방, 대처하려는 노력을 하고 있다. 이에 관련지어, 일상생활에서 어르신들의 위험상황을 탐지하고 보호자에게 알림을 주어 빠른 대처가 가능할 것이고 한계가 정해져있는 예산 안에서 많은 노인분들을 케어하는 입장인 지자체에게 좋은 선택지가 될 것이다.

---

## 구성원 및 추진체계

|       이름       |                    책임                    | 세부 내용                                                                                                                        |
| :--------------: | :----------------------------------------: | -------------------------------------------------------------------------------------------------------------------------------- |
| 박희수<br>(팀장) | 프로젝트 관리자<br>안드로이드 앱 개발 보조 | 1. 전체 프로젝트 관리 및 일정 조율<br>2. 최종 검토 및 승인<br>3. 단말기와 스마트폰 사이의 통신 구현<br>4. 파이어베이스 기능 연결 |
|      김현창      |             안드로이드 앱 개발             | 1. Android Application 작성<br>2. 시니어앱&보호자 앱 총괄<br>3. 카메라 제어 및 딥러닝 모델 이식<br>4. UI 디자인                  |
|      정윤조      |             안드로이드 앱 개발             | 1. Android Application 작성<br>2. 단말기와 스마트폰 앱 통신 구현<br>3. 파이어베이스 기능 연결                                    |
|      최성수      |              딥러닝 모델 개발              | 1. 데이터 전처리<br>2. 모델 구축 및 학습<br>3. 모델 평가<br>4. Android에 이식가능한 형태로 모델 배포                             |

---

## 참고문헌 및 참고사이트

● [1] 김성현, 김용욱, 권대규, 김남균(2006), “낙상 방향에 따른 신체 관절의 동적 특성 분석”, p447-p448  
● [2] 김선기, 안종수, 김원호(2016), “영상처리 기반 낙상 감지 알고리즘의 구현”, p56-p59  
● [3] 김지민, 윤기범, 심정용, 박소영, 신연순(2020), “YOLOv3 알고리즘을 이용한 실시간 낙상 검출”  
● [4] 강윤규, 강희용, 원달수(2021), “PoseNet과 GRU를 이용한 Skeleton Keypoints 기반 낙상 감지”, p127-p132  
● [5] 임태규, 『텐서플로 라이트를 활용한 안드로이드 딥러닝』, 한빛미디어(2021)  
● [6] 장재영 외 4인, 지능형 행동인식 기술을 이용한 실시간 동영상 감시 시스템 개발 (The Journal of The Institute of Internet, Broadcasting and Communication (IIBC) Vol. 19, No. 2, pp.161-168, Apr. 30, 2019. pISSN 2289-0238, eISSN 2289-0246)  
● [7] Sijie Yan, Yuanjun Xiong, Dahua Lin. “Spatial Temporal Graph Convolutional Networks for Skeleton-Based Action Recognition”  
● [8] Valentin Bazarevsky, Ivan Grishchenko, Karthik Raveendran, Tyler Zhu, Fan Zhang, Matthias Grundmann, Google Research. “BlazePose: On-device Real-time Body Pose tracking”  
● [9] Daniele Grattarola, Cesare Alippi. “Graph Neural Networks in TensorFlow and Keras with Spektral”  
● [10] Julieta Martinez, Rayat Hossain, Javier Romero, and James J. Little. “A simple yet effective baseline for 3d human pose estimation”

◇ Foreground Service

-   https://developer.android.com/guide/components/foreground-services

◇ Pose Detection API

-   https://developers.google.com/ml-kit/vision/pose-detection

◇ Firebase

-   https://firebase.google.com/docs/auth
-   https://firebase.google.com/docs/storage
-   https://firebase.google.com/docs/database
-   https://firebase.google.com/docs/hosting
-   https://firebase.google.com/docs/cloud-messaging

◇ Tensorflow Lite

-   https://www.tensorflow.org/lite

◇ Article

-   노년층 증가로 ‘시니어 맞춤형 서비스’ 출시하는 기업들
    http://it.chosun.com/site/data/html_dir/2020/11/07/2020110701161.html
-   '초고령사회' 진입 초읽기…이통3사, '시니어 케어' 사업 확대에 적극 나서
    https://www.greened.kr/news/articleView.html?idxno=289627
-   홀로 죽음 맞는 '고독사' 3배 늘었다…43%는 '65세 이상’
    https://www.nocutnews.co.kr/news/5698160
-   통화중 ATM 인출 등 이상행동...신한은행, AI로 보이스피싱 예방
    https://news.mt.co.kr/mtview.php?no=2022030710540742302
-   SKT, AI 기반 지능형 영상분석 솔루션 내년 상반기 출시...자체 AI칩으로 기술 격차 자신
    http://www.aitimes.com/news/articleView.html?idxno=141159

◇ Data Resource

-   한국전자통신연구원(ETRI) : https://ai4robot.github.io/etri-activity3d-livinglab/
-   Jinhyeok Jang, Dohyung Kim, Cheonshu Park, Minsu Jang, Jaeyeon Lee, Jaehong Kim, “ETRI-Activity3D: A Large-Scale RGB-D Dataset for Robots to Recognize Daily Activities of the Elderly”, International Conference on Intelligent Robots and Systems (IROS) 2020, pp.10990-10997

---

## 관련특허

● 엘에스산전 주식회사, 독거노인 케어 시스템, 10-2013-0053844, 2013  
● 한남대학교 산학협력단, 리모콘을 이용한 위험 관리 시스템, 10-2016-0018784, 2016
