package kh.com.vireak.developer.basic.myfirstapplicationfordemo.feature

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.vireak.developer.basic.myapplicationbackup.R
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.ui.theme.MyFirstApplicationForDemoTheme
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactUsScreen(
    onNavigateToHome: () -> Unit = {}
){

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onNavigateToHome) {
                        Icon(
                            painter = painterResource(R.drawable.ic_backward_arrow),
                            contentDescription = "Back",
                        )
                    }
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text(text = "Contact Us") },
            )
        },
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(140.dp),
                    painter = painterResource(R.drawable.ic_contact),
                    contentDescription = null
                )
            }

            Text(
                text = "Contact Us By",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 2.dp)
            )
            Card(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                )
            ) {
                Column(modifier = Modifier.padding(vertical = 20.dp)) {

                    Row(
                        modifier = Modifier.padding(start = 8.dp)
                    ){
                        Icon(
                            modifier = Modifier.size(32.dp),
                            painter = painterResource(R.drawable.ic_contact),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = "phone: 0715096889",
                            fontSize = 20.sp
                        )

                    }
                    HorizontalDivider(
                        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                    )
                    Row(
                        modifier = Modifier.padding(start = 8.dp)
                    ){
                        Icon(
                            modifier = Modifier.size(32.dp),
                            painter = painterResource(R.drawable.ic_telegram),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = "telegram: 0715096889",
                            fontSize = 20.sp
                        )

                    }


                    HorizontalDivider(
                        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                    )
                    Row(
                        modifier = Modifier.padding(start = 8.dp)
                    ){
                        Icon(
                            modifier = Modifier.size(32.dp),
                            painter = painterResource(R.drawable.ic_fb2),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = "facebook: Vireak Phheung",
                            fontSize = 20.sp
                        )

                    }
                    HorizontalDivider(
                        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                    )
                    Row(
                        modifier = Modifier.padding(start = 8.dp)
                    ){
                        Icon(
                            modifier = Modifier.size(32.dp),
                            painter = painterResource(R.drawable.ic_mail),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = "email: @vireakpheung@gmail.com",
                            fontSize = 20.sp
                        )

                    }

                }
            }
        }


    }


}

@Preview(showBackground = false)
@Composable
fun ContactUsScreenPreview(){
    MyFirstApplicationForDemoTheme() {
        ContactUsScreen()
    }
}