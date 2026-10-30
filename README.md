# Product Explorer

## Présentation du projet
**Product Explorer** est une application Android moderne développée entièrement avec **Jetpack Compose**. 

L'objectif de cette application est de simuler une interface de type "catalogue e-commerce", permettant à l'utilisateur de découvrir des produits, de faire des recherches (visuelles pour l'instant) et de consulter les détails d'un article spécifique. 

*Note : L'application est actuellement développée dans le cadre de Travaux Pratiques (TP) d'apprentissage. Les données sont pour l'instant "en dur" (locales) et aucune véritable navigation ou requête réseau n'est implémentée.*

## Fonctionnalités actuelles

L'application est composée de deux écrans principaux :

### 1. L'écran d'accueil (`ProductHomeScreen` - TP5)
C'est le point d'entrée actuel de l'application. Il est construit en empilant différentes sections à l'aide de Layouts Compose (`Column`, `Row`, `Box`, `Spacer`, `Surface`).
- **En-tête** : Titre et sous-titre de bienvenue.
- **Barre de recherche** : Une fausse barre de recherche stylisée.
- **Produit mis en avant** : Une carte détaillée mettant en vedette un produit (titre, marque, prix, note, stock).
- **Catégories** : Une ligne horizontale de badges (chips) représentant les catégories (Smartphones, Audio, Maison).
- **Offre du jour** : Une bannière promotionnelle avec un badge "Nouveau" superposé grâce au composant `Box`.

### 2. L'écran de détail produit (`ProductDetailScreen` - TP4)
Cet écran (actuellement visible via les `@Preview` ou en modifiant le point d'entrée dans `MainActivity`) affiche la fiche complète d'un produit. Il a été conçu pour manipuler les composants de base de Jetpack Compose.
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
- **Composants réutilisables (Lego)** : Plutôt que d'avoir des fonctions géantes, l'interface est découpée en petits morceaux réutilisables (ex: `ProductHeader`, `ProductPriceCard`, `CategoryChip`). Chaque composant reçoit uniquement les données dont il a besoin, favorisant la lisibilité et la maintenance du code.
- **Modèle de données** : Une `data class ProductUi` est utilisée pour transporter les informations du produit vers l'interface. Les fonctions `sampleProduct()` et `sampleProductOutOfStock()` fournissent des données fictives pour les tests et les prévisualisations.
- **Material Design 3** : Le projet utilise les standards visuels d'Android (`MaterialTheme.typography`, `MaterialTheme.shapes`, `Surface`, etc.) et la librairie `material-icons-extended` pour les icônes de base.


---
*Ce fichier sera mis à jour au fur et à mesure de l'avancement du projet.*