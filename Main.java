public class Main {
    public static void main(String[] args) {
        SimulatedAnnealing sa = new SimulatedAnnealing(1000);
        int[][] data = {};

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
            } // ����������
        };
        double a = sa.solve(p1, 100, 0.99, 2000, 0, 5000);
        System.out.println("\ny=ax ���� �𵨿� ���� ������ �Ķ����");
        System.out.println("a : " + a);
        System.out.println("�����Ϳ��� ���̰� : " + p1.fit(a));

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
            } // ����������
        };
        double b = sa.solve(p2, 100, 0.99, 2000, 0, 5000);
        System.out.println("\ny=ax+b ���� �𵨿� ���� ������ �Ķ����");
        System.out.println("a : " + a);
        System.out.println("b : " + b);
        System.out.println("�����Ϳ��� ���̰� : " + p2.fit(b));
    }
}