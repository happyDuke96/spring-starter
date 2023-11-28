package spring.starter.listener.entity;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EntityEventListener {

    @EventListener(condition = "#root.args[0].getAccessType().name() == 'DELETE'")
    public void acceptEntityEventOnyRead(EntityEvent event){
        System.out.println("Event: " + event);
    }
}
