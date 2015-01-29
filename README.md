# cnam-etalab-2015

## Présentation

Ce repository a été créé à l'occaion du Hackaton #HackDDS organisé par l'Assurance Maladie Française (CNAMTS) et Etalab le 26 janvier 2015.

Ce hackaton survenait dans un contexte d'ouverture de leur fichier DAMIR en OpenData - le DAMIR recensant les dépenses réalisés dans le 
cadre de remboursement des prestations santé en France. Voir le [Repository du DAMIR](https://github.com/SGMAP-AGD/DAMIR).

L'objectif de la journée était pour les participants d'identifier les usages pouvant être fait des données ouvertes. Nous y avons participé
au sein d'une équipe représentant le groupe [Covea](http://www.covea.fr).  

## Focus

Notre focus durant ce hackaton s'est porté sur les ALD (Affectations Longue Durée). Il s'agit alors de les retrouver parmis les données 
et les codifications nombreuses du fichier afin de pouvoir estimer les RAC (Restes A Charge) en rapport ou non avec leur pathologie.
On veut à terme pouvoir réaliser cette estimation :
* en mesurant l'évolution dans le temps afin d'avaluer les transferts de charge vers les Complémentaires Santé,
* en mesurant la concentration ou la dispersion des RAC sur les assurés (notamment par tranche d'age).
* en évaluant la distribution géographique par ZEAT.

Les axes d'analyse sont les suivants :
* Par âge des bénéficiaires, 
* Par typologie d'actes de santé,
* Par spécialistes/médecins exécutants,
* Par type d'établissement.

## Solution

Notre solution s'est axée sur la synthétisation et la restitution plutôt que sur l'analyse et le croisement des données.
Nous avons alors mis en oeuvre une architecture web "classique" :
* Base de données MongoDB pour stocker et être capable de réaliser des agrégations sur un gros volume de données (+ de 3 millions de documents),
* APIs REST réalisées avec Spring Boot afin de maximiser l'efficacité durant le challenge,
* Application AngularJS pour le frontend afin de disposer d'une application réactive et de composants de charting
 
### Instructions

Pré-requis : 
* Un clone de ce repository Git,
* Une installation de MongoDB version 2.6,
* Maven, Node, Grunt et Bower.

#### Partie MongoDB

La base MongoDB doit se nommer `damir`.

L'import des données doit être réalisé de la façon suivante :

```sh
$ TODO
```

#### Partie Spring

Démarrer le serveur en se positionnant à la racine de `/cnam` et en exécutant :

```sh
$ mvn spring-boot:run
````
Les endpoints mis à disposition sont les suivants :
* `http://localhost:8080/depense/montantParAnnee`
* `http://localhost:8080/remboursement/montantParAnnee`
* `http://localhost:8080/nonRemboursement/montantParAnnee`
* `http://localhost:8080/ratio/remboursementPaiementParAnnee`
* `http://localhost:8080//nonRemboursement/montantParAnneePourPrestations?natures=01&natures=04`

#### Partie AngularJS

Démarrer le serveur en se positionnant à la racine de `/cnam-ui` et en exécutant :

```sh
$ grunt serve
```
Votre browser doit alors s'ouvrir avec un onglet positionné sur `http://localhost:9200`.


## Contributeurs

* Yann Guillerm (@yanngv29)
* Nicolas Barre (@nbarre)
* Laurent Broudoux (@lbroudoux)