package emlakburada.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;


public class ActiveMqConfig {

    @Value("${myqueue}")
    private String myQueue;
    @Value("${mytopic}")
    private String myTopic;

    public Queue queue(){
        return new ActiveMQQueue(myQueue);
    }

    public Topic topic(){
        return new ActiveMQTopic(myTopic);
    }

}