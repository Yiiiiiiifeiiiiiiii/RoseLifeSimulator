package rose.cheny16.projectfragment

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.ListAdapter
import android.widget.TextView
import rose.cheny16.projectfragment.models.SaveFile
import rose.cheny16.projectfragment.models.SaveString

class SaveLoadViewHolder(val saveload: String, itemView: View, var adapter: SaveLoadAdapter) : RecyclerView.ViewHolder(itemView) {

    val action: String = saveload
    val button1: Button = itemView.findViewById(R.id.save_button1)
    val button2: Button = itemView.findViewById(R.id.save_button2)
    val button3: Button = itemView.findViewById(R.id.save_button3)


    init {
        itemView.setOnClickListener {
            if(action == "save"){
                adapter.saveStatus(adapterPosition)
                button1.text = "save 1:"+adapter.status.lastTouched.toString()
            }else{
                adapter.loadStatus(adapterPosition)
            }
        }
    }

    fun bind(){

    }
}