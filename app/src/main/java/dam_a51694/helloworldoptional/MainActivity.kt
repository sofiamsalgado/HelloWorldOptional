package dam_a51694.helloworldoptional

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvInfo = findViewById<TextView>(R.id.tvInfo) // encontra o TextView do layout pelo id
        // criar um texto com várias linhas com a marca do dispositivo, modelo, marca comercial, tipo de build,
        // utilizador que fez a build, versao base do android, numero interno da build, versao do SDK,
        // versao android visivel e identificador da build
        val info = """
            Manufacturer: ${Build.MANUFACTURER} 
            Model: ${Build.MODEL}
            Brand: ${Build.BRAND}
            Type: ${Build.TYPE}
            User: ${Build.USER}
            Base: ${Build.VERSION_CODES.BASE}
            Incremental: ${Build.VERSION.INCREMENTAL}
            SDK: ${Build.VERSION.SDK_INT}
            Version Code: ${Build.VERSION.RELEASE}
            Display: ${Build.DISPLAY}
        """.trimIndent()
        // mostrar o texto no TextView
        tvInfo.text = info

    }
}