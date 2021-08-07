package com.github.shoothzj.demo.kafka;

import com.github.shoothzj.javatool.util.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.security.auth.SecurityProtocol;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Test;

import java.util.Properties;

/**
 * @author hezhangjian
 */
@Slf4j
public class KafkaProducerSaslTlsTest {

    @Test
    public void kafkaProducerSasl() {
        LogUtil.configureLog();
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConst.BROKERS);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.ACKS_CONFIG, "1");
        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, "500");

        props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, SecurityProtocol.SASL_SSL.name);
        // sasl 信息
        props.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
        String saslJaasConfig = String.format("org.apache.kafka.common.security.plain.PlainLoginModule required \nusername=\"%s\" \npassword=\"%s\";", "alice", "pwd");
        props.put(SaslConfigs.SASL_JAAS_CONFIG, saslJaasConfig);
        // ssl 信息
        props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, "/path/to/truststore");
        props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, "hzj");

        final KafkaProducer<String, String> producer = new KafkaProducer<>(props);

    }

}
