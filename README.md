# Product Explorer

## Présentation du projet
**Product Explorer** est une application Android moderne développée entièrement avec **Jetpack Compose**. 

L'objectif de cette application est de simuler une interface de type "catalogue e-commerce", permettant à l'utilisateur de découvrir des produits, de faire des recherches, de filtrer le catalogue et de consulter les détails d'un article spécifique. 

*Note : L'application est actuellement développée dans le cadre de Travaux Pratiques (TP) d'apprentissage. Les données sont pour l'instant locales (mockées).*

## Fonctionnalités actuelles

L'application est composée de trois écrans principaux :

### 1. Le catalogue interactif de produits (`ProductCatalogContainer` & `ProductCatalogScreen` - TP6, TP7, TP8 & TP9)
C'est le point d’entrée principal de l'application. Il affiche la liste des produits avec une architecture propre basée sur le **State Hoisting** :
- **Architecture Stateful / Stateless** :
  - `ProductCatalogContainer` (Stateful) : Gère les états (`searchQuery`, `showOnlyInStock`, `favoriteProductIds`), effectue le filtrage dynamique (`filteredProducts`) et gère les actions (`toggleFavorite`).
  - `ProductCatalogScreen` (Stateless) : Ne possède aucun état. Reçoit uniquement des données (`products`, `categories`, `searchQuery`, etc.) et transmet les événements via des callbacks (`onSearchQueryChange`, `onToggleStockFilter`, `onFavoriteClick`).
- **Barre de recherche interactive** : Filtrage en temps réel des produits par titre, marque ou catégorie.
- **Filtre par disponibilité** : Un bouton permet d'afficher uniquement les produits ayant un stock supérieur à zéro (`stock > 0`).
- **Compteur dynamique** : Affichage automatique du nombre de produits correspondant aux critères.
- **Gestion des favoris** : Conservation des favoris (`favoriteProductIds`) même lors de la récréation d'écran grâce à `rememberSaveable`.
- **Thème Material Design 3** : Prise en charge automatique du mode Clair et du mode Sombre.

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

- **State Hoisting** : Séparation claire de la gestion de l'état et de l'affichage UI. Les données descendent (*Data down*), les événements remontent (*Events up*).
- **UI Déclarative & State Management** :
  - `mutableStateOf` / `rememberSaveable` : Conservation et observabilité des états réactifs.
  - `remember` : Optimisation des calculs complexes (filtrage).
- **Material Design 3 (Personnalisation du Thème)** : Centralisation du design dans les fichiers `Theme.kt` (`LightColorScheme` / `DarkColorScheme`, `ProductShapes`, `ProductTypography`).
- **Listes performantes (Lazy Layouts)** : `LazyColumn` et `LazyRow` optimisés avec des clés uniques (`key = { product -> product.id }`).

## Prochaines étapes prévues
- Intégration d'un **ViewModel** pour sortir l'état de l'arbre Compose et suivre les recommandations officielles d'Android.
- Implémentation de la navigation réelle entre le catalogue, l'accueil et la fiche produit.
- Connexion à une source de données distante (API REST).