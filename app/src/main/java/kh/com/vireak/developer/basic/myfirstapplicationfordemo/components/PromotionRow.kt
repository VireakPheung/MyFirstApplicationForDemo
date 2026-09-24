package kh.com.vireak.developer.basic.myfirstapplicationfordemo.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.com.vireak.developer.basic.myapplicationbackup.R
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.ui.theme.GridContainerBackground


data class ItemModel(
    val id: Int,
    @DrawableRes val image: Int,
)
@Composable
fun PromotionRow(

){
    val ItemRowList = listOf(
        ItemModel(
            id = 1,
            image = R.drawable.promotion3
        ),
        ItemModel(
            id = 2,
            image = R.drawable.promotion4
        ),
        ItemModel(
            id = 3,
            image = R.drawable.promotion5
        ),
        ItemModel(
            id = 4,
            image = R.drawable.promotion6
        ),
        ItemModel(
            id = 5,
            image = R.drawable.abaprromotion2
        )
    )
    LazyRow(
        modifier = Modifier
            .background(color = GridContainerBackground)
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        ItemRowList.forEachIndexed { index, model ->
            item{
                Box(
                    modifier = Modifier
                        .size(110.dp)
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(16.dp)),

                ){
                    Image(
                        modifier = Modifier
                            .fillMaxSize(),
                        painter = painterResource(model.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun PromotionRowPreview(){
    PromotionRow()
}