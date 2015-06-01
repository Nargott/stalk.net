package ua.stalknet.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-06-01T21:39:25.838+0300")
@StaticMetamodel(UserGroup.class)
public class UserGroup_ {
	public static volatile SingularAttribute<UserGroup, Integer> id;
	public static volatile SingularAttribute<UserGroup, String> name;
	public static volatile SingularAttribute<UserGroup, String> synonym;
	public static volatile ListAttribute<UserGroup, User> users;
}
