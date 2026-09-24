package kh.com.vireak.developer.basic.myfirstapplicationfordemo.feature

import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import NavigationDrawer
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.vireak.developer.basic.myapplicationbackup.R
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.components.BalanceCard
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.components.CardModel
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.components.GridItem
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.components.PromotionRow
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.ui.theme.CardGradient
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.ui.theme.GradientGreenMid
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.ui.theme.GridContainerBackground
import kotlinx.coroutines.launch

data class NavigationModel(
    val id: String,
    @DrawableRes val icon: Int,
    val label: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToNotificationScreen: () -> Unit = {},
    onNavigateToTermAndCondition: () -> Unit = {},
    onNavigateToContact: () -> Unit = {},
    onNavigateToSignUp: () -> Unit = {},
    onNavigateToProfile: () -> Unit = {},
    onNavigateToSecurity: () -> Unit = {}
) {
    val PurplePrimary = Color(0xFF8A6FD1)
    val PurpleDark = Color(0xFF6A4FB5)

    var selectedNavId by remember { mutableStateOf("01") }
    val navigationItem = listOf(
        NavigationModel(
            id = "01",
            icon = R.drawable.ic_home__2_,
            label = "Home"
        ),
        NavigationModel(
            id = "02",
            icon = R.drawable.ic_scan,
            label = ""
        ),
        NavigationModel(
            id = "03",
            icon = R.drawable.ic_menu,
            label = "Menu"
        ),
    )
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    
    NavigationDrawer(
        onNavigateToTermAndConditionScreen = onNavigateToTermAndCondition,
        onNavigateToContactUsScreen = onNavigateToContact,
        onNavigateToSecurityScreen = onNavigateToSecurity,
        onNavigateToProfileScreen = onNavigateToProfile,
        drawerState = drawerState
    ) {
        Scaffold(
            modifier = Modifier.background(
                color = Color.LightGray
            ),
            topBar = {
                MediumTopAppBar(
                    title = {
                        Text(
                            text = "Maynard Bank",
                            fontSize = 26.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = Color.Transparent,
                        titleContentColor = Color.White
                    ),
                    modifier = Modifier
                        .background(
                            brush = CardGradient,
                            shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
                        )
                        .shadow(
                            elevation = 4.dp,
                            shape = RoundedCornerShape(bottomStart = 28.dp, bottomEnd = 28.dp),
                            clip = false
                        ),
                    actions = {
                        IconButton(
                            onClick = onNavigateToNotificationScreen,
                            modifier = Modifier.padding(end = 8.dp)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_notification),
                                contentDescription = "Alert",
                                tint = Color.White,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                )
            },
            bottomBar = {
                NavigationBar(
                    containerColor = GridContainerBackground
                ) {
                    navigationItem.forEach { item2 ->
                        NavigationBarItem(
                            onClick = {
                                if (item2.label == "Menu") {
                                    scope.launch { drawerState.open() }
                                }else if(item2.label == "Notification"){
                                    onNavigateToNotificationScreen()
                                }else {
                                    selectedNavId = item2.id
                                }
                            },
                            label = {
                                Text(
                                    text = item2.label
                                )
                            },
                            icon = {
                                if (item2.id == "02"){
                                    Box(
                                        modifier = Modifier
                                            .size(90.dp)
                                            .clip(RoundedCornerShape(40.dp))
                                            .background(Color.White),
                                        contentAlignment = Alignment.Center
                                    ){
                                        Box(
                                            modifier = Modifier
                                                .size(80.dp)
                                                .clip(RoundedCornerShape(38.dp))
                                                .background(brush = CardGradient),
                                            contentAlignment = Alignment.Center
                                        ){
                                            Icon(
                                                modifier = Modifier.size(36.dp),
                                                tint = Color.White,
                                                painter = painterResource(item2.icon),
                                                contentDescription = null
                                            )

                                        }
                                    }
                                }else{
                                    Icon(
                                        modifier = Modifier.background(color = GridContainerBackground),
                                        painter = painterResource(item2.icon),
                                        contentDescription = item2.label,
                                        tint = Color.Black,
                                    )
                                }
                            },
                            selected = selectedNavId == item2.id,
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = GradientGreenMid,
                                unselectedIconColor = Color.Black,
                                indicatorColor = GridContainerBackground,
                                selectedTextColor = GradientGreenMid,
                                unselectedTextColor = Color.Black
                            )
                        )
                    }
                }
            }
        ) { paddingValue ->
            Column(
                modifier = Modifier.padding(paddingValue),
                verticalArrangement = Arrangement.Center
            ) {
                BalanceCard(
                    card = CardModel(
                        balance = "5000$",
                        image = R.drawable.img1,
                        userName = "Pheong Vireak"
                    ),
                    onProfileClick = {
                        scope.launch { drawerState.open() }
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    GridItem()
                }
                Text(
                    text = "Promotion",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 16.dp),
                    textAlign = TextAlign.Start
                )

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .height(120.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    ),
                ) {
                    PromotionRow()
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
