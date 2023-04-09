package com.example.lesson_selectingcolors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lesson_selectingcolors.ui.theme.LessonSelectingColorsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LessonSelectingColorsTheme {
                val isDarkMode = remember { mutableStateOf(false) }

                MaterialTheme(
                    colorScheme = if (isDarkMode.value) darkColorScheme()
                    else lightColorScheme()
                ) {
                    Surface(color = MaterialTheme.colorScheme.background) {
                        Column {
                            Text(text = "Change app theme with a button!")
                            Button(
                                onClick = { isDarkMode.value = !isDarkMode.value },
                                modifier = Modifier.padding(vertical = 16.dp)
                            ) {
                                Text(text = if (isDarkMode.value) "Switch to Light Mode" else "Switch to Dark Mode")
                            }
                        }
                    }
                }
            }
        }
    }
}