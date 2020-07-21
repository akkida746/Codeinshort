package com.codeinshort.rsocketclient.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Data
@NoArgsConstructor
public class Message {

    private String user;
    private String msg;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;

    public Message(String user, String msg){
        this.user = user;
        this.msg = msg;
        this.date = getRandomDate();
    }

    private LocalDate getRandomDate(){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return LocalDate.of(random.nextInt(2000, 2020), random.nextInt(1, 13), random.nextInt(1, 29));
    }
}
