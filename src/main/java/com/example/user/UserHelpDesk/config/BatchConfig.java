//package com.example.user.UserHelpDesk.config;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableBatchProcessing
//public class BatchConfig {
//
//    @Autowired
//    public  JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    public StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public Job job(Step step1) {
//        return jobBuilderFactory.get("sampleJob")
//                .start(step1)
//                .build();
//    }
//
//    @Bean
//    public Step step1(ItemReader<String> reader,
//                      ItemProcessor<String, String> processor,
//                      ItemWriter<String> writer) {
//        return stepBuilderFactory.get("step1")
//                .<String, String>chunk(2)
//                .reader(reader)
//                .processor(processor)
//                .writer(writer)
//                .build();
//    }
//}
//
