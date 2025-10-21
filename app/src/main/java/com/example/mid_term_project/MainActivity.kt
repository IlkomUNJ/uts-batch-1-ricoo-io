package com.example.mid_term_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mid_term_project.ui.theme.Mid_Term_ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mid_Term_ProjectTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
                AppNavigator()
            }
        }
    }
}

object AppRoutes {
    const val CONTACTLIST_SCREEN = "contactlist"
    const val ADD_EDIT_CONTACT_SCREEN = "add_editcontact"
}
@Composable
fun AppNavigator() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = com.example.mid_term_project.AppRoutes.CONTACTLIST_SCREEN
    ) {
        composable(route = com.example.mid_term_project.AppRoutes.CONTACTLIST_SCREEN) {
            contactListScreen(navController = navController)
        }

        composable(route = com.example.mid_term_project.AppRoutes.ADD_EDIT_CONTACT_SCREEN) {

        }

        composable("add_editcontact/{contactId}") { backStackEntry ->
            val contactId = backStackEntry.arguments?.getString("contactId")?.toIntOrNull()
            addEditContactScreen(navController = navController, contactId = contactId)
        }
    }
}

