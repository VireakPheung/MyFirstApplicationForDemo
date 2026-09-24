import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.vireak.developer.basic.myapplicationbackup.R
import kotlinx.coroutines.launch

data class ItemModel(
    val id: Int,
    val label: String,
    @DrawableRes val icon: Int
)

@Composable
fun NavigationDrawer (
    onNavigateToTermAndConditionScreen: () -> Unit ={},
    onNavigateToContactUsScreen: () -> Unit = {},
    onNavigateToSecurityScreen: () -> Unit = {},
    onNavigateToProfileScreen: () -> Unit = {},
    drawerState: DrawerState,
    content: @Composable () -> Unit = {}
){
    var selectedId by remember{ mutableIntStateOf(0) }
    var isDrawerContentActive by remember { mutableStateOf(true) }
    val scope = rememberCoroutineScope()
    val drawerItem = listOf(
        ItemModel(
            id = 1,
            label = "My Background",
            icon = R.drawable.ic_pfp
        ),
        ItemModel(
            id = 2,
            label = "Security",
            icon = R.drawable.ic_security
        ),
        ItemModel(
            id = 3,
            label = "Language",
            icon = R.drawable.ic_language
        ),
        ItemModel(
            id = 4,
            label = "Contact Us",
            icon = R.drawable.ic_contact
        ),
        ItemModel(
            id = 5,
            label = "Term & Condition",
            icon = R.drawable.ic_card
        ),
    )


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                windowInsets = WindowInsets(0)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .statusBarsPadding()
                        .height(180.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(0.dp)
                        ),
                    contentAlignment = Alignment.BottomStart
                ){

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(8.dp)
                                .size(100.dp)
                                .clip(RoundedCornerShape(48.dp))
                                .background(
                                    color = Color.DarkGray
                                ),
                        ){
                            Image(
                                painter = painterResource(R.drawable.img1),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )

                        }
                        Text(
                            modifier = Modifier.padding(end = 16.dp, bottom = 12.dp),
                            text = "Pheong Vireak",
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = Color.Black,
                            textAlign = TextAlign.End
                        )

                    }


                }
                HorizontalDivider()

                drawerItem.forEach { item ->

                    NavigationDrawerItem(
                        icon = {
                            Icon(
                                painter = painterResource(item.icon),
                                contentDescription = null
                            )
                        },
                        shape = RoundedCornerShape(0.dp),
                        selected = selectedId == item.id,
                        label = {
                            Text(
                                text = item.label
                            )
                        },
                        onClick = {
                            if (item.id == 1){
                                onNavigateToProfileScreen()
                            }else if(item.id == 2){
                                onNavigateToSecurityScreen()
                            }else if(item.id == 4){
                                onNavigateToContactUsScreen()
                            }else if(item.id == 5){
                                onNavigateToTermAndConditionScreen()
                            }
                            selectedId = item.id
                            isDrawerContentActive = true
                            scope.launch { drawerState.close() }
                        }

                    )
                    HorizontalDivider()

                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier.padding( 8.dp),
                    text = "Build By Vireak",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Date, Year 1",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    ) {
        content()
    }

}

@Preview(showBackground = false)
@Composable
fun NavigationDrawerPreview(){
    NavigationDrawer(
        drawerState = rememberDrawerState(DrawerValue.Open)
    )
}
