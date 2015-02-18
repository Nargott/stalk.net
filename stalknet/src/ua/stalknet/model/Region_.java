package ua.stalknet.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-08-31T16:41:50.436+0300")
@StaticMetamodel(Region.class)
public class Region_ {
	public static volatile SingularAttribute<Region, Integer> id;
	public static volatile SingularAttribute<Region, String> name;
	public static volatile SingularAttribute<Region, Country> country;
}
