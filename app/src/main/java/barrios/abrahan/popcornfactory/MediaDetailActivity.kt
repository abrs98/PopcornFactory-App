package barrios.abrahan.popcornfactory

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class MediaDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_detail)


        // Se obtiene el tipo de Menu mediante el objecto intent

        var img = intent.getIntExtra("header",0) // 2
        var titl = intent.getStringExtra("title") // 2
        var sin = intent.getStringExtra("sinopsis") // 2

        var image: ImageView = findViewById(R.id.image_detail)
        var title: TextView = findViewById(R.id.title_detail)
        var sinopsis: TextView = findViewById(R.id.text_sinopsis)

        image.setImageResource(img)
        title.text = titl
        sinopsis.text = sin

        title.movementMethod = ScrollingMovementMethod()

    }
}

