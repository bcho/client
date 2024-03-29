package `fun`.build4.swipe

import android.service.autofill.TextValueSanitizer
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import java.util.stream.Collectors.toList
import java.util.stream.Stream

class CardStackAdapter(
    private var spots: List<Spot> = emptyList()
): RecyclerView.Adapter<CardStackAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_spot, parent, false))
    }

    override fun getItemCount(): Int {
        return spots.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val spot = spots[position]

        holder.name.text = "${spot.id}. ${spot.name}"
        holder.city.text = spot.city
        Glide.with(holder.image).load(spot.url).into(holder.image)
        holder.itemView.setOnClickListener { v ->
            Toast.makeText(v.context, spot.name, Toast.LENGTH_SHORT).show()
        }
    }

    fun addItem(item: Spot) {
        this.spots.plus(item)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.item_name)
        val city: TextView = view.findViewById(R.id.item_city)
        val image: ImageView= view.findViewById(R.id.item_image)
    }
}