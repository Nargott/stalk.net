package stalk.net.ua.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-03-18T00:00:06.738+0200")
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
	public static volatile SingularAttribute<Quest, Stalker> stalker1;
	public static volatile SingularAttribute<Quest, Stalker> stalker2;
	public static volatile SingularAttribute<Quest, Stalker> stalker3;
	public static volatile SingularAttribute<Quest, Stalker> stalker4;
}
