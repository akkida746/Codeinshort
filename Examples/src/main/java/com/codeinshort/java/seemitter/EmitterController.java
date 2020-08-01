package com.codeinshort.java.seemitter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class EmitterController {

    @GetMapping("/getdata")
    public SseEmitter getData(){

        System.out.println("Inside getdate()");
        SseEmitter emitter = new SseEmitter();
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() -> {
            for(int i=0;i<10;i++){
                try {
                    System.out.println("Emitting message.. " + i);
                    emitter.send(new Integer(i));
                    Thread.sleep(1000);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
            emitter.complete();
            service.shutdown();
        });

        return emitter;
    }
}
