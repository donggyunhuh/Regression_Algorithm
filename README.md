# Regression_Algorithm (회귀분석 알고리즘)

201901730 허동균

## 개요

최적화 알고리즘에 관한 레포트이다.

회귀 분석에 대한 이해 후 최적해를 전역 최적화 알고리즘 중 하나인 유전 알고리즘으로 구하는 과정에 관한 레포트이다.

내가 이해한 내용을 바탕으로최대한 회귀, 유전 알고리즘에 대해 누구나 이해할 수 있도록 설명하려 노력했다.

그래프, 그림자료는 직접 제작하였다.

노상규, 1998, 「유전자 알고리즘을 이용한 변수 선택법」 을 참고하였다.

## 목차

1. 회귀(Regression)의 의미

2. 회귀분석

3. 회귀분석 모델 선정 및 데이터 조사

4. 전역 최적화 알고리즘인 유전 알고리즘 이용

5. 회귀식 도출

## 회귀란?

회귀란 영어로 'regression' 이고, 사전적으로 'go back to an earlier and worse condition' 이라는 의미를 가진다.

이는 '초기의 대표적인 상태로 돌아가려는 경향을 가진다' 로 번역된다.

한 예로, 대한민국 평균키는 2022년 기준 남성은 172.5cm, 여성은 159.6cm이다.

이때, 임의의 대한민국 남성과 여성이 결혼하여 자녀를 낳고, 그 자녀의 키를 조사한다고 가정한다.

임의의 대한민국 남성, 여성이므로 다양한 키의 부부 조합이 탄생할 것이다.

세대를 거듭하여 이 과정을 반복하면 돌연변이(부모의 키보다 작거나 큰경우)가 발생하여도 자손들의 평균 키 조사결과 는 결국 위에서 언급한 대한민국 남녀 평균키로 수렴할 것이다.

이것이 회귀의 기본적 분석이라고 할 수 있다.

이번 기말 대체 레포트에서 다룰 내용은 다양한 회귀분석 기법중 '유전 알고리즘'을 이용한 회귀분석이다.

밑에서 다룰 내용은 회귀 분석 중 '단순선형 회귀분석'이다.

## 회귀분석

단순선형 회귀분석이란 두 변수, 즉 하나의 독립변수(x)와 하나의 종속변수(y) 사이의 관계를 알아내는 것이다.

여기에서, x와 y의 관계식을 구할 수 있다. 이를 회귀식이라고 하며, y = ax + b의 꼴로 나타낼 수 있으며 선형적으로 표현한다.

단순선형 회귀분석의 궁극적 목표는 위 회귀식을 찾아내는 것이다.

예를 들어, 일정 크기의 밀폐된 공간에서 사람수에 따라 코로나19 확진자 수의 대한 자료가 있다고 가정해보자.

이 예시에서, 독립변수(x)는 사람의 수, 종속변수(y)는 코로나19 확진자 수이다.
각각의 사람은 면역력 차이가 있어 코로나19 확진자 수는 항상은 같지 않을 것이다.

임의로 사람수에 따른 확진자 수를 정하고 데이터로 표현하여 산점도로 나타내보면 밑의 그림과 같다. ('사람수가 증가할수록 코로나19 확진자 수도 증가한다'는 사실에 기반)

이를 정리해보면, 데이터 분포의 추세를 직선 그래프꼴로 나타냈을때, 실제 데이터 값과 회귀값(평균값)의 차이를 최소화시킬 수 있는 식이 구하는 회귀식인 것이다.

<p align="center"><img src="https://github.com/donggyunhuh/Regression_Algorithm/blob/main/example%201.jpg?raw=true" height="300px" width="500px"></p>
<br/>

    실제 데이터 값과 회귀값의 차이를 '에러값'이라 정하면, 에러값이 최소가 될때 회귀식은 데이터 분포가 몰린 부분을 지나는 직선의 형태로 나타난다.

이 레포트에서는 a값, 즉 에러값이 최소일때 최적해(회귀식의 기울기)를 찾는 것을 목표로 한다.

## 회귀분석 모델 선정 및 데이터 조사

### 키에 따른 한국 여성의 발 크기

_출처 : 8차 인체치수조사 (2020~21), 사이즈코리아_

    * 독립변수 : 키
    * 종속변수 : 발 크기

키를 {} 꼴로 표현하면

{ 1657, 1672, 1578, 1573, 1648, 1591, 1681, 1550, 1630, 1619, 1524, 1631, 1630, 1654, 1580, 1602, 1625, 1664, 1591 1670, 165,3 1665, 1616, 1659, 1583 } \*

발 크기를 {} 꼴로 표현하면

{229.2, 249.1, 233.2, 226.4, 233.8, 234.5, 249.4, 218.9, 249.6, 234.5, 217.6, 238.5, 235.3, 242.2, 231.4, 228.1, 225.8, 237.9, 216.7, 246.5, 239.9, 238.2, 219.4, 236.4,218.7}
