package ua.stalknet.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-06-01T23:21:37.331+0300")
@StaticMetamodel(Stalker.class)
public class Stalker_ {
	public static volatile SingularAttribute<Stalker, Integer> id;
	public static volatile SingularAttribute<Stalker, Boolean> active;
	public static volatile SingularAttribute<Stalker, String> callsign;
	public static volatile SingularAttribute<Stalker, String> description;
	public static volatile SingularAttribute<Stalker, Integer> experience;
	public static volatile SingularAttribute<Stalker, String> legend;
	public static volatile SingularAttribute<Stalker, String> legendMaster;
	public static volatile SingularAttribute<Stalker, Integer> money;
	public static volatile SingularAttribute<Stalker, String> passport;
	public static volatile SingularAttribute<Stalker, String> photo;
	public static volatile SingularAttribute<Stalker, Integer> rank;
	public static volatile ListAttribute<Stalker, Event> events;
	public static volatile SingularAttribute<Stalker, Fraction> fraction;
	public static volatile SingularAttribute<Stalker, User> user;
	public static volatile SingularAttribute<Stalker, GPS> gps;
	public static volatile SingularAttribute<Stalker, Location> home;
}
