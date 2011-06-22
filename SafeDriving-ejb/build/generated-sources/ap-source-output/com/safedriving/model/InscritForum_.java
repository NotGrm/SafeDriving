package com.safedriving.model;

import com.safedriving.model.WebSiteRole;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-06-20T23:43:31")
=======
@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-06-20T17:04:04")
>>>>>>> ac2f803218f6c7911acf86150462d337f8ac5306
@StaticMetamodel(InscritForum.class)
public class InscritForum_ { 

    public static volatile SingularAttribute<InscritForum, Long> id;
    public static volatile SingularAttribute<InscritForum, String> username;
    public static volatile SingularAttribute<InscritForum, Date> dateInscription;
    public static volatile SingularAttribute<InscritForum, WebSiteRole> role;
    public static volatile SingularAttribute<InscritForum, String> password;

}