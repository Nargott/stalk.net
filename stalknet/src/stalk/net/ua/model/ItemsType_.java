package stalk.net.ua.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-03-18T00:00:06.710+0200")
@StaticMetamodel(ItemsType.class)
public class ItemsType_ {
	public static volatile SingularAttribute<ItemsType, Integer> id;
	public static volatile SingularAttribute<ItemsType, String> description;
	public static volatile SingularAttribute<ItemsType, String> name;
	public static volatile ListAttribute<ItemsType, Item> items;
}