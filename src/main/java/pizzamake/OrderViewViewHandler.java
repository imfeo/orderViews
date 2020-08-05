package pizzamake;

import pizzamake.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderViewViewHandler {


    @Autowired
    private OrderViewRepository orderViewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1 (@Payload Ordered ordered) {
        try {
            if (ordered.isMe()) {
                // view 객체 생성
                OrderView orderView = new OrderView();
                // view 객체에 이벤트의 Value 를 set 함
                orderView.setId(ordered.getId());
                orderView.setOrderId(ordered.getId());
                orderView.setPizzaname(ordered.getPizzaname());
                orderView.setQty(ordered.getQty());
                orderView.setStatus(ordered.getStatus());
                // view 레파지 토리에 save
                orderViewRepository.save(orderView);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenMade_then_UPDATE_1(@Payload Made made) {
        try {
            if (made.isMe()) {
                // view 객체 조회
                Optional<OrderView> orderViewOptional = orderViewRepository.findById(made.getOrderId());
                if( orderViewOptional.isPresent()) {
                    OrderView orderView = orderViewOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderView.setStatus(made.getStatus());
                    // view 레파지 토리에 save
                    orderViewRepository.save(orderView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDelivered_then_UPDATE_2(@Payload Delivered delivered) {
        try {
            if (delivered.isMe()) {
                // view 객체 조회
                Optional<OrderView> orderViewOptional = orderViewRepository.findById(delivered.getOrderId());
                if( orderViewOptional.isPresent()) {
                    OrderView orderView = orderViewOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderView.setStatus(delivered.getStatus());
                    // view 레파지 토리에 save
                    orderViewRepository.save(orderView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_3(@Payload OrderCanceled orderCanceled) {
        try {
            if (orderCanceled.isMe()) {
                // view 객체 조회
                Optional<OrderView> orderViewOptional = orderViewRepository.findById(orderCanceled.getId());
                if( orderViewOptional.isPresent()) {
                    OrderView orderView = orderViewOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderView.setStatus(orderCanceled.getStatus());
                    // view 레파지 토리에 save
                    orderViewRepository.save(orderView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}