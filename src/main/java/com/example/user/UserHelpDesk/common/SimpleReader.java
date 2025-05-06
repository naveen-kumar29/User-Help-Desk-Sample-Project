package com.example.user.UserHelpDesk.common;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SimpleReader implements ItemReader<String> {
    private List<String> data = Arrays.asList("one", "two", "three");
    private int index = 0;

    @Override
    public String read() throws Exception {
        if (index < data.size()) {
            return data.get(index++);
        } else {
            return null;
        }
    }
}

@Component
 class SimpleProcessor implements ItemProcessor<String, String> {
    @Override
    public String process(String item) {
        return item.toUpperCase();
    }
}

@Component
class SimpleWriter implements ItemWriter<String> {
    @Override
    public void write(Chunk<? extends String> items) throws Exception {
        items.forEach(System.out::println);
    }
}


