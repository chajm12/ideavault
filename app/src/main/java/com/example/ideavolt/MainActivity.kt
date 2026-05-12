package com.example.ideavolt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ideavolt.data.local.database.IdeaDatabase
import com.example.ideavolt.presentation.navigation.NavGraph
import com.example.ideavolt.ui.theme.IdeaVoltTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val database = IdeaDatabase.getDatabase(this)
        setContent {
            IdeaVoltTheme {
                NavGraph(database = database)
            }
        }
    }
}
