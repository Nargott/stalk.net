package stalk.net.ua.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-04-06T21:14:02.634+0300")
@StaticMetamodel(Quest.class)
public class Quest_ {
	public static volatile SingularAttribute<Quest, Integer> id;
	public static volatile SingularAttribute<Quest, String> code;
	public static volatile SingularAttribute<Quest, Integer> experience;
	public static volatile SingularAttribute<Quest, String> image;
	public static volatile SingularAttribute<Quest, Integer> level;
	public static volatile SingularAttribute<Quest, String> name;
	public static volatile SingularAttribute<Quest, Integer> price;
	public static volatile SingularAttribute<Quest, Integer> status;
	public static volatile SingularAttribute<Quest, Event> eventBean;
	public static volatile SingularAttribute<Quest, Quest> quest;
	public static volatile ListAttribute<Quest, Quest> quests;
	public static volatile SingularAttribute<Quest, Stalker> stalker1;
	public static volatile SingularAttribute<Quest, Stalker> stalker2;
	public static volatile SingularAttribute<Quest, Stalker> stalker3;
	public static volatile SingularAttribute<Quest, Stalker> stalker4;
}
