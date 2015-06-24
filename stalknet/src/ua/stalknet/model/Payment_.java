package ua.stalknet.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-06-24T22:58:57.048+0300")
@StaticMetamodel(Payment.class)
public class Payment_ {
	public static volatile SingularAttribute<Payment, Integer> id;
	public static volatile SingularAttribute<Payment, String> description;
	public static volatile SingularAttribute<Payment, Event> event;
	public static volatile SingularAttribute<Payment, Date> date;
	public static volatile SingularAttribute<Payment, BigDecimal> amount;
	public static volatile SingularAttribute<Payment, Stalker> stalker;
}
