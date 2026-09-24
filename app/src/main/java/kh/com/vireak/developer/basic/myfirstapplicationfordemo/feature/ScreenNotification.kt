package kh.com.vireak.developer.basic.myfirstapplicationfordemo.feature

import android.icu.text.UnicodeSetIterator
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.com.vireak.developer.basic.myapplicationbackup.R
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.ui.theme.MyFirstApplicationForDemoTheme
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.util.NavigationKey

data class Transaction(
    val merchant: String,
    val amount: Double,
    val account: String,
    val time: String,
    val date: String,
    val logo: Int
)



val transactionList = listOf(

    // 31 JUL 2026
    Transaction("Morning Cafe", 12000.0, "013 850 231", "8:10 AM", "31 JUL 2026", R.drawable.ic_store2),
    Transaction("Fresh Mart", 35500.0, "013 850 231", "9:45 AM", "31 JUL 2026", R.drawable.ic_store2),
    Transaction("Sky Laundry", 7000.0, "013 850 231", "11:20 AM", "31 JUL 2026", R.drawable.ic_store2),
    Transaction("City Bakery", 9500.0, "013 850 231", "1:05 PM", "31 JUL 2026", R.drawable.ic_store2),
    Transaction("Coffee Point", 14000.0, "013 850 231", "4:30 PM", "31 JUL 2026", R.drawable.ic_store2),

    // 30 JUL 2026
    Transaction("Happy Noodles", 18000.0, "013 850 231", "8:30 AM", "30 JUL 2026", R.drawable.ic_store2),
    Transaction("Blue Pharmacy", 27500.0, "013 850 231", "9:55 AM", "30 JUL 2026", R.drawable.ic_store2),
    Transaction("Quick Print", 15000.0, "013 850 231", "11:15 AM", "30 JUL 2026", R.drawable.ic_store2),
    Transaction("Sunrise Cafe", 9500.0, "013 850 231", "12:40 PM", "30 JUL 2026", R.drawable.ic_store2),
    Transaction("Green Grocery", 42000.0, "013 850 231", "3:10 PM", "30 JUL 2026", R.drawable.ic_store2),

    // 29 JUL 2026
    Transaction("Book Corner", 21000.0, "013 850 231", "9:05 AM", "29 JUL 2026", R.drawable.ic_store2),
    Transaction("Tech Station", 98000.0, "013 850 231", "10:20 AM", "29 JUL 2026", R.drawable.ic_store2),
    Transaction("Family Mart", 8500.0, "013 850 231", "12:55 PM", "29 JUL 2026", R.drawable.ic_store2),
    Transaction("BBQ House", 56000.0, "013 850 231", "6:40 PM", "29 JUL 2026", R.drawable.ic_store2),
    Transaction("Movie World", 30000.0, "013 850 231", "8:15 PM", "29 JUL 2026", R.drawable.ic_store2),

    // 28 JUL 2026
    Transaction("Fresh Juice", 10000.0, "013 850 231", "7:45 AM", "28 JUL 2026", R.drawable.ic_store2),
    Transaction("Stationery Hub", 22000.0, "013 850 231", "10:10 AM", "28 JUL 2026", R.drawable.ic_store2),
    Transaction("Pizza Corner", 48000.0, "013 850 231", "1:35 PM", "28 JUL 2026", R.drawable.ic_store2),
    Transaction("Laundry Express", 6000.0, "013 850 231", "4:20 PM", "28 JUL 2026", R.drawable.ic_store2),
    Transaction("Mini Market", 19500.0, "013 850 231", "7:10 PM", "28 JUL 2026", R.drawable.ic_store2),

    // 27 JUL 2026
    Transaction("Campus Cafe", 11000.0, "013 850 231", "8:25 AM", "27 JUL 2026", R.drawable.ic_store2),
    Transaction("Fruit Market", 26500.0, "013 850 231", "10:45 AM", "27 JUL 2026", R.drawable.ic_store2),
    Transaction("Ice Cream Bar", 9000.0, "013 850 231", "2:15 PM", "27 JUL 2026", R.drawable.ic_store2),
    Transaction("Burger Time", 34000.0, "013 850 231", "5:50 PM", "27 JUL 2026", R.drawable.ic_store2),
    Transaction("Night Coffee", 13000.0, "013 850 231", "8:30 PM", "27 JUL 2026", R.drawable.ic_store2),

    // 26 JUL 2026
    Transaction("Fashion Shop", 75000.0, "013 850 231", "9:40 AM", "26 JUL 2026", R.drawable.ic_store2),
    Transaction("Flower Garden", 16000.0, "013 850 231", "11:30 AM", "26 JUL 2026", R.drawable.ic_store2),
    Transaction("Sushi Place", 68000.0, "013 850 231", "2:10 PM", "26 JUL 2026", R.drawable.ic_store2),
    Transaction("Bike Service", 45000.0, "013 850 231", "5:15 PM", "26 JUL 2026", R.drawable.ic_store2),
    Transaction("Late Night Mart", 12500.0, "013 850 231", "9:20 PM", "26 JUL 2026", R.drawable.ic_store2)
)

@Composable
fun TransactionItem(transaction: Transaction) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(32.dp, 32.dp, 32.dp, 32.dp)
                    )
            ){
                Image(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(30.dp),
                    painter = painterResource(transaction.logo),
                    contentDescription = null,

                    )
            }
            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = transaction.merchant,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "${transaction.amount} KHR ចេញពីគណនី ${transaction.account}"
                )
            }

            Text(transaction.time)
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenNotification(
    onNavigateToHome: () -> Unit ={}
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
                title = { Text(text = "Security") },
            )

        }
    ) {paddingValues ->

        LazyColumn (
            modifier = Modifier.padding(paddingValues)
        ){
            items(transactionList){transaction ->
                TransactionItem(transaction)

            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun TransactionPreview(){
    MyFirstApplicationForDemoTheme() {
        ScreenNotification()
    }
}