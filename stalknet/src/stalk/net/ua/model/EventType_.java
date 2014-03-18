package stalk.net.ua.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-03-18T23:26:15.294+0200")
@StaticMetamodel(EventType.class)
public class EventType_ {
	public static volatile SingularAttribute<EventType, Integer> id;
	public static volatile SingularAttribute<EventType, String> name;
	public static volatile ListAttribute<EventType, Event> events;
}
