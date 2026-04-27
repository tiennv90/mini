package com.mini.order.infrastructure.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;

/**
 * Implementation of Kafka producer with exactly-once delivery semantics. Uses
 * transactional messaging to ensure messages are delivered exactly once.
 *
 * @param <K> The type of the key
 * @param <V> The type of the value
 */
public class ExactlyOnceProducer<K, V> extends AbstractKafkaProducer<K, V> {
	private static final Logger logger = LoggerFactory.getLogger(ExactlyOnceProducer.class);

	/**
	 * Constructs a new ExactlyOnceProducer.
	 *
	 * @param kafkaTemplate The KafkaTemplate to use for sending messages
	 * @param topic         The topic to send messages to
	 */
	public ExactlyOnceProducer(KafkaTemplate<K, V> kafkaTemplate, String topic) {
		super(kafkaTemplate, topic);
		kafkaTemplate.setTransactionIdPrefix("txn-");
	}

	public CompletableFuture<SendResult<K, V>> send(V message) {
		return kafkaTemplate.executeInTransaction(_ -> super.send(message).whenComplete((result, ex) -> {
			if (ex != null) {
				logger.error("Failed to send message in transaction", ex);
			} else {
				logger.debug("Message sent successfully in transaction: {}", result.getProducerRecord().value());
			}
		}));
	}

	@Override
	public CompletableFuture<SendResult<K, V>> send(K key, V message) {
		
		return kafkaTemplate.executeInTransaction(_ -> super.send(key, message).whenComplete((result, ex) -> {
			if (ex != null) {
				logger.error("Failed to send message in transaction", ex);
			} else {
				logger.debug("Message sent successfully in transaction: {}", result.getProducerRecord().value());
			}
		}));
		
	}
}
