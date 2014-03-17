package stalk.net.ua.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-03-18T00:00:06.697+0200")
@StaticMetamodel(Item.class)
public class Item_ {
	public static volatile SingularAttribute<Item, Integer> id;
	public static volatile SingularAttribute<Item, String> description;
	public static volatile SingularAttribute<Item, String> name;
	public static volatile SingularAttribute<Item, ItemsType> itemsType;
}
