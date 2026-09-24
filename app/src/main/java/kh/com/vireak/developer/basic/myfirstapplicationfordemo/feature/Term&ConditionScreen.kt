package kh.com.vireak.developer.basic.myfirstapplicationfordemo.feature

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.vireak.developer.basic.myapplicationbackup.R
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.ui.theme.MyFirstApplicationForDemoTheme

data class ParagraphModel(
    val id: Int,
    val title: String,
    val description: String
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TermAndConditionScreen(
    onNavigateToHome: () -> Unit = {}
){
    val paragraphList = listOf(
        ParagraphModel(
            id = 1,
            title = "1. About This App",
            description = "Maynard Bank is a demo/portfolio application developed for educational" +
                    " and internship application purposes. It is a frontend prototype built with " +
                    "navigation flow and local state management (e.g., moving between Sign Up, Home, " +
                    "Profile, and Drawer screens, and reflecting in-app interactions). It does not " +
                    "connect to any real banking system, backend server, or financial institution, " +
                    "and does not persist data beyond the current app session."
        ),
        ParagraphModel(
            id = 2,
            title = "2. No Real Financial Services",
            description = "Maynard Bank does not provide, facilitate, or represent any real banking," +
                    " payment, or financial service. Any balance, transaction, or account information" +
                    " displayed within the app is static, mock, or placeholder data used solely to" +
                    " demonstrate design and interaction concepts."
        ),
        ParagraphModel(
            id = 3,
            title = "3. No Data Collection",
            description = "This app does not collect, store, transmit, or process any real personal " +
                    "or financial user data. This includes but is not limited to:\n" +
                    "\n" +
                    "Login credentials entered on the Sign Up / Sign In screen\n" +
                    "Profile or portfolio information\n" +
                    "Balance or transaction details\n" +
                    "\n" +
                    "Any information entered into the app (e.g., during sign-up) is used only " +
                    "locally, for the current session, and is not saved, uploaded, or shared with " +
                    "any third party or server, as the app currently has no backend integration. " +
                    "The app does make use of in-app navigation logic and local state management " +
                    "(e.g., to move between screens such as Sign Up, Home, Profile, and the " +
                    "navigation drawer, and to reflect temporary UI states), but this state exists " +
                    "only in-memory during app use and is cleared once the app is closed.\n" +
                    "\n"
        ),
        ParagraphModel(
            id = 4,
            title = "4. Intended Use",
            description = "This app is intended for:\n" +
                    "\n" +
                    "Demonstration purposes\n" +
                    "Academic or internship evaluation\n" +
                    "UI/UX design showcase\n" +
                    "\n" +
                    "It is not intended for production use, real-world deployment, " +
                    "or handling of actual financial transactions.\n"
        ),
        ParagraphModel(
            id = 5,
            title = "5. No Warranty",
            description = "Maynard Bank is provided \"as is,\" without warranty of any kind, " +
                    "express or implied. As a demo application, it may contain incomplete features, " +
                    "placeholder content, or non-functional elements, since it currently implements " +
                    "the user interface only.\n"
        ),
        ParagraphModel(
            id = 6,
            title = "6. Intellectual Property",
            description = "Maynard Bank, including its name, design, and UI elements, was created by" +
                    " the developer as an original work for demonstration purposes, unless otherwise credited."
        ),
        ParagraphModel(
            id = 7,
            title = "7. Changes to This App",
            description = "As this is a demo project, features, screens, and functionality may change, " +
                    "be added, or be removed at any time without notice, as development continues."
        ),
        ParagraphModel(
            id = 8,
            title = "8. Contact",
            description = "For questions regarding this app or its intended use (e.g., for internship" +
                    " or academic review), please contact the developer directly.\n" +
                    "\n" +
                    "This document is a simplified Terms & Conditions statement created for a " +
                    "non-commercial demo application and does not constitute a legally binding agreement" +
                    " for a live financial product."
        ),
    )
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
                title = { Text(text = "Term & Condition") },
            )
        },
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
        ) {
            item {
                Text(
                    text = "Terms & Conditions — Maynard Bank\n" +
                            "\n" +
                            "Last Updated: September 12, 2026",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }

            items(paragraphList) { model ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {

                    Text(
                        text = model.title,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = model.description,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TermAndConditionPreview(){
    MyFirstApplicationForDemoTheme {
        TermAndConditionScreen()
    }
}
