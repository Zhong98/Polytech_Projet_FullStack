---
title: Projet Full-Stack
tags: Vue,Spring
category: Développé par 5A SIR Zixiao Zhong(31632950)
grammar_cjkRuby: true
---

*Créé par Zixiao Zhong (31632950)*

# Introduction

Ce projet est un projet Full-Stack développé par Vuejs et Java framework Spring. Il est une application web qui permet à utilisateur de prendre un rdv dans une centre de vaccination Covid. 
Il a deux parties, un est public, tout le monde peut visiter; l'autre est prive, pour médecins, administrateurs et super admin.

# Frontend
### Technologies implémentées :<br>
- Vite
- Axios(request http)
- Pinia
- File d'attente
- Formulaire BasicAuth
- Guard
- Interceptors
- Material :Element-UI

Framework: Vuejs 3.0
port: http://127.0.0.1:3000
Outil: Vite
Vite est un outil de construction qui vise à fournir une expérience de développement plus rapide et plus légère pour les projets Web modernes. Documentation: https://vitejs.dev/guide/
![enter description here](./images/1673814399404.png)
* Components:
  * **Router**: Vue-Router (Documentation: https://router.vuejs.org/) 
    La fiche de configuration: **src/router/index.js**. Le Component qui est responsable du routage. Technologies utilisées :
    * Navigateur guard
      * beforeEach: Le guard global
     ![enter description here](./images/1673815013257.png)
	  * beforeEnter: Le guard pour la routage spécifié
    ![enter description here](./images/1673815043578.png)
  * **Pinia** (Documentation: https://pinia.vuejs.org/)
    Pinia est une bibliothèque de magasin pour Vue, elle vous permet de partager un état entre les composants/pages. La fiche de configuration: **src/store/index.js** 
	Dans ce projet, il y a deux stores de pinia:
	* reserve.js:  Enregistrer des résultats de rechercher et le center choisi par utilisateur
	* backOffice.js:  Enregistrer des données de login et des données nécessaires pour back office
  * **Axios** (Documentation: https://axios-http.com/docs/intro)
    Axios est un client HTTP basé sur des promesses pour node.js et le navigateur. La fiche de configuration: **src/utils/request.js**
	* Interceptor
	  * request interceptor: Avant envoyer la demandé http. Dans ce projet, j'utilise request interceptor pou ajouter le token dans headers avant envoyer request http.
	  * response interceptor: Recevoir la réponse de backend, avant envoyer au composant frontend
	  * http request: Dans les dossiers de *center*,*people*,*rdv*, il y a des fiches JS pour envoyer http request, ex.getCenter etc. Comprise Promise aussi.
	    
   * **Element-UI**: une bibliothèque de composants basée sur Vue 3 pour les concepteurs et les développeurs. (Documentation: https://element-plus.org/en-US/)  Il comprend les composants comme table, form etc.

* EndPoint:
  * /public: Le homepage de cette application, permettre à utilisateur de rechercher center et choisir
  * /reserve: La page de prendre rdv 
  * /wait: File d'attente
  * /login: La formulaire de Basic Auth

* Exécuter: Le frontend est developpé dans le logiciel Webstorm, exécuter dans le logiciel ou entre dans le dossier et utiliser npm run dev

# Backend
### Technologies implémentées :<br>
- Entity
- SpringMVC(Couche repository; Service; Controller)
- Basic Auth
- Interceptor
- JWT
- Spring JPA
- Liquibase
- Endpoint public et admin
- Micrometer
- RateLimit via Token Bucket
- Etags(Toujours avoir bug, pas réussi)

Framework: Spring
Port: http://127.0.0.1:8080/
* Entity: Mapper les tableaus dans base de données, Center, Person(User, super admin/administrateur/médecin).
* Controller: public et admin, public n'a pas besoin de token, admin a besoin de token crée par système après login réussi.
* Service et repository: Exécuter les codes de SQL et connecter avec la base de données.
* Basic Auth: Login, Si réussir, créer un token et rétourner au frontend.
* Interceptor: Quand request vers les Endpoint admin, vérifier s'il y a un token dans le header et vérifier le token.
* JWT: Créer un token avec le secret et algo defini, j'enregistre l'ID de user et role dans le token.
* Micrometer: Utiliser dans le controller public, pour surveiller les Endpoint public, l'interface pour rechercher et prendre rdv. Avec les annotations @Timed @Counted.
* RateLimit: Controler la nombre de visite de back office. Déployer dans le controller de Login, si une personne réussi à login, le token bucket moins un.

## Dependencies utilisés:
- spring-boot-starter-data-jpa
- spring-boot-starter-web
- liquibase-core
- lombok
- pring-boot-devtools
- postgresql
- spring-boot-starter-test
- spring-boot-starter-security
- java-jwt
- fastjson2
- bucket4j-core
- micrometer-core

## Endpoint
* public:
  * /public/search: Rechercher les centres avec code postal ou ville
  * /public/reserve: Enregistrer un rdv dans la base de données
* admin(prive)
    **Juste pour Super Admin**:
	* /admin/center: Gérer les centres, ajouter une nouvelle centre, modifier etc. 
	  * /centerList: Affichier toutes les centres dans la base de données
	  * /addCenter
	  * /updateCenter
	* /admin/people: Gérer les utilisateurs de back office
	  * /findAdmin: Affichier tous les administrateurs
	  * /findSuperAdmin: Affichier tous les super admins
	   
    **Pour Super Admin et Administrateur**:
	* /admin/people
	  * /findDoctor
	  * /addOrUpdatePerson
	  * /deletePerson: Administrateur peut spprimer médecin seulement.
	* /admin/reserve: Les endpoints de modifier les infos de rdv 
	  * /deleteReservation
	 
	 **Pour Super Admin et Administrateur et Médecin**:
	 Sauf que les endpoints ci-dessus
	 * /findReservationByCenter
	 * /findReservationByDate
	 * /findReservationByPatient
	 * /updateReservation
 
* Exécuter: Le backend est développé avec le logiciel IntelliJ idea et Gradle. Exécuter dans le logiciel est mieux, exécuter la classe CovidApplication. 
# Base de données
PostgreSQL
Username: postgresql
Password: root
Port: http://127.0.0.1/5432
Vous pouvez trouver le fichier sql qui comprend toutes les données j'ai utilisé et aussi logs dans les table *databasechanglog* et *databasechangeloglock* crée par liquibase

# Docker
* Frontend:
  * npm run build
  * docker pull nginx
  * créer nginx config: *default.config*
  * dockerfile: 
    FROM nginx 
	COPY dist/ /usr/share/nginx/html/ 
	COPY nginx/default.conf /etc/nginx/conf.d/default.conf
  * docker build -t vueproject
 * Backend
   * dockerfile:
     FROM java:8 
	 VOLUME /tmp 
	 ADD data-migration-0.0.1-SNAPSHOT.jar covid.jar 
	 RUN bash -c 'backend/covid.jar' 
	 ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/covid.jar"] 
	 EXPOSE 8080
 * PostgreSQL
   * docker pull postgres
   * mkdir -p /opt/postgres/data(votre data path)
   * docker run --name postgres -v /opt/postgres/data:/var/lib/postgresql/data -e POSTGRES_PASSWORD=root -p 5432:5432 -d postgres

# Encore je peux améliorer:

* Etags
* Basic Auth
## Versions
Vite: 4.0<br>
Docker : 20.10.21<br>
Java (jdk) : 17.0.5<br>
Java: 8<br>
Gradle : 7.6<br>
Spring : 2.7.7<br>
Node : 16.16.0<br>
npm : 9.2.0<br>
