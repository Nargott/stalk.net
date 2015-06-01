package ua.stalknet.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-06-01T22:41:57.832+0300")
@StaticMetamodel(Fraction.class)
public class Fraction_ {
	public static volatile SingularAttribute<Fraction, Integer> id;
	public static volatile SingularAttribute<Fraction, Boolean> active;
	public static volatile SingularAttribute<Fraction, String> description;
	public static volatile SingularAttribute<Fraction, Integer> influence;
	public static volatile SingularAttribute<Fraction, Integer> money;
	public static volatile SingularAttribute<Fraction, String> name;
	public static volatile SingularAttribute<Fraction, Stalker> deputyLeader;
	public static volatile SingularAttribute<Fraction, Stalker> leader;
	public static volatile ListAttribute<Fraction, Quest> quests;
}
