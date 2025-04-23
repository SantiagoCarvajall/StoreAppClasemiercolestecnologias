package me.santiagocarvajal.StoreApp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import me.santiagocarvajal.StoreApp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        topBar = {
            MediumTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "Bienvenido",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Promociones destacadas",
                modifier =  Modifier.padding(
                    start = 16.dp,
                    top = 16.dp,
                    bottom = 8.dp
                ))

            val urlImages = listOf(
                "https://static.vecteezy.com/system/resources/previews/002/283/587/original/super-sale-banner-with-lighting-illustration-trendy-colorful-blue-background-business-product-ads-promotion-template-vector.jpg",
                "https://thumbs.dreamstime.com/z/dise%C3%B1o-de-plantillas-banner-s%C3%BAper-venta-para-promociones-medios-y-promoci%C3%B3n-sociales-fondo-183029584.jpg",
                "https://png.pngtree.com/png-clipart/20230620/original/pngtree-special-promo-banner-shape-for-promotion-of-your-business-vector-png-image_9192296.png",
                "https://png.pngtree.com/png-clipart/20200727/original/pngtree-purple-geometric-lightning-promotion-commercial-banner-png-image_5425460.jpg",
                "https://th.bing.com/th/id/OIP.VgZ1ceTrZ_E31u0lEilZpgHaHa?rs=1&pid=ImgDetMain",
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
            ) {
                item {PromoCard(urlImages[0])}
                item {PromoCard(urlImages[1])}
                item {PromoCard(urlImages[2])}
                item {PromoCard(urlImages[3])}
                item {PromoCard(urlImages[4])}
            }

        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()

}


@Composable
fun PromoCard(urlImage: String) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(180.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(urlImage),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
    }

}