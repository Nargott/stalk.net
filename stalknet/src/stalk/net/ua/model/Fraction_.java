package stalk.net.ua.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-03-18T00:00:06.683+0200")
@StaticMetamodel(Fraction.class)
public class Fraction_ {
	public static volatile SingularAttribute<Fraction, Integer> id;
	public static volatile SingularAttribute<Fraction, String> description;
	public static volatile SingularAttribute<Fraction, Integer> influence;
	public static volatile SingularAttribute<Fraction, Integer> money;
	public static volatile SingularAttribute<Fraction, String> name;
	public static volatile SingularAttribute<Fraction, Stalker> stalker1;
	public static volatile SingularAttribute<Fraction, Stalker> stalker2;
	public static volatile ListAttribute<Fraction, Stalker> stalkers;
}
