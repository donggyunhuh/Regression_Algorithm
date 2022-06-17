# Regression_Algorithm (회귀분석 알고리즘)

201901730 허동균

## 개요

최적화 알고리즘에 관한 레포트이다.

회귀 분석에 대한 이해 후 최적해를 전역 최적화 알고리즘 중 하나인 모의 담금질 알고리즘으로 구하는 과정에 관한 레포트이다.

내가 이해한 내용을 바탕으로최대한 회귀, 모의 담금질 알고리즘에 대해 누구나 이해할 수 있도록 설명하려 노력했다.

그래프, 그림자료는 직접 제작하려 노력했다.

## 목차

1. 회귀(Regression)의 의미

2. 회귀분석이란

   - 단순 선형 회귀분석

3. 회귀분석 모델 선정 및 데이터 조사

   - 회귀식 구하기

4. 최적화 알고리즘인 모의 담금질 알고리즘 이용

5. 회귀식 구한후 비교

## 회귀란?

회귀란 영어로 '**regression**' 이고, 사전적으로 '**go back to an earlier and worse condition**' 이라는 의미를 가진다.

이는 '초기의 대표적인 상태로 돌아가려는 경향을 가진다' 로 번역된다.

한 예로, 대한민국 평균키는 2022년 기준 남성은 172.5cm, 여성은 159.6cm이다.

이때, 임의의 대한민국 남성과 여성이 결혼하여 자녀를 낳고, 그 자녀의 키를 조사한다고 가정한다.

임의의 대한민국 남성, 여성이므로 다양한 키의 부부 조합이 탄생할 것이다.

세대를 거듭하여 이 과정을 반복하면 돌연변이(부모의 키보다 작거나 큰경우)가 발생하여도 자손들의 평균 키 조사결과 는 결국 위에서 언급한 대한민국 남녀 평균키로 수렴할 것이다.

이것이 회귀의 기본적 분석이라고 할 수 있다.

이번 기말 대체 레포트에서 다룰 내용은 다양한 회귀분석 기법중 **'유전 알고리즘'** 을 이용한 회귀분석이다.

밑에서 다룰 내용은 회귀 분석 중 **'단순선형 회귀분석'** 이다.

## 회귀분석

단순선형 회귀분석이란 두 변수, 즉 하나의 독립변수($x$)와 하나의 종속변수($y$) 사이의 관계를 알아내는 것이다.

여기에서, $x$와 $y$의 관계식을 구할 수 있다. 이를 *회귀식*이라고 하며, $$y = ax + b$$ 꼴로 나타낼 수 있고 선형적으로 표현된다.

단순선형 회귀분석의 궁극적 목표는 위 회귀식을 찾아내는 것이다.

예를 들어, 일정 크기의 밀폐된 공간에서 사람수에 따라 코로나19 확진자 수의 대한 자료가 있다고 가정해보자.

이 예시에서, 독립변수($x$)는 사람의 수, 종속변수 ($y$)는 코로나19 확진자 수이다.

각각의 사람은 면역력 차이가 있어 코로나19 확진자 수는 항상은 같지 않을 것이다.

임의로 사람수에 따른 확진자 수를 정하고 데이터로 표현하여 산점도로 나타내보면 밑의 그림과 같다. (_'사람수가 증가할수록 코로나19 확진자 수도 증가한다'는 사실에 기반_)

이를 정리해보면, 데이터 분포의 추세를 직선 그래프꼴로 나타냈을때, 실제 데이터 값과 회귀값(_평균값_)의 차이를 최소화시킬 수 있는 식이 구하는 회귀식인 것이다.

<p align="center"><img src="https://github.com/donggyunhuh/Regression_Algorithm/blob/main/example%201.jpg?raw=true" height="300px" width="500px"></p>
<br/>

> 실제 데이터 값과 회귀값의 차이를 '_에러값_'이라 정하면, 에러값이 최소가 될때 회귀식은 데이터 분포가 몰린 부분을 지나는 직선의 형태로 나타난다.

이 레포트에서는 $a$값, 즉 에러값이 최소일때 최적해(_회귀식의 기울기_)를 찾는 것을 목적으로 한다.

## 회귀분석 모델 선정 및 데이터 조사

### 키에 따른 한국 여성의 발 크기

_출처 : 8차 인체치수조사 (2020~21), 사이즈코리아_

> 독립변수 : **키**

> 종속변수 : **발 사이즈**

<p align="center"><img src="https://github.com/donggyunhuh/Regression_Algorithm/blob/main/graphFirst.png?raw=true" height="400px" width="550px"></p>
<br/>

위 그래프는 엑셀을 이용하여 데이터의 분포를 나타낸 것이다.

무작위로 선정된 여성 26명의 데이터이다.

키가 커질수록 발 크기도 종속적으로 증가하는 추세를 보이고 있다.

위 데이터 분포를 회귀식으로 표현해보자.

엑셀의 회귀 분석 기능으로 위 데이터에 회귀식을 나타내면

<p align="center"><img src="https://github.com/donggyunhuh/Regression_Algorithm/blob/main/graphRegr.png?raw=true" height="350px" width="520px"></p>
<br/>

회귀식은 $y = 0.1595x - 25.768$ 으로 구해진다.

이때, 결정계수는 $0.5752$ 이므로 정확성은 낮은 편이다.

아래는 엑셀로 회귀 데이터분석을 실행한 결과이다.

<p align="center"><img src="https://github.com/donggyunhuh/Regression_Algorithm/blob/main/RegressionAnalysis.png?raw=true" height="400px" width="700px"></p>

이 레포트에서는 위 회귀식을 찾아내기 위해 최적화 알고리즘 '**모의 담금질 알고리즘**' 을 사용한다.

위 데이터를 {}좌표 형태로 나타내보면

```
{1657, 229.2}, {1672, 249.1}, {1578, 233.2}, {1573, 226.4}, {1648, 233.8}, {1591, 234.5}, {1681, 249.4}, {1550, 218.9}, {1630, 249.6},
{1619, 234.5}, {1524, 217.6}, {1631, 238.5}, {1630, 235.3}, {1654, 242.2}, {1580, 231.4}, {1602, 228.1}, {1625, 225.8}, {1664, 237.9},
{1591, 216.7}, {1670, 246.5}, {1653, 239.9}, {1665, 238.2}, {1616, 219.4}, {1659, 236.4}, {1583, 218.7}, {1758, 247.9}
```

### 회귀식 구하기(추가설명)

- 회귀식을 구하는 방법

  회귀선을 구하기 위해 회귀선을 $y=ax+b$, $y=f(x)$ 라고 가정한다.  
   구한 데이터 값 중에서 임의로 한 데이터 값을 좌표의 형태로 나타낸다.  
   예를 들어, 아래 그래프에서 $(1657,229.2)$ 점과 회귀선 $f(x)=ax+b$ 사이의 거리는 $f(1650) - 229.2$ 이다. 이를 통계학 용어로 잔차라 한다.  
   즉, 잔차는 위에서 언급한 _에러값_ 이며 _에러값_ 이 최소라는 뜻은 잔차의 합이 가장 적은 경우임을 이용하여 회귀식 $y=ax+b$를 구한다.  
   그러나, 잔차는 항상 양$(+)$의 부호를 가져야 하므로 **잔차의 제곱의 합** 이 최소인 경우를 알고리즘에 적용해야 한다.

    <p align="center"><img src="https://github.com/donggyunhuh/Regression_Algorithm/blob/main/graph2nd.png?raw=true" height="400px" width="550px"></p>
  <br/>

# 모의 담금질 알고리즘(Simulated Annealing, SA)

- 모의 담금질 알고리즘은 전역 최적화 문제에 대한 일반적인 확률 알고리즘이다.

  쉽게 말하면 해를 반복하여 개선하는 알고리즘이다.

  이에 대해 설명해보자.

  금속이 액체의 형태를 띄고 있다는 것은 분자의 활동이 활발한 아주 뜨거운 상태란 것을 의미한다.

  이때 분자는 정해진 패턴없이 사방으로 진동하며 시간이 지나 온도가 낮아지면 액체에서 고체로 고착화된다.

  이러한 과정을 모방해서 알고리즘을 만든 것이다.

  아래는 인터넷이나 교재에서 흔히 찾아볼 수 있는 모의 담금질 알고리즘에 대한 의사코드이다.

```java
  begin
Get an initial solution S; //  초기값을 설정
Get an initial temperature T>0; // 초기 온도값을 설정
while not yet "frozen" do  // 온도가 0이 될때까지 반복, 최적해찾을

   for 1<= i <= P do       // P=nk 즉  STEP사이즈를 결정

   Pick a random neighbor S' of S; // 임의의 솔루션 S' 과 기존의 솔루션 S를 선택

   ? ← cost(S')-cost(S); // S'와 S의 값의 차 계산

   if ? <= 0 then S ← S' // S'의 값이 작으면 최적화된것, 온도가 내려감

   if ? > 0 then S ← S' // S'의 값이 크면 최적화 x, 온도가 올라감

T ← rT; // 다음 반복 수행
return S    // 최적화된 해 찾기 완료
end
```

즉, 경우의 수를 높여서 더 안좋은 결과가 나오는 것을 온도의 상승으로 보고, 경우의 수의 조합을 좋게 해서 온도의 하락으로 보고 설명을 하는 것이다.

- 위 순서로 모의 담금질 알고리즘이 진행된다.

gif 이미지 파일로 표현하면 다음과 같다.

<br/>

![모의담금질진행과정](https://upload.wikimedia.org/wikipedia/commons/d/d5/Hill_Climbing_with_Simulated_Annealing.gif)

출처 : wikimedia

# 모의 담금질 알고리즘 적용

### 1. fit 메소드, isNeighborBetter 메소드

```java
public interface Problem {
    double fit(double x); // 적합도를 판별하는 fit 메소드

    boolean isNeighborBetter(double f0, double f1); //이웃해, 현재해 비교
}
```

### 2. import 값 설정

```java
import java.util.ArrayList;
import java.util.Random;
```

Random, ArrayList 라이브러리 패키지 import

### 3. SA구현

1. 배열 선언, solve 메소드 선언

```java
public class SimulatedAnnealing {
    private int count; // 반복수
    public ArrayList<Double> hist; //hist 배열 선언

    public SimulatedAnnealing(int count) {
        this.count = count;
        hist = new ArrayList<>();
    }

    public double solve(Problem p, double t, double a, double lower, double upper) {
      // solve 메소드 선언
        Random r = new Random(); // r에 랜덤 인수넣기
        double x0 = r.nextDouble() * (upper - lower) + lower; //
        return solve(p, t, a, x0, lower, upper);
    }
```

- 최적해 도달하기 까지 적합도값을 hist 배열을 선언한 후 저장한다
- 만약 solve메소드에 초기 후보해를 인수로 전달해 주지 않을 경우, 임의로 지정한 후 초기 후보해를 넣어 오버로딩한 solve메소드를 호출한다.

2. solve 메소드 구현, isNeighborBetter 메소드 구현

```java
public double solve(Problem p, double t, double a, double x0, double lower, double upper) {
        Random r = new Random();
        double f0 = p.fit(x0);
        hist.add(f0);
        if (a >= 1) {
            a = 0.99;
        } //T는 갈수록 0에 가까워져야하므로 냉각률이 1이상일 경우 0.99로 설정해준다.
        for (int i = 0; i < count; i++) {
            int kt = (int) t; //온도 t에서의 for루프 반복 횟수 kt
            for (int j = 0; j < kt; j++) {
                double x1 = r.nextDouble() * (upper - lower) + lower; //이웃해 선택
                double f1 = p.fit(x1);

                if (p.isNeighborBetter(f0, f1)) {
                    x0 = x1;
                    f0 = f1; //이웃해의 적합도> 현재해의 적합도 -> 이웃해 선택
                    hist.add(f0);
                } else { //현재해의 적합도 > 이웃해의 적합도
                    double d = Math.abs(f1 - f0);
                    double p0 = Math.exp(-d / t);
                    if (r.nextDouble() < p0) { //좋지 않은 이웃해를 선택할 확률인 p0는 t(온도)에 반비례하고 d(현재 후보해와 이웃해의 차이)와 비례
                        x0 = x1;
                        f0 = f1; //현재 후보해의 적합도가 더 높더라도 자유롭게 탐색할 확률에 따라 좋지 않은 이웃해를 선택
                        hist.add(f0);
                    }
                }
            }
            t *= a;
        }
        return x0;
    }
}
```

3. 선형 모델 데이터의 가장 적합한 파라미터를 찾기 위한 main 구현

```java
public class Main {
    public static void main(String[] args) {
        SimulatedAnnealing sa = new SimulatedAnnealing(1000);
        int[][] data = {{1657, 229.2}, {1672, 249.1}, {1578, 233.2}, {1573, 226.4}, {1648, 233.8}, {1591, 234.5}, {1681, 249.4}, {1550, 218.9}, {1630, 249.6}, {1619, 234.5}, {1524, 217.6}, {1631, 238.5}, {1630, 235.3}, {1654, 242.2}, {1580, 231.4}, {1602, 228.1}, {1625, 225.8}, {1664, 237.9}, {1591, 216.7}, {1670, 246.5}, {1653, 239.9}, {1665, 238.2}, {1616, 219.4}, {1659, 236.4}, {1583, 218.7}, {1758, 247.9}};

        Problem p1 = new Problem() {
            @Override
            public double fit(double x) {
                double sum = 0;
                for (int i = 0; i < data.length; i++) {
                    int xv = data[i][0];
                    sum += Math.pow(x * xv - data[i][1], 2);
                }
                return sum / data.length;
            }

            @Override
            public boolean isNeighborBetter(double f0, double f1) {
                return f0 > f1;
            } //작은값선택
        };
        double a = sa.solve(p1, 100, 0.99, 2000, 0, 5000);
        System.out.println("\ny=ax 선형 모델에 가장 적합한 파라미터");
        System.out.println("a : " + a);
        System.out.println("데이터와의 차이값 : " + p1.fit(a));

        Problem p2 = new Problem() {
            @Override
            public double fit(double x) {
                double sum = 0;
                for (int i = 0; i < data.length; i++) {
                    int xv = data[i][0];
                    sum += Math.pow((a * xv + x) - data[i][1], 2);
                }
                return sum / data.length;
            }

            @Override
            public boolean isNeighborBetter(double f0, double f1) {
                return f0 > f1;
            } //작은값선택
        };
        double b = sa.solve(p2, 100, 0.99, 2000, 0, 5000);
        System.out.println("\ny=ax+b 선형 모델에 가장 적합한 파라미터");
        System.out.println("a : " + a);
        System.out.println("b : " + b);
        System.out.println("데이터와의 차이값 : " + p2.fit(b));
    }
}
```

# 알고리즘 수행결과

<p align="center"><img src="https://github.com/donggyunhuh/Regression_Algorithm/blob/main/result.png?raw=true" height="300px" width="500px"></p>
<br/>

- 알고리즘에서 구한 값은 $0.4950$으로
