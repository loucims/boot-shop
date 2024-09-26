package com.example.challenge_botas.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.challenge_botas.R
import com.example.challenge_botas.data.BootData
import com.example.challenge_botas.ui.theme.OrangeBrown
import com.example.challenge_botas.ui.theme.Typography
import com.example.challenge_botas.ui.theme.WarmWhite
import com.example.challenge_botas.ui.theme.White
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BootsListScreen(onBuyClick: () -> Unit, modifier: Modifier = Modifier) {

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val items = listOf(
        BootData(
            imageUrl = "https://example.com/image.jpg",
            title = "Leather boots",
            price = "27.5",
            description = "Great warm shoes from the artificial leather. You can buy this model only in our shop"
        ),
        BootData(
            imageUrl = "https://example.com/image.jpg",
            title = "Leather boots",
            price = "27.5",
            description = "Great warm shoes from the artificial leather. You can buy this model only in our shop"
        ),
        BootData(
            imageUrl = "https://example.com/image.jpg",
            title = "Leather boots",
            price = "27.5",
            description = "Great warm shoes from the artificial leather. You can buy this model only in our shop"
        ),
        BootData(
            imageUrl = "https://example.com/image.jpg",
            title = "Leather boots",
            price = "27.5",
            description = "Great warm shoes from the artificial leather. You can buy this model only in our shop"
        ),
        // Add more items here
    )


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Box(
                modifier = Modifier
                    .width(250.dp)
                    .background(White)
                    .fillMaxHeight()
                    .padding(5.dp, 25.dp),
            ) {
                Text(text = "Menu")
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Shop List")
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    },
                    actions = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.AccountCircle, contentDescription = "Menu")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = White
                    )
                )
            },
            content = { padding ->
                Box(modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .background(WarmWhite))
                {
                    BootsList(onBuyClick, items = items)
                }
            }
        )
    }
}


@Composable
fun BootsList(onBuyClick: () -> Unit, items: List<BootData>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(items) { item ->
            BootsItem(onBuyClick, item)
        }
    }
}


@Composable
fun BootsItem(onBuyClick: () -> Unit, item: BootData) {
    Card(
        modifier = Modifier.width(350.dp),
        elevation = CardDefaults.cardElevation(16.dp),
    ) {
        Column(modifier = Modifier.background(White)) {
            Image(
                painter = painterResource(id = R.drawable.bota_imagen),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
                    .padding(15.dp, 0.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Column (verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text(text = "Leather boots", style = Typography.bodyLarge.copy(fontWeight = FontWeight.Bold))
                    Text(text = "23.5$", style = Typography.bodyMedium)
                }

            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(85.dp)
                    .padding(15.dp, 0.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = "Great warm shoes from the artificial leather. You can buy this model only in our shop",
                    style = Typography.bodyLarge
                )
            }
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(10.dp, 0.dp),
                contentAlignment = Alignment.CenterEnd

            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    OutlinedButton(
                        modifier = Modifier.width(150.dp),
                        onClick = { /* TODO: Add to favourite */ },
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = OrangeBrown),
                        border = BorderStroke(1.dp, OrangeBrown)
                    ) {
                        Text("Add to favourite")
                    }

                    Button(
                        modifier = Modifier.width(75.dp),
                        onClick = { onBuyClick() },
                        colors = ButtonDefaults.buttonColors(containerColor = OrangeBrown)
                    ) {
                        Text("Buy", color = White)
                    }
                }
            }
        }
    }
}