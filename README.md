# Product Explorer

## Présentation du projet
**Product Explorer** est une application Android moderne développée entièrement avec **Jetpack Compose**. 

L'objectif de cette application est de simuler une interface de type "catalogue e-commerce", permettant à l'utilisateur de découvrir des produits, de faire des recherches, de filtrer le catalogue et de consulter les détails d'un article spécifique. 

*Note : L'application est actuellement développée dans le cadre de Travaux Pratiques (TP) d'apprentissage. Les données sont pour l'instant locales (mockées).*

## Fonctionnalités actuelles

L'application est composée de trois écrans principaux :

### 1. Le catalogue interactif de produits (`ProductCatalogScreen` - TP6, TP7 & TP8)
C'est le point d’entrée principal de l'application. Il affiche la liste des produits avec une gestion d'état réactive (State Management).
- **Barre de recherche interactive** : Filtrage en temps réel des produits par titre, marque ou catégorie grâce à `rememberSaveable` et `mutableStateOf`.
- **Filtre par disponibilité** : Un bouton permet d'afficher uniquement les produits ayant un stock supérieur à zéro (`stock > 0`).
- **Compteur dynamique** : Affichage automatique du nombre de produits correspondant aux critères de recherche et de filtrage.
- **Gestion des favoris** : Chaque produit peut être ajouté ou retiré des favoris. L'état des favoris (`favoriteProductIds`) est conservé même en cas de rotation de l'écran grâce à `rememberSaveable`.
- **Catégories (Défilement horizontal)** : `LazyRow` permettant de parcourir les catégories.
- **Thème Material Design 3** : Prise en charge automatique des couleurs du mode Clair et du mode Sombre.

### 2. L'écran d'accueil (`ProductHomeScreen` - TP5)
*(Actuellement visible via les `@Preview`)*
Un écran d'accueil structuré avec différents Layouts (`Column`, `Row`, `Box`, `Spacer`, `Surface`).
- **Barre de recherche** : Une fausse barre de recherche stylisée.
- **Produit mis en avant** : Une carte détaillée mettant en vedette un produit.
- **Catégories** : Une ligne horizontale de badges.
- **Offre du jour** : Une bannière promotionnelle avec un badge "Nouveau" superposé grâce au composant `Box`.

### 3. L'écran de détail produit (`ProductDetailScreen` - TP4)
*(Actuellement visible via les `@Preview`)*
Cet écran affiche la fiche complète d'un produit. 
- **Image** : Un espace réservé (placeholder) pour la photo.
- **Prix, Remise et Disponibilité** : Mise en évidence dans des cartes (`Card`).
- **Garantie** : Information affichée dans un champ de texte en lecture seule (`OutlinedTextField`).
- **Action** : Bouton d'ajout au panier.

## Architecture et Code (Démarche d'apprentissage)

- **UI Déclarative & State Management** :
  - `mutableStateOf` : Permet à Compose d'observer les changements de variables (recherche, filtres, favoris) et de ré-exécuter l'affichage (recomposition).
  - `remember` : Optimise les calculs coûteux (comme le filtrage de liste) pour ne les refaire que lorsque les dépendances changent.
  - `rememberSaveable` : Sauvegarde l'état lors de la recréation de l'activité (ex: rotation de l'écran).
- **Material Design 3 (Personnalisation du Thème)** : Centralisation du design dans les fichiers `Theme.kt` (`LightColorScheme` / `DarkColorScheme`, `ProductShapes`, `ProductTypography`).
- **Listes performantes (Lazy Layouts)** : `LazyColumn` et `LazyRow` optimisés avec des clés uniques (`key = { product -> product.id }`).

## Prochaines étapes prévues
- Architecture avancée avec **State Hoisting** et **ViewModel**.
- Implémentation de la navigation réelle entre le catalogue, l'accueil et la fiche produit.
- Intégration d'une vraie source de données distante (API REST).