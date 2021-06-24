package barrios.abrahan.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class SeatReservationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_reservation)

        val bundle = intent.extras

        var seatText: TextView= findViewById(R.id.seat_number)
        var nameTxt: EditText =  findViewById(R.id.client_name)
        var pagoTxt: EditText = findViewById(R.id.payment)

        var seat: Int=0
        var name:String?=null
        var pago: String?= null

        if(bundle!=null){
            seat= bundle.getInt("seat")
            seatText.setText("Asiento Seleccionado: $seat")
        }

        var btnReservar: Button= findViewById(R.id.reservate)
        var fecha= Date()

        btnReservar.setOnClickListener {

            name= nameTxt.text.toString()
            pago= pagoTxt.text.toString()
            var client= Client(name,pago,seat,fecha)
            Toast.makeText(this,"Asiento $seat Reservado Para $name, $fecha, mediante $pago",Toast.LENGTH_LONG).show()
            var intent: Intent= Intent(this, MainActivity::class.java)
            intent.putExtra("name",name)
            intent.putExtra("seat",fecha)
            intent.putExtra("fecha",fecha)
            intent.putExtra("pago",pago)
            this.startActivity(intent)

        }


    }
}