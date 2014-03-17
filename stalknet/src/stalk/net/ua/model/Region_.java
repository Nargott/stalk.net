package stalk.net.ua.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-03-18T00:00:06.747+0200")
@StaticMetamodel(Region.class)
public class Region_ {
	public static volatile SingularAttribute<Region, Integer> id;
	public static volatile SingularAttribute<Region, String> name;
	public static volatile ListAttribute<Region, City> cities;
	public static volatile SingularAttribute<Region, Country> country;
}
