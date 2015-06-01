package ua.stalknet.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-06-02T00:42:11.796+0300")
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
	public static volatile SingularAttribute<Quest, Event> event;
	public static volatile SingularAttribute<Quest, Quest> parent;
	public static volatile SingularAttribute<Quest, Stalker> finisher;
	public static volatile SingularAttribute<Quest, Stalker> owner;
	public static volatile SingularAttribute<Quest, Stalker> performer;
	public static volatile SingularAttribute<Quest, Stalker> target;
	public static volatile SingularAttribute<Quest, Fraction> fraction;
	public static volatile SingularAttribute<Quest, GPS> gps;
	public static volatile SingularAttribute<Quest, Location> location;
}
