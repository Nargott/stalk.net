package stalk.net.ua.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-03-18T00:00:06.652+0200")
@StaticMetamodel(Event.class)
public class Event_ {
	public static volatile SingularAttribute<Event, Integer> id;
	public static volatile SingularAttribute<Event, String> description;
	public static volatile SingularAttribute<Event, String> name;
	public static volatile SingularAttribute<Event, EventType> eventType;
	public static volatile ListAttribute<Event, Quest> quests;
	public static volatile ListAttribute<Event, Stalker> stalkers;
}
