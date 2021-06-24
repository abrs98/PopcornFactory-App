package barrios.abrahan.popcornfactory

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.widget.Button
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class MediaDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_detail)

        var img = intent.getIntExtra("header",0) // 2
        var titl = intent.getStringExtra("title") // 2
        var sin = intent.getStringExtra("sinopsis") // 2
        var seats= intent.getIntExtra("numberSeats",0)
        var id= intent.getIntExtra("pos",-1)

        var image: ImageView = findViewById(R.id.image_detail)
        var title: TextView = findViewById(R.id.title_detail)
        var sinopsis: TextView = findViewById(R.id.text_sinopsis)
        var seatsL: TextView = findViewById(R.id.seats_left)

        image.setImageResource(img)
        title.text = titl
        sinopsis.text = sin
        seatsL.text= "$seats seats available"

        title.movementMethod = ScrollingMovementMethod()

        var buy: Button = findViewById(R.id.buy_tickets)

        if(seats==0){
            buy.isActivated = false
        }else{
            buy.setOnClickListener(){
                val intent: Intent = Intent(this,SeatSelectionActivity::class.java)
                intent.putExtra("id",id)
                intent.putExtra("name",titl)
                this.startActivity(intent)
            }
        }

    }
}

