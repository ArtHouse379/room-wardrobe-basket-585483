package decorationsave.appliances.roomwardrobebasket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import decorationsave.appliances.roomwardrobebasket.ui.composable.approot.AppRoot
import decorationsave.appliances.roomwardrobebasket.ui.theme.LLSORAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LLSORAppTheme {
                AppRoot()
            }
        }
    }
}
