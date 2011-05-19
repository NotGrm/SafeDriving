package com.safedriving.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-05-18T20:59:31")
@StaticMetamodel(Personne.class)
public class Personne_ { 

    public static volatile SingularAttribute<Personne, Integer> id;
    public static volatile SingularAttribute<Personne, String> prenom;
    public static volatile SingularAttribute<Personne, String> adresse;
    public static volatile SingularAttribute<Personne, Integer> codePostal;
    public static volatile SingularAttribute<Personne, String> ville;
    public static volatile SingularAttribute<Personne, String> nom;

}