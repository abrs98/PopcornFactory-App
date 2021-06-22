package barrios.abrahan.popcornfactory

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MediaAdapter : BaseAdapter {
    var context: Context?=null
    var medias= ArrayList<Media>()

    constructor(context: Context,medias: ArrayList<Media>){
        this.context=context
        this.medias=medias
    }

    override fun getCount(): Int {
        return medias.size
    }

    override fun getItem(p0: Int): Any {
        return medias[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var media = medias[p0]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista = inflator.inflate(R.layout.cell_media,null)
        var image: ImageView = vista.findViewById(R.id.image_media_cell)
        var title: TextView = vista.findViewById(R.id.media_title_cell)

        image.setImageResource(media.image)
        title.setText(media.title)

        image.setOnClickListener(){
            var intento= Intent(context, MediaDetailActivity::class.java)
            intento.putExtra("title",media.title)
            intento.putExtra("sinopsis",media.sinopsis)
            intento.putExtra("header",media.header)
            intento.putExtra("image",media.image)
            context!!.startActivity(intento)
        }

        return vista


    }


}