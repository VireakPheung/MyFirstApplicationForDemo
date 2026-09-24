package kh.com.vireak.developer.basic.myfirstapplicationfordemo.util

import NavigationDrawer
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.feature.ContactUsScreen
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.feature.HomeScreen
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.feature.ProfileScreen
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.feature.SecurityScreen
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.feature.SignUpScreen
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.feature.TermAndConditionScreen
import kh.com.vireak.developer.basic.myfirstapplicationfordemo.feature.ScreenNotification

sealed class NavigationKey {
    data object HomeScreen : NavigationKey()
    data object SignUpScreen : NavigationKey()
    data object ProfileScreen : NavigationKey()
    data object SecurityScreen : NavigationKey()
    data object ContactUsScreen : NavigationKey()
    data object TermAndConditionScreen : NavigationKey()
    data object ScreenNotification : NavigationKey()
}

@Composable
fun AppNavigation() {
    val backStack = remember { mutableStateListOf<NavigationKey>(NavigationKey.SignUpScreen) }

    NavDisplay(
        backStack = backStack,
        onBack = {
            if (backStack.size > 1) {
                backStack.removeLastOrNull()
            }
        },
        entryProvider = { key ->
            when (key) {
                NavigationKey.SignUpScreen -> NavEntry(key) {
                    SignUpScreen(
                        onNavigateToHome = {
                            backStack.add(NavigationKey.HomeScreen)
                        }
                    )
                }

                NavigationKey.HomeScreen -> NavEntry(key) {
                    HomeScreen(
                        onNavigateToSignUp = {
                            backStack.add(NavigationKey.SignUpScreen)
                        },
                        onNavigateToProfile = {
                            backStack.add(NavigationKey.ProfileScreen)
                        },
                        onNavigateToSecurity = {
                            backStack.add(NavigationKey.SecurityScreen)
                        },
                        onNavigateToContact = {
                            backStack.add(NavigationKey.ContactUsScreen)
                        },
                        onNavigateToTermAndCondition = {
                            backStack.add(NavigationKey.TermAndConditionScreen)
                        },
                        onNavigateToNotificationScreen = {
                            backStack.add(NavigationKey.ScreenNotification)
                        }
                    )
                }

                NavigationKey.ProfileScreen -> NavEntry(key) {
                    ProfileScreen(
                        onNavigateToHomeScreen = {
                            backStack.add(NavigationKey.HomeScreen)
                        }
                    )
                }

                NavigationKey.SecurityScreen -> NavEntry(key){
                    SecurityScreen(
                        onNavigateToHome = {
                            backStack.add(NavigationKey.HomeScreen)
                        }
                    )
                }

                NavigationKey.ContactUsScreen -> NavEntry(key){
                    ContactUsScreen(
                        onNavigateToHome = {
                            backStack.add(NavigationKey.HomeScreen)
                        }
                    )

                }
                NavigationKey.TermAndConditionScreen -> NavEntry(key){
                    TermAndConditionScreen(
                        onNavigateToHome = {
                            backStack.add(NavigationKey.HomeScreen)
                        }
                    )
                }
                NavigationKey.ScreenNotification -> NavEntry(key){
                    ScreenNotification(
                        onNavigateToHome = {
                            backStack.add(NavigationKey.HomeScreen)
                        }
                    )
                }
            }
        },
    )
}
