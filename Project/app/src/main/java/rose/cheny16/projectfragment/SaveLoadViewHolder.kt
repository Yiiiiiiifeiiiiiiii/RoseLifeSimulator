package rose.cheny16.projectfragment

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ListAdapter
import android.widget.TextView
import rose.cheny16.projectfragment.models.SaveFile
import rose.cheny16.projectfragment.models.SaveString

class SaveLoadViewHolder(val saveload: String, itemView: View,
                         var adapter: SaveLoadAdapter,var listener: fragment_saveload.OnFragmentInteractionListener?)
    : RecyclerView.ViewHolder(itemView) {

    val action: String = saveload
    val button1: Button = itemView.findViewById(R.id.save_button1)
    val button2: Button = itemView.findViewById(R.id.save_button2)
    val button3: Button = itemView.findViewById(R.id.save_button3)
    val saveloadListener = listener


    init {
        Log.d("test",saveload + "actived from viewholder")
        button1.setOnClickListener {
            if(action == "save"){
                Log.d("test","savemode actived")
                adapter.saveStatus(adapterPosition)
                button1.text = "save "+adapterPosition +adapter.statusList[adapterPosition]
                                .lastTouched.toString()

            }else{
                adapter.loadStatus(adapterPosition)
            }
        }
    }

    fun bind(){

    }
}