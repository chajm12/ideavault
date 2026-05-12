package com.example.ideavault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ideavault.data.local.database.IdeaDatabase
import com.example.ideavault.presentation.navigation.NavGraph
import com.example.ideavault.ui.theme.IdeaVaultTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val database = IdeaDatabase.getDatabase(this)
        setContent {
            IdeaVaultTheme {
                NavGraph(database = database)
            }
        }
    }
}
