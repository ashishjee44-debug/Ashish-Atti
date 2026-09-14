package com.example.ashishatte

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ashishatte.ui.AdminScreen
import com.example.ashishatte.ui.EmployeeScreen

@Composable
fun AttendanceApp() {
    var screen by remember { mutableStateOf("home") }
    when (screen) {
        "employee" -> EmployeeScreen { screen = "home" }
        "admin" -> AdminScreen { screen = "home" }
        else -> Column(
            Modifier.fillMaxSize().padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text("Ashish Atte", style = MaterialTheme.typography.headlineLarge)
            Text("Secure GPS attendance")
            Spacer(Modifier.height(24.dp))
            Button({ screen = "employee" }, Modifier.fillMaxWidth()) {
                Text("Employee")
            }
            Spacer(Modifier.height(10.dp))
            OutlinedButton({ screen = "admin" }, Modifier.fillMaxWidth()) {
                Text("Admin")
            }
        }
    }
}
