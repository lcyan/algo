package cn.vvspace.algo.tree;

import java.util.stream.IntStream;

/**
 * <a href="">斐波那契数列</a>
 */
public class SolutionFb {

    public static void main(String[] args) {
        SolutionFb solutionFb = new SolutionFb();
        IntStream.range(1, 10).forEach(n -> System.out.printf("%d ", solutionFb.fb(n)));
    }

    // 1、1、2、3、5、8、13、21
    private int fb(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fb(n - 1) + fb(n - 2);
    }
}
