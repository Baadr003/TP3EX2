# Gestion de Stock pour un Magasin de Produits Informatiques (Exercice 2)

Ce projet est une application Java de gestion de stock pour un magasin de vente de produits informatiques, utilisant Hibernate pour la persistance des données et MySQL comme base de données.

## Table des matières

1. [Description du projet](#description-du-projet)
2. [Prérequis](#prérequis)
3. [Structure du projet](#structure-du-projet)
4. [Configuration](#configuration)
5. [Fonctionnalités](#fonctionnalités)
6. [Installation et exécution](#installation-et-exécution)
7. [Tests](#tests)

## Description du projet

Cette application gère le stock d'un magasin de produits informatiques. Elle permet de gérer les produits, les catégories, les commandes et les lignes de commande en utilisant Hibernate pour la persistance des données.

## Prérequis

- JDK 8 ou supérieur
- NetBeans IDE
- MySQL Server
- Hibernate ORM
- MySQL Connector/J

## Structure du projet

Le projet est organisé en plusieurs packages :

- `ma.projet.classes` : Contient les classes entités (Produit, Categorie, Commande, LigneCommande)
- `ma.projet.config` : Contient le fichier de configuration Hibernate
- `ma.projet.util` : Contient la classe utilitaire `HibernateUtil`
- `ma.projet.dao` : Contient l'interface générique `IDao`
- `ma.projet.service` : Contient les classes services pour chaque entité

## Configuration

1. Créez une base de données MySQL pour le projet.
2. Configurez le fichier `hibernate.cfg.xml` dans le package `ma.projet.config` avec les informations de connexion à votre base de données.

## Fonctionnalités

- Gestion des produits (CRUD)
- Gestion des catégories (CRUD)
- Gestion des commandes (CRUD)
- Affichage de la liste des produits par catégorie
- Affichage de la liste des produits commandés entre deux dates
- Affichage des produits commandés dans une commande donnée
- Affichage de la liste des produits dont le prix est supérieur à 100 DH (utilisant une requête nommée)

## Installation et exécution

1. Clonez ce dépôt Git.
2. Ouvrez le projet dans NetBeans.
3. Assurez-vous que toutes les dépendances (Hibernate et MySQL Connector) sont correctement configurées.
4. Exécutez le fichier de test principal pour tester les fonctionnalités.

## Tests

Créez des programmes de test pour vérifier :
- La création et la gestion des produits, catégories et commandes
- L'affichage des produits par catégorie
- L'affichage des produits commandés entre deux dates
- L'affichage des produits d'une commande spécifique
- L'affichage des produits dont le prix est supérieur à 100 DH
