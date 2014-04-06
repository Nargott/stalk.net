package stalk.net.ua.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-04-06T21:14:02.582+0300")
@StaticMetamodel(Event.class)
public class Event_ {
	public static volatile SingularAttribute<Event, Integer> id;
	public static volatile SingularAttribute<Event, Date> dateEnd;
	public static volatile SingularAttribute<Event, Date> dateStart;
	public static volatile SingularAttribute<Event, String> name;
	public static volatile SingularAttribute<Event, EventType> eventType;
	public static volatile ListAttribute<Event, Quest> quests;
	public static volatile ListAttribute<Event, Stalker> stalkers;
}
