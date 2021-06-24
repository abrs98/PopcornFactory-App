package barrios.abrahan.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button: Button = findViewById(R.id.boton_start)
        var bundle= intent.extras

        if(bundle!=null){

        }
        button.setOnClickListener(){
            var intent= Intent(this, CatalogActivity::class.java)
            this.startActivity(intent)
        }
    }
}