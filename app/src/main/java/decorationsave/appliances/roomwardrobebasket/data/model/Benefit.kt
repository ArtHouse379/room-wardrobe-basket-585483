package decorationsave.appliances.roomwardrobebasket.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.ui.graphics.vector.ImageVector

data class Benefit(
    val icon: ImageVector,
    val text: String,
)

val productBenefits = listOf<Benefit>(
    Benefit(
        icon = Icons.Filled.CheckCircle,
        text = "Trusted quality",
    ),
    Benefit(
        icon = Icons.Filled.VerifiedUser,
        text = "One-year warranty",
    ),
    Benefit(
        icon = Icons.Filled.Home,
        text = "Everyday essentials",
    ),
)
