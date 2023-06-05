package liteweb;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RequestPool {
    private ExecutorService executorService;
    public RequestPool(int maxPoolSize, int queueSize){
        executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),maxPoolSize,120L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize));
    }
    public void execute(Runnable task){
        executorService.execute(task);
    }
}
