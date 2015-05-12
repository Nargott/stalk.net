package ua.stalknet.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-05-12T23:25:09.675+0300")
@StaticMetamodel(GPS.class)
public class GPS_ {
	public static volatile SingularAttribute<GPS, Integer> id;
	public static volatile SingularAttribute<GPS, Float> latitude;
	public static volatile SingularAttribute<GPS, Float> longitude;
	public static volatile SingularAttribute<GPS, Float> accuracy;
	public static volatile SingularAttribute<GPS, Float> speed;
	public static volatile SingularAttribute<GPS, String> description;
	public static volatile SingularAttribute<GPS, Date> date;
}
