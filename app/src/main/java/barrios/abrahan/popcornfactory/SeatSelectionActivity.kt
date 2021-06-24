package barrios.abrahan.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.get

class SeatSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val title: TextView = findViewById(R.id.title_seats)
        var posMovie = -1
        var seat = -1

        val bundle = intent.extras

        if(bundle!=null){
            title.setText(bundle.getString("name"))
            posMovie = bundle.getInt("id")
            Toast.makeText(this, "Movie Number: $posMovie", Toast.LENGTH_LONG).show()
        }

        val confirm : Button = findViewById(R.id.confirm)

        val row1: RadioGroup = findViewById(R.id.row1)
        val row2: RadioGroup = findViewById(R.id.row2)
        val row3: RadioGroup = findViewById(R.id.row3)
        val row4: RadioGroup = findViewById(R.id.row4)

        var radioButton: RadioButton?= null

        confirm.setOnClickListener(){
            // TODO Anadir logica para reservar el lugar seleccionado por el usuario
            val intent: Intent = Intent(this,SeatReservationActivity::class.java)
            intent.putExtra("seat",seat)
            this.startActivity(intent)
            // Hacer una nueva actividad donde se vea el resumen de la compra es decir que se agregue el nombre del cliente y se vea el asiento que se selecciono
            Toast.makeText(this, "Enjoy the Movie! :D", Toast.LENGTH_LONG).show()
        }

        row1.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId > -1){
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
                row1.check(checkedId)
                radioButton= findViewById(checkedId) as RadioButton?
                seat= radioButton!!.text.toString().toInt()
                Toast.makeText(this, "Selected Seat: $seat", Toast.LENGTH_SHORT).show()

            }

        }

        row2.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId > -1){
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
                row2.check(checkedId)
                radioButton= findViewById(checkedId) as RadioButton?
                seat= radioButton!!.text.toString().toInt()
                Toast.makeText(this, "Selected Seat: $seat", Toast.LENGTH_SHORT).show()
            }

        }

        row3.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId > -1){
                row2.clearCheck()
                row1.clearCheck()
                row4.clearCheck()
                row3.check(checkedId)
                radioButton= findViewById(checkedId) as RadioButton?
                seat= radioButton!!.text.toString().toInt()
                Toast.makeText(this, "Selected Seat: $seat", Toast.LENGTH_SHORT).show()
            }

        }

        row4.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId > -1){
                row2.clearCheck()
                row3.clearCheck()
                row1.clearCheck()
                radioButton= findViewById(checkedId) as RadioButton?
                seat= radioButton!!.text.toString().toInt()
                Toast.makeText(this, "Selected Seat: $seat", Toast.LENGTH_SHORT).show()
            }

        }
    }
}