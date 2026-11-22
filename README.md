# Product Explorer

## Présentation du projet
**Product Explorer** est une application Android moderne développée entièrement avec **Jetpack Compose**. 

L'objectif de cette application est de simuler une interface de type "catalogue e-commerce", permettant à l'utilisateur de découvrir des produits, de faire des recherches (visuelles pour l'instant) et de consulter les détails d'un article spécifique. 

*Note : L'application est actuellement développée dans le cadre de Travaux Pratiques (TP) d'apprentissage. Les données sont pour l'instant "en dur" (locales) et aucune véritable navigation ou requête réseau n'est implémentée.*

## Fonctionnalités actuelles

L'application est composée de trois écrans principaux :

### 1. Le catalogue de produits (`ProductCatalogScreen` - TP6)
C'est le point d'entrée actuel de l'application. Il affiche un catalogue complet en utilisant les listes performantes de Compose.
- **En-tête du catalogue** : Un titre et une courte description.
- **Catégories (Défilement horizontal)** : Utilisation de `LazyRow` pour afficher une liste de catégories (Smartphones, Audio, etc.) défilant de gauche à droite.
- **Liste des produits (Défilement vertical)** : Utilisation de `LazyColumn` pour afficher de manière performante tous les produits disponibles (`sampleProducts()`).
- **Cartes produits (`ProductListItem`)** : Chaque élément de la liste est affiché dans une carte réutilisable présentant le titre, la marque, le prix, la note et un bouton d'action.

### 2. L'écran d'accueil (`ProductHomeScreen` - TP5)
*(Actuellement visible via les `@Preview`)*
Un écran d'accueil structuré avec différents Layouts (`Column`, `Row`, `Box`, `Spacer`, `Surface`).
- **En-tête** : Titre et sous-titre de bienvenue.
- **Barre de recherche** : Une fausse barre de recherche stylisée.
- **Produit mis en avant** : Une carte détaillée mettant en vedette un produit.
- **Catégories** : Une ligne horizontale statique de badges.
- **Offre du jour** : Une bannière promotionnelle avec un badge "Nouveau" superposé grâce au composant `Box`.

### 3. L'écran de détail produit (`ProductDetailScreen` - TP4)
*(Actuellement visible via les `@Preview`)*
Cet écran affiche la fiche complète d'un produit. Il a été conçu pour manipuler les composants de base de Jetpack Compose.
- **Image** : Un espace réservé (placeholder) pour la photo du produit.
- **En-tête** : Titre, marque et catégorie avec typographie `MaterialTheme`.
- **Prix et Remise** : Mise en évidence dans une carte (`Card`).
- **Évaluation** : Note du produit accompagnée d'une icône étoile.
- **Disponibilité** : Informations sur le stock et la livraison.
- **Description** : Texte de présentation du produit.
- **Garantie** : Information affichée dans un champ de texte en lecture seule (`OutlinedTextField`).
- **Action** : Bouton d'ajout au panier.

## Architecture et Code (Démarche d'apprentissage)

- **UI Déclarative** : L'interface est entièrement codée en Kotlin en utilisant les fonctions `@Composable`.
- **Listes performantes (Lazy Layouts)** : Utilisation de `LazyColumn` et `LazyRow` couplés à l'attribut `items` (et l'usage d'une clé `id` unique) pour générer dynamiquement le contenu de la liste sans surcharger la mémoire.
- **Composants réutilisables (Lego)** : Plutôt que d'avoir des fonctions géantes, l'interface est découpée en petits morceaux réutilisables (ex: `ProductListItem`, `CategoryRow`). Chaque composant reçoit uniquement les données dont il a besoin.
- **Modèle de données** : Une `data class ProductUi` est utilisée pour transporter les informations du produit vers l'interface. Un champ `id` a été ajouté pour optimiser le rendu des listes.
- **Material Design 3** : Le projet utilise les standards visuels d'Android (`MaterialTheme.typography`, `Card`, `Surface`, etc.).

## Prochaines étapes prévues
- Personnalisation de l'apparence avec le Material Design 3 (Thème, couleurs).
- Ajout de la navigation réelle entre le catalogue et l'écran de détail.
- Gestion de l'état (State) pour rendre l'application interactive.