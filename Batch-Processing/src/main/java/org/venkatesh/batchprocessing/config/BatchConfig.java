package org.venkatesh.batchprocessing.config;


import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.batch.infrastructure.item.data.RepositoryItemWriter;
import org.springframework.batch.infrastructure.item.file.FlatFileItemReader;
import org.springframework.batch.infrastructure.item.file.LineMapper;
import org.springframework.batch.infrastructure.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.infrastructure.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.infrastructure.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.infrastructure.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;
import org.venkatesh.batchprocessing.model.Customer;
import org.venkatesh.batchprocessing.repo.CustomerRepository;

@Configuration
public class BatchConfig {

    private final CustomerRepository repository;
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    public BatchConfig(CustomerRepository repository, JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        this.repository = repository;
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
    }

    // ItemReader
    @Bean
    public FlatFileItemReader<Customer> itemReader() {
        return new FlatFileItemReaderBuilder<Customer>()
                .name("customerItemReader")
                .resource(new FileSystemResource("src/main/resources/customer_data.csv"))
                .linesToSkip(1)
                .lineMapper(lineMapper())
                .build();

    }

    private LineMapper<Customer> lineMapper() {
        DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(",");
        tokenizer.setStrict(false);
        tokenizer.setNames("customerId", "firstName", "lastName", "email", "phone", "city", "state", "zipcode", "country");
        BeanWrapperFieldSetMapper<Customer> beanWrapper = new BeanWrapperFieldSetMapper<>();
        beanWrapper.setTargetType(Customer.class);

        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(beanWrapper);

        return lineMapper;
    }

    // ItemProcessor
    @Bean
    public ItemProcessor<Customer, Customer> customerProcessor() {
        return new CustomerProcesser();
    }

    // ItemWriter
    @Bean
    public RepositoryItemWriter<Customer> itemWriter() {
       return new RepositoryItemWriter<>(repository);
    }

    // Step
    @Bean
    public Step step1() {
        return new StepBuilder("step-1", jobRepository)
                .<Customer, Customer>chunk(10)
                .transactionManager(transactionManager)
                .reader(itemReader())
                .processor(customerProcessor())
                .writer(itemWriter()).build();
    }


    // Job
    @Bean
    public Job importCustomerJob() {
        return new JobBuilder("importCustomerJob", jobRepository).start(step1()).build();
    }
}
