package com.example.demo.rocketMQ.rocket;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class RocketMQConsumer{
    private DefaultMQPushConsumer consumer;

    /**
     * 消费者组名
     */
    @Value("${apache.rocketmq.consumer.PushConsumer}")
    private String consumerGroup;
    /**
     * name server 地址
     */
    @Value("${apache.rocketmq.namesrvAddr}")
    private String namesrvAddr;

    /**
     * 初始化消息消费者并开启消费线程
     */
    @PostConstruct
    private void initConsumer(){
        consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr(namesrvAddr);
        try {
            consumer.subscribe("TopicTest", "TagTest");
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                    try {
                        for(MessageExt messageExt : list){
                            System.out.println("消费者线程：" + Thread.currentThread().getName());
                            System.out.println("messageExt:" + messageExt);
                            System.out.println("消息内容：" + new String(messageExt.getBody()));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        return ConsumeConcurrentlyStatus.RECONSUME_LATER;   //消费异常  稍后再试
                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;    //消费成功
                }
            });
            System.out.println("开启消费者线程：" + Thread.currentThread().getName());
            consumer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
