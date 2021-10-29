package pl.akolata.config;

import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class RabbitMqConfig {

    @Bean
    public Declarables declarables() {
        Queue classicQueue = new Queue("q.classic-demo", false, false, false, Map.of(
                "x-queue-mode", "lazy"
        ));
        Queue quorumQueue = new Queue("q.quorum-demo", true, false, false, Map.of(
                "x-queue-type", "quorum"
        ));
        Queue streamQueue = new Queue("q.stream-demo", true, false, false, Map.of(
                "x-queue-type", "stream"
        ));
        return new Declarables(
                classicQueue,
                quorumQueue,
                streamQueue
        );
    }

}
