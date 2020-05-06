package com.learncamel.routes;

import com.learncamel.routes.kafka.KafkaConsumerRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class KafkaConsumerRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new KafkaConsumerRoute();
    }

    @Test
    public void readMessageFromKafka(){
        String expected="123";
        String response = consumer.receiveBody("direct:fromKafka", String.class);
        System.out.println("The response is:" + response);
        assertEquals(expected, response);
    }
}
