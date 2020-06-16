package com.example.delayqueue;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.concurrent.*;

/*DelayQueue is an implementation of BlockingQueue where element can be taken out when its delay is expired.*/
@SpringBootApplication
public class DelayQueueApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelayQueueApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			System.out.println("Application started..");
			BlockingQueue<DelayObject> queue = new DelayQueue<>();
			Producer producer = new Producer(queue);
			Consumer consumer = new Consumer(queue);

			ExecutorService ex = Executors.newFixedThreadPool(2);
			ex.execute(producer);
			ex.execute(consumer);

			ex.shutdown();
			System.out.println("Completed.");
		};
	}

	static class Producer implements Runnable {

		private BlockingQueue<DelayObject> queue;
		int count = 0;
		long delayInMilliseconds = 2000;

		public Producer(BlockingQueue<DelayObject> queue){
			this.queue = queue;
		}

		@Override
		public void run() {
			for(int i=0;i<10;i++){
				try {
					System.out.println("Inserting element");
					queue.put(new DelayObject(++count, delayInMilliseconds));
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static class Consumer implements Runnable{

		private BlockingQueue<DelayObject> queue;

		public Consumer(BlockingQueue<DelayObject> queue){
			this.queue = queue;
		}

		@Override
		public void run() {
			while(true){
				try {
					if(!queue.isEmpty()){
						DelayObject delayObject = queue.take();
						System.out.println(delayObject);
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
