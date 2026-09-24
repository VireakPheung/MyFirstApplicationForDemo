package kh.com.vireak.developer.basic.myfirstapplicationfordemo.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.vireak.developer.basic.myapplicationbackup.R
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.ui.theme.CardGradient
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.ui.theme.GridContainerBackground
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.ui.theme.SoftGreenMint
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.ui.theme.SoftGreenMuted
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.ui.theme.SoftGreenPastel
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.ui.theme.SoftGreenSage

data class GridModel(
    val label: String,
    @DrawableRes val logo: Int,
)

@Composable
fun GridItem() {
    val gridItems = listOf(
        GridModel(label = "Scan", logo = R.drawable.ic_scan),
        GridModel(label = "Transfer", logo = R.drawable.ic_transfer2),
        GridModel(label = "Account", logo = R.drawable.ic_wallet),
        GridModel(label = "Payment", logo = R.drawable.ic_payment),
        GridModel(label = "Card", logo = R.drawable.ic_card),
        GridModel(label = "Favorite", logo = R.drawable.ic_favorite)
    )
    
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = GridContainerBackground,
                shape = RoundedCornerShape(16.dp)
            ),

        content = {
            items(gridItems.size) { index ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .height(110.dp)
                        .shadow(
                            elevation = 16.dp,
                            shape = RoundedCornerShape(16.dp),
                            clip = false,
                            ambientColor = Color(0xFF0B4B3A).copy(alpha = 0.25f), // green-tinted
                            spotColor = Color(0xFF0B4B3A).copy(alpha = 0.35f)
                        ),
                    onClick = {

                    },
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    ),



                ) {
                    Box(
                        modifier = Modifier
                            .background(color = SoftGreenMint)
                            .fillMaxSize()
                    ){

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(40.dp),
                                painter = painterResource(gridItems[index].logo),
                                contentDescription = null,
                                tint = Color.White
                            )
                            Text(
                                text = gridItems[index].label,
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 4.dp)
                            )
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GridItemPreview() {
    MaterialTheme {
        GridItem()
    }
}
