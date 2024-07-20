package com.example.notificationservice.config;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;

import java.util.Properties;

@Configuration
public class KafkaStreamsConfig {

    private static final Logger logger = LoggerFactory.getLogger(KafkaStreamsConfig.class);

    @Bean
    public StreamsBuilder streamsBuilder() {
        return new StreamsBuilder();
    }

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public StreamsConfig kStreamsConfig() {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "notification-service");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.Double().getClass());
        return new StreamsConfig(props);
    }

   /*
    @Bean
    public KafkaStreams kafkaStreams(StreamsBuilder builder) {
        KStream<String, Double> balances = builder.stream("balances");

        balances.filter((key, value) -> value < 100.0)
                .foreach((key, value) -> {
                    System.out.printf("User with account Id : %s has a low balance of %.2f\n", key, value);
                    logger.info("User with account Id : %s has a low balance of %.2f\n", key, value);
                    // Notify user logic here
                });

        return new KafkaStreams(builder.build(), kStreamsConfig());
    } 
    */
}

