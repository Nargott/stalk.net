package stalk.net.ua.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-04-18T17:46:46.779+0300")
@StaticMetamodel(Tiding.class)
public class Tiding_ {
	public static volatile SingularAttribute<Tiding, Integer> id;
	public static volatile SingularAttribute<Tiding, Date> datePub;
	public static volatile SingularAttribute<Tiding, String> description;
	public static volatile SingularAttribute<Tiding, String> name;
	public static volatile SingularAttribute<Tiding, User> user;
}