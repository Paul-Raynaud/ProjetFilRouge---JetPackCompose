# Product Explorer

## Présentation du projet
**Product Explorer** est une application Android moderne développée entièrement avec **Jetpack Compose**. 

L'objectif de cette application est de simuler une interface de type "catalogue e-commerce", permettant à l'utilisateur de découvrir des produits, de faire des recherches (visuelles pour l'instant) et de consulter les détails d'un article spécifique. 

*Note : L'application est actuellement développée dans le cadre de Travaux Pratiques (TP) d'apprentissage. Les données sont pour l'instant "en dur" (locales) et aucune véritable navigation ou requête réseau n'est implémentée.*

## Fonctionnalités actuelles

L'application est composée de trois écrans principaux :

### 1. Le catalogue de produits (`ProductCatalogScreen` - TP6 & TP7)
C'est le point d'entrée actuel de l'application. Il affiche un catalogue complet en utilisant les listes performantes de Compose, entièrement stylisé avec Material Design 3.
- **Thème dynamique** : Support natif du mode Clair et du mode Sombre grâce à `MaterialTheme.colorScheme`.
- **En-tête du catalogue** : Un titre et une courte description stylisés avec une typographie personnalisée.
- **Catégories (Défilement horizontal)** : Utilisation de `LazyRow` pour afficher une liste de catégories (Smartphones, Audio, etc.). Les badges utilisent des formes (`Shapes`) très arrondies.
- **Liste des produits (Défilement vertical)** : Utilisation de `LazyColumn` pour afficher tous les produits.
- **Cartes produits (`ProductListItem`)** : Chaque produit est affiché dans une carte dont le fond, l'élévation (ombre) et les textes utilisent les couleurs et typographies définies dans le thème global.

### 2. L'écran d'accueil (`ProductHomeScreen` - TP5)
*(Actuellement visible via les `@Preview`)*
Un écran d'accueil structuré avec différents Layouts (`Column`, `Row`, `Box`, `Spacer`, `Surface`).
- **Barre de recherche** : Une fausse barre de recherche stylisée.
- **Produit mis en avant** : Une carte détaillée mettant en vedette un produit.
- **Catégories** : Une ligne horizontale statique de badges.
- **Offre du jour** : Une bannière promotionnelle avec un badge "Nouveau" superposé grâce au composant `Box`.

### 3. L'écran de détail produit (`ProductDetailScreen` - TP4)
*(Actuellement visible via les `@Preview`)*
Cet écran affiche la fiche complète d'un produit. 
- **Image** : Un espace réservé (placeholder) pour la photo.
- **Prix, Remise et Disponibilité** : Mise en évidence dans des cartes (`Card`).
- **Garantie** : Information affichée dans un champ de texte en lecture seule (`OutlinedTextField`).
- **Action** : Bouton d'ajout au panier.

## Architecture et Code (Démarche d'apprentissage)

- **UI Déclarative** : L'interface est entièrement codée en Kotlin (`@Composable`).
- **Material Design 3 (Personnalisation du Thème)** : Centralisation du design dans les fichiers `Theme.kt` et `Type.kt`. L'application utilise des palettes de couleurs personnalisées (`LightColorScheme` / `DarkColorScheme`), des formes spécifiques (`Shapes`) et une hiérarchie textuelle (`Typography`).
- **Listes performantes (Lazy Layouts)** : Utilisation de `LazyColumn` et `LazyRow`.
- **Composants réutilisables** : L'interface est découpée en petits composants.

## Prochaines étapes prévues
- Ajout de la navigation réelle entre le catalogue et l'écran de détail.
- Gestion de l'état (State) pour rendre l'application interactive.