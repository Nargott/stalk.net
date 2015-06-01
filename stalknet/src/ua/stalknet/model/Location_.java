package ua.stalknet.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-06-01T23:14:37.855+0300")
@StaticMetamodel(Location.class)
public class Location_ {
	public static volatile SingularAttribute<Location, Integer> id;
	public static volatile SingularAttribute<Location, String> description;
	public static volatile SingularAttribute<Location, String> name;
	public static volatile SingularAttribute<Location, String> icon;
	public static volatile SingularAttribute<Location, String> picture;
	public static volatile SingularAttribute<Location, GPS> gps;
	public static volatile ListAttribute<Location, Stalker> citizens;
	public static volatile ListAttribute<Location, Quest> quests;
}
