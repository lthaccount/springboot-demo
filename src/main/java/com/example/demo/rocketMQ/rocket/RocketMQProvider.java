package com.example.demo.rocketMQ.rocket;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class RocketMQProvider {
    private DefaultMQProducer producer;
    /**
     * 生产者组名
     */
    @Value("${apache.rocketmq.producer.producerGroup}")
    private String providerGroup;
    /**
     * name server 地址
     */
    @Value("${apache.rocketmq.namesrvAddr}")
    private String namesrvAddr;

    /**
     * 初始化消息生产者
     */
    @PostConstruct
    private void initProvider(){
        System.out.println("初始化消息生产者");
        System.out.println(providerGroup);
        producer = new DefaultMQProducer(providerGroup);
        producer.setNamesrvAddr(namesrvAddr);
        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public String produc(String msg, Integer orderno){
        if(producer == null){
            throw new IllegalStateException("The producer is not initialized!");
        }
        Message message = new Message("TopicTest", "TagTest", msg.getBytes());
        SendResult result = null;
        try {
//            //消息默认通过轮询所有队列来发送
//            producer.send(message);
            result = producer.send(message, new MessageQueueSelector() {
                /**
                 * 队列选择器
                 * 自定义选择方式
                 * @param list 消息队列集合
                 * @param message 消息体
                 * @param o 选择参数，此处为send()方法的orderno参数
                 * @return
                 */
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    //自定义选择方式：订单号取余队列总数相同的消息在同一队列中
                    Integer i = (Integer) o;
                    int index = i % list.size();
                    return list.get(index);
                }
            }, orderno);
        } catch (Exception e) {
            e.printStackTrace();
            return "send error";
        }
        return result.getSendStatus().name();
    }
}
