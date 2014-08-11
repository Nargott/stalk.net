package stalk.net.ua.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-08-12T00:06:42.103+0300")
@StaticMetamodel(Stalker.class)
public class Stalker_ {
	public static volatile SingularAttribute<Stalker, Integer> id;
	public static volatile SingularAttribute<Stalker, Byte> active;
	public static volatile SingularAttribute<Stalker, String> callsign;
	public static volatile SingularAttribute<Stalker, String> description;
	public static volatile SingularAttribute<Stalker, Integer> experience;
	public static volatile SingularAttribute<Stalker, String> legend;
	public static volatile SingularAttribute<Stalker, String> legendMaster;
	public static volatile SingularAttribute<Stalker, Integer> money;
	public static volatile SingularAttribute<Stalker, String> passport;
	public static volatile SingularAttribute<Stalker, Integer> pda;
	public static volatile SingularAttribute<Stalker, String> photo;
	public static volatile SingularAttribute<Stalker, Integer> rank;
	public static volatile SingularAttribute<Stalker, Event> eventBean;
	public static volatile SingularAttribute<Stalker, Fraction> fraction;
	public static volatile SingularAttribute<Stalker, User> user;
}
