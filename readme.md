# Application Web Jakarta EE

Ce projet est un exemple d'application web `jakarta EE` en utilisant les composants Web Servlet, JSP et JSTL. sans faire appel à aucun Framework, tout en respectant le pattern MVC.  
Cette application permet d'ajouter, supprimer, éditer des produits stockés dans une base de données `PostgreSQL`.  

#### l'application se compose de 5 couches :


 - Couche model
 - Couche repository    
 - Couche Service     
 - Couche Web

#### Pour tester l'application :
Créer la base de données :
```
CREATE TABLE IF NOT EXISTS public.produit
(
    ref_prod character(50) COLLATE pg_catalog."default" NOT NULL,
    designation character(50) COLLATE pg_catalog."default" NOT NULL,
    prix numeric NOT NULL,
    quantite integer NOT NULL,
    CONSTRAINT produit_pkey PRIMARY KEY (ref_prod)
)
```
Ajouter le fichier `database.properties` sous le dossier resources.
```
user = postgres
password = votre_mot_de_passe
ssl = false/true
```

Cet exemple est un passage idéale avant de commencer à utiliser les Frameworks Hibernate, Spring, Struts, JSF, etc.
