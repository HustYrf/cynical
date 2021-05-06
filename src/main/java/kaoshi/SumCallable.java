package kaoshi;

import java.util.concurrent.Callable;

public class SumCallable implements Callable<Long> {
    private int[] numbers;
    private int start;
    private int end;


    public SumCallable(final int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }


    public Long call() throws Exception {
        Long sum = 0L;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
