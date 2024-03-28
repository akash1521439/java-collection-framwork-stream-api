import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedHashMapEx {
    public static void main(String[] args) throws InterruptedException {
        Map<String,Integer> rating = new ConcurrentHashMap<>();
        rating.put("Friends", 8);
        rating.put("Game",10);
        rating.put("Money",4);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable task = ()->{
            incrementRating(rating,"Money");
        };
        for (int i=0;i<5;i++){
            executorService.submit(task);
        }
        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("Final Rating "+rating.get("Money"));
    }
    private static void incrementRating(Map<String,Integer> rp,String webSeries){
        synchronized (rp){
            Integer rating = rp.get(webSeries);
            rp.put(webSeries,rating+1);
        }
    }
}
