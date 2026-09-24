package kh.com.vireak.developer.basic.myfirstapplicationfordemo.ui.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
val BrandPrimary = Color(0xFFFF00FF)
val BrandSecondary = Color(0xFF1A237E)
val BrandBackground = Color(0xFFF5F5F5)
val BrandSuccess = Color(0xFF2E7D32)
val BrandError = Color(0xFFD32F2F)

val GradientGreenBright = Color(0xFF16A672)
val GradientGreenMid = Color(0xFF0B4B3A)
val GradientGreenDark = Color(0xFF0A241D)

// Card background gradient
val CardGradient = Brush.radialGradient(
    colors = listOf(
        GradientGreenBright,
        GradientGreenMid,
        GradientGreenDark
    ),
    center = Offset(0.3f, 1.2f),
    radius = 900f
)

val GridContainerBackground = Color(0xFFE8F0EA)

// Soft sage green - gentle but still clearly green
val SoftGreenSage = Color(0xFF7FA88F)

// Soft mint green - a bit brighter/fresher
val SoftGreenMint = Color(0xFF6FBF9C)

// Muted forest green - softer version of your brand green
val SoftGreenMuted = Color(0xFF4C8C6B)

// Pastel green - very soft but not transparent-looking
val SoftGreenPastel = Color(0xFF8FBFA0)