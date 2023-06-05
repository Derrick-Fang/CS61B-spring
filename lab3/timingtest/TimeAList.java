package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

import java.security.spec.AlgorithmParameterSpec;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        int degree = 20;
        int base = 1000;
        AList<Integer> L = new AList<Integer>();
        AList<Integer> Ns = new AList<Integer>();
        AList<Integer> opCounts = new AList<Integer>();
        AList<Double> times = new AList<Double>();
        for (int time = 1;time<200;time *= 2){
            Stopwatch sw = new Stopwatch();
            for(int i =0;i<time*base;i++){
                L.addLast(1);
            }
            double secondsPast = sw.elapsedTime();
            Ns.addLast(time*base);
            times.addLast(secondsPast);
            opCounts.addLast(time*base);
        }
        printTimingTable(Ns, times, opCounts);
    }
}
