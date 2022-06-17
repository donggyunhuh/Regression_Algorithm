import java.util.ArrayList;
import java.util.Random;

public class SimulatedAnnealing {
    private int count;
    public ArrayList<Double> hist;

    public SimulatedAnnealing(int count) {
        this.count = count;
        hist = new ArrayList<>();
    }

    public double solve(Problem p, double t, double a, double lower, double upper) {
        Random r = new Random();
        double x0 = r.nextDouble() * (upper - lower) + lower;
        return solve(p, t, a, x0, lower, upper);
    }

    public double solve(Problem p, double t, double a, double x0, double lower, double upper) {
        Random r = new Random();
        double f0 = p.fit(x0);
        hist.add(f0);
        if (a >= 1) {
            a = 0.99;
        }
        for (int i = 0; i < count; i++) {
            int kt = (int) t; // ¹Ýº¹È½¼ö kt
            for (int j = 0; j < kt; j++) {
                double x1 = r.nextDouble() * (upper - lower) + lower; // ÀÌ¿ôÇØ ¼±ÅÃ

                double f1 = p.fit(x1);

                if (p.isNeighborBetter(f0, f1)) {
                    x0 = x1;
                    f0 = f1;
                    hist.add(f0);
                } else {
                    double d = Math.abs(f1 - f0);
                    double p0 = Math.exp(-d / t);
                    if (r.nextDouble() < p0) {
                        x0 = x1;
                        f0 = f1;
                        hist.add(f0);
                    }
                }
            }
            t *= a;
        }
        return x0;
    }
}