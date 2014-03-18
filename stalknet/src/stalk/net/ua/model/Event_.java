package stalk.net.ua.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-03-18T23:26:37.098+0200")
@StaticMetamodel(Event.class)
public class Event_ {
	public static volatile SingularAttribute<Event, Integer> id;
	public static volatile SingularAttribute<Event, Date> dateEnd;
	public static volatile SingularAttribute<Event, Date> dateStart;
	public static volatile SingularAttribute<Event, String> description;
	public static volatile SingularAttribute<Event, String> name;
	public static volatile SingularAttribute<Event, EventType> eventType;
}
