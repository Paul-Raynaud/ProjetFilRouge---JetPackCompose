# Product Explorer

## Présentation du projet
**Product Explorer** est une application Android moderne développée entièrement avec **Jetpack Compose** et **Material Design 3**. 

Ce projet simule une interface de type "catalogue e-commerce", permettant à l'utilisateur de parcourir un catalogue, de rechercher des produits, de filtrer les articles disponibles et de gérer une liste de favoris.

---

## Chronologie des évolutions par TP

### TP 4 – Écran de détail produit (Composants fondamentaux)
- **Modèle de données** : Création de la classe de données `ProductUi` (titre, marque, catégorie, prix, remise, note, stock, garantie, livraison).
- **Composants atomiques** : Découpage de l'interface en sous-composants réutilisables (`ProductHeader`, `ProductPriceCard`, `ProductImage`, `ProductRating`, `ProductAvailabilityCard`, `ProductDescription`, `ProductWarrantyField`, `AddToCartButton`).
- **Assemblage** : Création de l'écran `ProductDetailScreen` et des prévisualisations `@Preview` (produit disponible et produit en rupture de stock).

### TP 5 – Écran d'accueil Product Explorer (Layouts Compose)
- **Exploration des Layouts** : Utilisation des composants de disposition fondamentaux (`Column`, `Row`, `Box`, `Spacer`, `Surface`).
- **Composants d'accueil** : 
  - `HomeHeader` : En-tête de bienvenue.
  - `SearchPreviewBar` : Barre de recherche visuelle basée sur `Surface`.
  - `FeaturedProductSection` : Carte mettant en avant un produit vedette.
  - `ProductQuickInfoRow` : Alignement horizontal (prix, note, stock) via `Row` et `Modifier.weight`.
  - `CategoriesSection` & `CategoryChip` : Badges de catégories.
  - `DailyOfferBox` : Superposition d'un badge "Nouveau" en haut à droite d'une bannière via `Box` et `Alignment.TopEnd`.

### TP 6 – Affichage d'un catalogue local (Listes modernes)
- **Identifiants uniques** : Ajout d'une propriété `id: Int` dans `ProductUi` pour l'identification stable des éléments dans les listes.
- **Source de données locale** : Création de `sampleProducts()` et `sampleCategories()`.
- **Listes optimisées (Lazy Layouts)** :
  - `LazyColumn` : Liste verticale pour afficher l'ensemble du catalogue de manière performante.
  - `LazyRow` : Liste horizontale pour le défilement des catégories.
  - `items(key = { product.id })` : Optimisation du rendu de la liste.
- **Composant carte** : Création de `ProductListItem` pour afficher chaque élément du catalogue.
- **Dépendance** : Intégration de `androidx.compose.material:material-icons-extended` pour l'icône d'étoile de notation.

### TP 7 – Personnalisation graphique (Material Design 3 & Thème)
- **Palettes de couleurs** : Définition des couleurs `LightColorScheme` et `DarkColorScheme` dans `Theme.kt` (`primary`, `surface`, `background`, `secondary`, `onSurface`, etc.).
- **Formes & Typographie** :
  - `ProductShapes` : Définition d'arrondis cohérents (`small`, `medium`, `large`, `extraLarge`).
  - `ProductTypography` : Styles de textes personnalisés (`headlineMedium`, `titleLarge`, `titleMedium`, `bodyMedium`, `labelLarge`).
- **Application au catalogue** : Utilisation de `MaterialTheme.colorScheme.background` et `surface` sur les cartes et le fond d'écran.
- **Multi-Thème** : Prise en charge automatique et aperçus `@Preview` pour le **Mode Sombre** (*Dark Theme*) et le **Mode Clair** (*Light Theme*).

### TP 8 – Rendre le catalogue interactif (State Management)
- **États réactifs** : Utilisation de `mutableStateOf` et `rememberSaveable` pour capturer les interactions utilisateur.
- **Barre de recherche interactive** : Filtrage dynamique en temps réel via un `OutlinedTextField`.
- **Filtre de disponibilité** : Bouton permettant de basculer l'affichage vers les produits en stock uniquement (`stock > 0`).
- **Calcul réactif** : Utilisation de `remember(products, searchQuery, showOnlyInStock)` pour recalculer la liste filtrée sans bloquer l'UI.
- **Compteur dynamique** : Affichage automatique du nombre de produits affichés.
- **Système de favoris** : Gestion d'une liste d'identifiants favoris (`favoriteProductIds`) avec mise à jour instantanée du bouton ("Ajouter" / "Retirer").

### TP 9 – Refactorer avec le State Hoisting (Stateful vs Stateless)
- **Séparation des responsabilités** :
  - **Composant Stateful (`ProductCatalogContainer`)** : Conserve et modifie les états (`searchQuery`, `showOnlyInStock`, `favoriteProductIds`), exécute le filtrage et la logique `toggleFavorite`.
  - **Composant Stateless (`ProductCatalogScreen`)** : Ne possède aucun état. Reçoit uniquement des valeurs d'affichage et émet des événements vers le parent (*Data down, Events up*).

### TP 10 – Gestion d'écran avec ViewModel (Architecture Android)
- **Dépendance** : Ajout de `androidx.lifecycle:lifecycle-viewmodel-compose`.
- **Architecture ViewModel** :
  - Création de `ProductCatalogViewModel` héritant de `ViewModel()`.
  - Encapsulation des états avec `private set` (`searchQuery`, `showOnlyInStock`, `favoriteProductIds`).
  - Calcul automatique de `filteredProducts` via un getter.
  - Fonctions explicites pour la gestion des événements (`onSearchQueryChange`, `onToggleStockFilter`, `onFavoriteClick`).
- **Injection** : Récupération du `ViewModel` dans `ProductCatalogContainer` via `viewModel()`.
- **Survie aux configurations** : Conservation des filtres et favoris lors de la récréation d'écran (ex: rotation du téléphone).

---

## Résumé de l'architecture retenue

```text
MainActivity (Point d'entrée)
  └── ProductCatalogContainer (Injecte le ViewModel)
        └── ProductCatalogViewModel (Conserve l'état & gère la logique)
        └── ProductCatalogScreen (Stateless - Dessine la LazyColumn)
              ├── CategoryRow (LazyRow)
              │     └── CategoryChip
              └── ProductListItem (Card - Dessine un produit)
```

- **UI Déclarative** : Jetpack Compose (`@Composable`)
- **Design System** : Material Design 3 (Thème clair / sombre, Typographies, Formes)
- **Gestion de l'état** : Architecture officielle Android Unidirectionnelle (UDF) avec `ViewModel` et **State Hoisting**
- **Listes performantes** : `LazyColumn` & `LazyRow` avec clés d'identification uniques.