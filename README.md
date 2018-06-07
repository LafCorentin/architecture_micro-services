# architecture_micro-services

# Design

10-12j

* REST
* github
* Spring boot


## Problematique

* Récupérer, centraliser et traiter les logs générés par les micro-services.
Les logs doivent être récupérés dynamiquement par une application web utilisant AJAX. Il s'agit à terme de pouvoir traiter les logs d'exceptionns, du garbage collector et enfin des logs de l'OS.


## Etat de l'art

La gestion des logs est un enjeu de plus en plus grand pour les entreprises. Dans le cas du monitoring de micro-services, cela permet d'isoler le plus rapidement possible les problemes au sein de l'application. 

* Stack ELK
  Maintenant appelé Elastic stack, comprend :
  * Elasticsearch, qui permet le sotckage  et l'indexation des requêtes. Il est bas� sur le moteur de recherche Apache Lucene et a pour principales caract�ristiques l'utilisation d'une base de donn�es NoSQL, une forte scalabilit�, l'utilisation d'une API REST et des temps de r�ponse compris entre 20ms et 300ms.
  * Logstash, qui assure l'analyse, le filtrage et le découpage des logs
  * Kibana est un dashboard permettant l'affichage des logs. 

* Splunk




## Architecture

Schéma UML
