package com.safedriving.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-05-23T17:30:46")
@StaticMetamodel(InscritForum.class)
public class InscritForum_ { 

    public static volatile SingularAttribute<InscritForum, Long> id;
    public static volatile SingularAttribute<InscritForum, Date> dateInscription;
    public static volatile SingularAttribute<InscritForum, String> userName;
    public static volatile SingularAttribute<InscritForum, String> password;

}