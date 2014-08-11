package stalk.net.ua.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-08-12T00:06:42.122+0300")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, Date> birthdate;
	public static volatile SingularAttribute<User, Date> created;
	public static volatile SingularAttribute<User, String> description;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> fio;
	public static volatile SingularAttribute<User, Date> lastlogin;
	public static volatile SingularAttribute<User, String> login;
	public static volatile SingularAttribute<User, String> pass;
	public static volatile SingularAttribute<User, String> phone;
	public static volatile SingularAttribute<User, String> picture;
	public static volatile SingularAttribute<User, Integer> rights;
	public static volatile ListAttribute<User, Stalker> stalkers;
	public static volatile ListAttribute<User, Tiding> tidings;
	public static volatile SingularAttribute<User, City> city;
}
