package ua.stalknet.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-06-24T22:48:54.989+0300")
@StaticMetamodel(Event.class)
public class Event_ {
	public static volatile SingularAttribute<Event, Integer> id;
	public static volatile SingularAttribute<Event, Date> dateEnd;
	public static volatile SingularAttribute<Event, Date> dateStart;
	public static volatile SingularAttribute<Event, String> description;
	public static volatile SingularAttribute<Event, String> name;
	public static volatile SingularAttribute<Event, Boolean> isActive;
	public static volatile SingularAttribute<Event, Boolean> isRegOpened;
	public static volatile SingularAttribute<Event, Boolean> isStarted;
	public static volatile SingularAttribute<Event, Boolean> isPrivate;
	public static volatile SingularAttribute<Event, EventType> event;
	public static volatile ListAttribute<Event, Quest> quests;
	public static volatile ListAttribute<Event, Stalker> stalkers;
	public static volatile ListAttribute<Event, Payment> payments;
}
