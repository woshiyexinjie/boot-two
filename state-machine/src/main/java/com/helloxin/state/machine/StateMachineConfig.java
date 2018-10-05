package com.helloxin.state.machine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.transition.Transition;

import java.util.EnumSet;


@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<OrderStatus, OrderEvents> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void configure(StateMachineStateConfigurer<OrderStatus, OrderEvents> states)
            throws Exception {
        states
            .withStates()
                .initial(OrderStatus.CREATED)
                .states(EnumSet.allOf(OrderStatus.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStatus, OrderEvents> transitions)
            throws Exception {
        transitions
            .withExternal()
                .source(OrderStatus.CREATED).target(OrderStatus.WAITING_FOR_RECEIVE)
                .event(OrderEvents.PAY)
                .and()
            .withExternal()
                .source(OrderStatus.WAITING_FOR_RECEIVE).target(OrderStatus.FINISHED)
                .event(OrderEvents.RECEIVE);
    }

//    @Override
//    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
//            throws Exception {
//        config
//            .withConfiguration()
//                .listener(listener());
//    }
//
//    @Bean
//    public StateMachineListener<States, Events> listener() {
//        return new StateMachineListenerAdapter<States, Events>() {
//
//            @Override
//            public void transition(Transition<States, Events> transition) {
//                if(transition.getTarget().getId() == States.CREATED) {
//                    logger.info("订单创建，待支付");
//                    return;
//                }
//
//                if(transition.getSource().getId() == States.CREATED
//                        && transition.getTarget().getId() == States.WAITING_FOR_RECEIVE) {
//                    logger.info("用户完成支付，待收货");
//                    return;
//                }
//
//                if(transition.getSource().getId() == States.WAITING_FOR_RECEIVE
//                        && transition.getTarget().getId() == States.FINISHED) {
//                    logger.info("用户已收货，订单完成");
//                    return;
//                }
//            }
//
//        };
//    }

}
