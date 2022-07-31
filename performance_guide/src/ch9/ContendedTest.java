package ch9;

public class ContendedTest extends Thread {
    public ContendedTest(Runnable r) {
        super(r);
    }

    private static class DataHolder {
        private volatile long l1 = 0;
        private volatile long l2 = 0;
        private volatile long l3 = 0;
    }

    private static DataHolder dh = new DataHolder();

    public static void main(String[] args) throws Exception {
        long nLoops = 1000000L;
        ContendedTest[] tests = new ContendedTest[3];
        tests[0] = new ContendedTest(() -> {
            for (long i = 0; i < nLoops; i++) {
                dh.l1 += i;
            }
        });
        tests[1] = new ContendedTest(() -> {
            for (long i = 0; i < nLoops; i++) {
                dh.l2 += i;
            }
        });
        tests[2] = new ContendedTest(() -> {
            for (long i = 0; i < nLoops; i++) {
                dh.l3 += i;
            }
        });
        long then = System.currentTimeMillis();
        for (ContendedTest ct : tests) {
            ct.start();
        }
        for (ContendedTest ct : tests) {
            ct.join();
        }
        System.out.println("Duration: " + (System.currentTimeMillis() - then) + "ms");
    }
}
