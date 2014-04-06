package stalk.net.ua.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-04-06T21:10:46.586+0300")
@StaticMetamodel(EventType.class)
public class EventType_ {
	public static volatile SingularAttribute<EventType, Integer> id;
	public static volatile SingularAttribute<EventType, String> name;
	public static volatile ListAttribute<EventType, Event> events;
}
