package stalk.net.ua.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-03-18T00:00:06.128+0200")
@StaticMetamodel(City.class)
public class City_ {
	public static volatile SingularAttribute<City, Integer> id;
	public static volatile SingularAttribute<City, String> name;
	public static volatile SingularAttribute<City, String> phoneCode;
	public static volatile SingularAttribute<City, Region> region;
}
