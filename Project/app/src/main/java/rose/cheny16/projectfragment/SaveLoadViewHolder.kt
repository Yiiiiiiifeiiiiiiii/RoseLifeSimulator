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

class SaveLoadViewHolder(val saveload: Boolean, itemView: View,
                         var listener: fragment_saveload.OnFragmentInteractionListener?)
    : RecyclerView.ViewHolder(itemView) {

    val SLMode: Boolean = saveload
    val button1: Button = itemView.findViewById(R.id.save_button1)
    val button2: Button = itemView.findViewById(R.id.save_button2)
    val button3: Button = itemView.findViewById(R.id.save_button3)
    val saveloadListener = listener


    init {
        Log.d("test",saveload.toString() + "   actived from viewholder")
        button1.setOnClickListener {
            if(SLMode){
                Log.d("test","savemode actived")
                //adapter.saveStatus(adapterPosition)
                button1.text = "SAVE SLOT 1: " + "???"

            }else{
                //adapter.loadStatus(adapterPosition)
                Log.d("test","loadmode actived")

            }
        }
    }

    fun bind(){

    }
}