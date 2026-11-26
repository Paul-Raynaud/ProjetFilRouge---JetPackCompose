# Product Explorer

## Présentation du projet
**Product Explorer** est une application Android moderne développée entièrement avec **Jetpack Compose** et **Material Design 3**. 

Ce projet simule une interface de type "catalogue e-commerce", permettant à l'utilisateur de parcourir un catalogue, de rechercher des produits, de filtrer les articles disponibles et de gérer une liste de favoris.

---

## Chronologie des évolutions par TP

### TP 4 – Écran de détail produit (Composants fondamentaux)
- **Modèle de données** : Création de la classe de données `ProductUi` (titre, marque, catégorie, prix, remise, note, stock, garantie, livraison).
- **Composants atomiques** : Découpage de l'interface en sous-composants réutilisables (`ProductHeader`, `ProductPriceCard`, `ProductImage`, `ProductRating`, `ProductAvailabilityCard`, `ProductDescription`, `ProductWarrantyField`, `AddToCartButton`).
- **Assemblage** : Création de l'écran `ProductDetailScreen` et des prévisualisations `@Preview`.

### TP 5 – Écran d'accueil Product Explorer (Layouts Compose)
- **Exploration des Layouts** : Utilisation des composants de disposition fondamentaux (`Column`, `Row`, `Box`, `Spacer`, `Surface`).
- **Composants d'accueil** : `HomeHeader`, `SearchPreviewBar`, `FeaturedProductSection`, `ProductQuickInfoRow`, `CategoryChip`, `CategoriesSection`, `DailyOfferBox`.

### TP 6 – Affichage d'un catalogue local (Listes modernes)
- **Identifiants uniques** : Ajout d'une propriété `id: Int` dans `ProductUi`.
- **Listes optimisées (Lazy Layouts)** : `LazyColumn` (défilement vertical) et `LazyRow` (défilement horizontal).
- **Composant carte** : Création de `ProductListItem` pour afficher chaque élément du catalogue.

### TP 7 – Personnalisation graphique (Material Design 3 & Thème)
- **Palettes de couleurs** : Définition des couleurs `LightColorScheme` et `DarkColorScheme` dans `Theme.kt`.
- **Formes & Typographie** : `ProductShapes` et `ProductTypography`.
- **Multi-Thème** : Prise en charge automatique du Mode Sombre (*Dark Theme*) et du Mode Clair (*Light Theme*).

### TP 8 – Rendre le catalogue interactif (State Management)
- **États réactifs** : Utilisation de `mutableStateOf` et `rememberSaveable` pour capturer la recherche textuelle, le filtre par stock et la liste de favoris.

### TP 9 – Refactorer avec le State Hoisting (Stateful vs Stateless)
- **Séparation des responsabilités** :
  - **Composant Stateful (`ProductCatalogContainer`)** : Conserve l'état.
  - **Composant Stateless (`ProductCatalogScreen`)** : Ne possède aucun état (*Data down, Events up*).

### TP 10 – Gestion d'écran avec ViewModel (Architecture Android)
- **ViewModel** : Création de `ProductCatalogViewModel` héritant de `ViewModel()` pour conserver l'état lors de la récréation de l'écran (ex: rotation du téléphone).

### TP 11 – Mise à jour dynamique avec StateFlow (Programmation Réactive)
- **Classe d'état globale (`ProductCatalogUiState`)** : Regroupement de toutes les variables d'état de l'écran (`products`, `categories`, `searchQuery`, `showOnlyInStock`, `favoriteProductIds`) dans un seul objet immuable.
- **`StateFlow` & `MutableStateFlow`** : Le `ViewModel` expose un `StateFlow<ProductCatalogUiState>` en lecture seule (`asStateFlow()`).
- **Mises à jour atomiques avec `.update { currentState -> currentState.copy(...) }`** : Modification sécurisée de l'état UI.
- **Collecte réactive dans Compose (`collectAsState()`)** : `ProductCatalogContainer` s'abonne au `StateFlow` via `viewModel.uiState.collectAsState()` pour redessiner l'interface automatiquement à chaque changement.

---

## Résumé de l'architecture globale

```text
MainActivity (Point d'entrée)
  └── ProductCatalogContainer (Collecte le StateFlow avec collectAsState())
        └── ProductCatalogViewModel (Expose StateFlow<ProductCatalogUiState>)
              └── ProductCatalogUiState (Data Class décrivant l'état UI)
        └── ProductCatalogScreen (Stateless - Dessine la LazyColumn)
              ├── CategoryRow (LazyRow)
              │     └── CategoryChip
              └── ProductListItem (Card - Dessine un produit)
```

- **UI Déclarative** : Jetpack Compose (`@Composable`)
- **Programmation Réactive** : Kotlin Coroutines & `StateFlow` (`collectAsState()`)
- **Design System** : Material Design 3 (Thèmes, Typographies, Formes)
- **Architecture Officielle Android** : Unidirectional Data Flow (UDF) avec `ViewModel`, `StateFlow` et **State Hoisting**
- **Listes performantes** : `LazyColumn` & `LazyRow` avec clés d'identification uniques.