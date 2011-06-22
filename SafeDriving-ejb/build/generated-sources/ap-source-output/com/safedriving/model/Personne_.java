package com.safedriving.model;

import com.safedriving.model.InscritForum;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-06-20T23:43:31")
@StaticMetamodel(Personne.class)
public class Personne_ { 

    public static volatile SingularAttribute<Personne, Long> id;
    public static volatile SingularAttribute<Personne, String> prenom;
    public static volatile SingularAttribute<Personne, String> adresse;
    public static volatile SingularAttribute<Personne, Date> dateNaissance;
    public static volatile SingularAttribute<Personne, Integer> codePostal;
    public static volatile SingularAttribute<Personne, String> ville;
    public static volatile SingularAttribute<Personne, InscritForum> compteForum;
    public static volatile SingularAttribute<Personne, String> nom;

}