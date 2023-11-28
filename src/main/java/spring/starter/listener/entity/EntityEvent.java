package spring.starter.listener.entity;

import org.springframework.context.ApplicationEvent;

public class EntityEvent extends ApplicationEvent {

    private final AccessType accessType;


    public EntityEvent(Object event,AccessType accessType) {
        super(event);
        this.accessType = accessType;
    }

    public AccessType getAccessType() {
        return accessType;
    }
}
