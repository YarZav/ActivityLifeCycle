package com.example.acctivitylifecycle

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.acctivitylifecycle.ui.theme.AcctivityLifeCycleTheme

// Активити может переоздаваться при смене ориентации экрана, смене языка интерфейса, смена размера экрана
class MainActivity : ComponentActivity() {
    // Выполняется перед стартом Activity
    // Когда Activity переход из состояния Initialized в состояние Created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    // Activity стартует и готовится выйти на передний план
    override fun onStart() {
        super.onStart()
        toastMeState("ON_START")
    }

    // Вызывается когда Activity становится видимым пользователю
    override fun onResume() {
        super.onResume()
        toastMeState("ON_RESUME")
    }

    //
    override fun onPostResume() {
        super.onPostResume()
        toastMeState("ON_POST_RESUME")
    }

    // Activity уходит с переднего плана
    override fun onPause() {
        super.onPause()
        toastMeState("ON_PAUSE")
    }

    // Когда Activity становится невидимым пользователю
    // Например, когда перекрывает новое Activity
    override fun onStop() {
        super.onStop()
        toastMeState("ON_STOP")
    }

    // Если Activity собирается вернуться на передний план и будет отображено пользователю
    override fun onRestart() {
        super.onRestart()
        toastMeState("ON_RESTART")
    }

    // Вызывается перед уничтожением Activity системой
    override fun onDestroy() {
        super.onDestroy()
        toastMeState("ON_DESTROY")
    }

    private fun toastMeState(message: String) {
        Toast.makeText(this, "${lifecycle.currentState}, $message", Toast.LENGTH_LONG).show()
    }
}