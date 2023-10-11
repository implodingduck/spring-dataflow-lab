package com.implodingduck.batch.demo;


import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.data.domain.Sort.Direction;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class BatchConfiguration {

    @Bean
    public RepositoryItemReader<Sumandproduct> reader(SumandproductRepository repository) {
        Map<String, Direction> sortsMap = new HashMap<>();
		sortsMap.put("id", Direction.DESC);
        return new RepositoryItemReaderBuilder<Sumandproduct>()
             .repository(repository)
             .methodName("findAllNullSum")
             .sorts(sortsMap)
             .saveState(false)
             .build();
    }

    @Bean
    public SumandproductItemProcessor processor() {
        return new SumandproductItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Sumandproduct> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Sumandproduct>()
            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
            .sql("UPDATE sumandproduct SET sum=(:sum) WHERE id=(:id)")
            .dataSource(dataSource)
            .build();
    }

    @Bean
    public Job importDataJob(JobRepository jobRepository,
        JobCompletionNotificationListener listener, Step step1) {
        return new JobBuilder("importDataJob", jobRepository)
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end()
            .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository,
        PlatformTransactionManager transactionManager,  RepositoryItemReader<Sumandproduct> reader, JdbcBatchItemWriter<Sumandproduct> writer) {
        return new StepBuilder("step1", jobRepository)
            .<Sumandproduct, Sumandproduct> chunk(10, transactionManager)
            .reader(reader)
            .processor(processor())
            .writer(writer)
            .build();
    }
}