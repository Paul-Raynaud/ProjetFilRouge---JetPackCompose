package com.example.productexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.productexplorer.ui.theme.ProductExplorerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProductExplorerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProductDetailScreen(
                        product = sampleProduct(), // On appelle notre fonction créée tout à l'heure
                        onAddToCartClick = {
                            // Action à ajouter plus tard
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ProductDetailScreen(
    product: ProductUi,
    onAddToCartClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ProductHeader(
            title = product.title,
            brand = product.brand,
            category = product.category
        )
        ProductPriceCard(
            price = product.price,
            discountPercentage = product.discountPercentage,
            modifier = Modifier
                .fillMaxWidth() // <-- N'oublie pas d'importer fillMaxWidth
                .padding(top = 16.dp)
        )
        Text(text = product.description)
        Button(onClick = onAddToCartClick) {
            Text(text = "Ajouter au panier")
        }
    }
}

@Composable
fun ProductHeader(
    title: String,
    brand: String,
    category: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = title, style = MaterialTheme.typography.headlineSmall)
        Text(text = brand, style = MaterialTheme.typography.titleMedium)
        Text(text = category, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun ProductPriceCard(
    price: Double,
    discountPercentage: Double,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "$price €",
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = "Remise : $discountPercentage %",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}