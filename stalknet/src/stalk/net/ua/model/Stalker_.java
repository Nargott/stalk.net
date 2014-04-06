package stalk.net.ua.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-04-06T21:14:02.646+0300")
@StaticMetamodel(Stalker.class)
public class Stalker_ {
	public static volatile SingularAttribute<Stalker, Integer> id;
	public static volatile SingularAttribute<Stalker, String> callsign;
	public static volatile SingularAttribute<Stalker, Integer> experience;
	public static volatile SingularAttribute<Stalker, Integer> legendMaster;
	public static volatile SingularAttribute<Stalker, Integer> money;
	public static volatile SingularAttribute<Stalker, String> passport;
	public static volatile SingularAttribute<Stalker, String> photo;
	public static volatile SingularAttribute<Stalker, Integer> rank;
	public static volatile ListAttribute<Stalker, Fraction> fractions1;
	public static volatile ListAttribute<Stalker, Fraction> fractions2;
	public static volatile ListAttribute<Stalker, Quest> quests1;
	public static volatile ListAttribute<Stalker, Quest> quests2;
	public static volatile ListAttribute<Stalker, Quest> quests3;
	public static volatile ListAttribute<Stalker, Quest> quests4;
	public static volatile SingularAttribute<Stalker, Event> eventBean;
	public static volatile SingularAttribute<Stalker, Fraction> fractionBean;
	public static volatile SingularAttribute<Stalker, User> userBean;
}
