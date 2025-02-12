package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            val viewModel = viewModel<MyViewModel>()
            val currentValue = viewModel.myFlow.collectAsState(initial = 19).value
            MyApplicationTheme {
                Surface (modifier = Modifier.fillMaxSize(),color= MaterialTheme.colorScheme.background) {
                    Text(text = "current index is $currentValue", fontSize = 25.sp)
                }
            }
        }
    }
}