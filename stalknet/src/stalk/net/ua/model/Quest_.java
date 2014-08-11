package stalk.net.ua.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-08-12T00:06:42.063+0300")
@StaticMetamodel(Quest.class)
public class Quest_ {
	public static volatile SingularAttribute<Quest, Integer> id;
	public static volatile SingularAttribute<Quest, String> code;
	public static volatile SingularAttribute<Quest, String> description;
	public static volatile SingularAttribute<Quest, Integer> experience;
	public static volatile SingularAttribute<Quest, String> hint;
	public static volatile SingularAttribute<Quest, String> image;
	public static volatile SingularAttribute<Quest, Integer> level;
	public static volatile SingularAttribute<Quest, String> name;
	public static volatile SingularAttribute<Quest, Integer> price;
	public static volatile SingularAttribute<Quest, Integer> status;
	public static volatile SingularAttribute<Quest, Event> eventBean;
	public static volatile SingularAttribute<Quest, Quest> parent;
	public static volatile SingularAttribute<Quest, Stalker> finisher;
	public static volatile SingularAttribute<Quest, Stalker> owner;
	public static volatile SingularAttribute<Quest, Stalker> performer;
	public static volatile SingularAttribute<Quest, Stalker> target;
}
