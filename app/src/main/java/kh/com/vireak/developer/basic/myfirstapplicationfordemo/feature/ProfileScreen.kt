package kh.com.vireak.developer.basic.myfirstapplicationfordemo.feature

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

data class InformationModel(
    val id: Int,
    val label: String,
    @DrawableRes val icon: Int,
    val value: String
)
@Composable
fun ProfileScreen(
    onNavigateToHomeScreen: () -> Unit = {}
){
    val InfoList = listOf(
        InformationModel(
            id = 1,
            label = "First Name",
            icon = R.drawable.ic_pfp,
            value = "Vireak"
        ),
        InformationModel(
            id = 2,
            label = "Last Name",
            icon = R.drawable.ic_pfp,
            value = "Pheong"
        ),
        InformationModel(
            id = 3,
            label = "Cambodian NID",
            icon = R.drawable.ic_id,
            value = "123456789"
        ),
        InformationModel(
            id = 4,
            label = "Date Of Birth",
            icon = R.drawable.ic_dob,
            value = "12/12/2000"
        ),
        InformationModel(
            id = 5,
            label = "Registered Phone Number",
            icon = R.drawable.ic_contact,
            value = "0912345678"
        ),
    )
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {paddingValues ->
        Surface(
            modifier = Modifier
                .padding(8.dp),
            color = MaterialTheme.colorScheme.surface,
            shadowElevation = 32.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                IconButton(
                    onClick = onNavigateToHomeScreen
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_backward_arrow),
                        contentDescription = null
                    )

                }
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .height(210.dp),
                    colors = CardDefaults.elevatedCardColors(MaterialTheme.colorScheme.primaryContainer)

                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(end = 16.dp)

                        ){
                            Text(
                                modifier = Modifier
                                    .padding(8.dp),
                                text = "PHEONG VIREAK",
                                fontSize =24.sp,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                modifier = Modifier
                                    .padding(8.dp),
                                text = "Currently Learning MIS Y2,\nSetec Institute",
                                fontSize =16.sp,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                modifier = Modifier
                                    .padding(8.dp),
                                text = "11 September 2026",
                                fontSize =14.sp,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )
                        }


                        Box(
                            modifier = Modifier
                                .padding(end = 16.dp)
                                .size(160.dp)
                                .clip(RoundedCornerShape(78.dp))
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

                    }


                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = "Personal Detail",
                        fontSize =24.sp,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    InfoList.forEach { info ->
                        InformationField(info = info)
                    }
                }


            }



        }

    }
}


@Composable
fun InformationField(
    info: InformationModel
){

    HorizontalDivider()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(info.icon),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .padding(end = 12.dp)
        )

        Column(
            modifier = Modifier
                .height(60.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = info.label,
                style = MaterialTheme.typography.labelMedium,
                fontSize = 12.sp
            )
            Text(
                text = info.value,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 20.sp
            )
        }

    }
    HorizontalDivider()
}


@Preview(showBackground = false)
@Composable
fun ProfileScreenPreview(){
    ProfileScreen()
}