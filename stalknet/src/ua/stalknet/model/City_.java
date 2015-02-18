package ua.stalknet.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-08-31T16:41:50.403+0300")
@StaticMetamodel(City.class)
public class City_ {
	public static volatile SingularAttribute<City, Integer> id;
	public static volatile SingularAttribute<City, String> name;
	public static volatile SingularAttribute<City, String> phoneCode;
	public static volatile SingularAttribute<City, Region> region;
	public static volatile ListAttribute<City, User> users;
}
