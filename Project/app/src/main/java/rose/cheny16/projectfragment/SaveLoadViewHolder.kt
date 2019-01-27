package rose.cheny16.projectfragment

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.ListAdapter
import android.widget.TextView
import rose.cheny16.projectfragment.models.SaveFile
import rose.cheny16.projectfragment.models.SaveString

class SaveLoadViewHolder(itemView: View, var adapter: SaveLoadAdapter) : RecyclerView.ViewHolder(itemView) {
    val button1: Button = itemView.findViewById(R.id.save_button1)
    val button2: Button = itemView.findViewById(R.id.save_button2)
    val button3: Button = itemView.findViewById(R.id.save_button3)


    init {

        button1.setText("empty")

    }

    fun bind(){

    }
}