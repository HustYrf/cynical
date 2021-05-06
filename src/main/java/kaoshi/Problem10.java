package kaoshi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class Problem10 {



    private ExecutorService exec;
    private int cpuCoreNumber;
    private List<Future<Long>> tasks = new ArrayList<Future<Long>>();


    public Problem10() {
        cpuCoreNumber = Runtime.getRuntime().availableProcessors();
        exec = Executors.newFixedThreadPool(cpuCoreNumber);
    }


    /**
     * 向指定URL发送GET方式的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数
     * @return URL 代表远程资源的响应
     */
    public static String sendGet(String url, String param) {
        String result = "";
        String urlName = url + param;
        try {
            URL realUrl = new URL(urlName);
            //打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            //建立实际的连接
            conn.connect();
            //获取所有的响应头字段
            Map<String, List<String>> map = conn.getHeaderFields();
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常" + e);
            e.printStackTrace();
        }
        return result;
    }


    public Long sum(final int[] numbers) {
        // 依据CPU核心个数拆分任务，创建FutureTask并提交到Executor
        for (int i = 0; i < cpuCoreNumber; i++) {
            int increment = numbers.length / cpuCoreNumber + 1;
            int start = increment * i;
            int end = increment * i + increment;
            if (end > numbers.length)
                end = numbers.length;
            SumCallable subCalc = new SumCallable(numbers, start, end);
            FutureTask<Long> task = new FutureTask<Long>(subCalc);
            tasks.add(task);
            if (!exec.isShutdown()) {
                exec.submit(task);
            }
        }
        return getResult();
    }

    /**
     * 迭代每一个仅仅任务，获得部分和。相加返回
     */
    public Long getResult() {
        Long result = 0l;
        for (Future<Long> task : tasks) {
            try {
                // 假设计算未完毕则堵塞
                Long subSum = task.get();
                result += subSum;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    public void close() {
        exec.shutdown();
    }




    public static void main(String[] args) throws Exception {
        //发送GET请求
        //String s = Problem10.sendGet("https://pic20a-api-server.vercel.app/api?key=", "1");
        //System.out.println(s);

        int[] numbers = {34,26,100,0,4};
        int[] result = new int[numbers.length];
        for(int i=1;i<=numbers.length;i++){
            String resultStr = sendGet("https://pic20a-api-server.vercel.app/api?key=", String.valueOf(numbers[i-1]));
            result[i-1] = Integer.valueOf(resultStr);
        }
        Problem10 problem10 = new Problem10();
        Long sum = problem10.sum(result);
        System.out.println(sum);
    }

}
