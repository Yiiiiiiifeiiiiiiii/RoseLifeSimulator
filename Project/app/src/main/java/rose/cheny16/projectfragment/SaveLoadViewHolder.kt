package rose.cheny16.projectfragment

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.save_load2.view.*
import rose.cheny16.projectfragment.models.Status

class SaveLoadViewHolder(val saveload: Boolean, itemView: View,
                         var listener: fragment_saveload.OnFragmentInteractionListener?,
                         var adapter: SaveLoadAdapter,
                         var context: Context
                         )
    : RecyclerView.ViewHolder(itemView) {

    val SLMode: Boolean = saveload
    val button1: Button = itemView.findViewById(R.id.save_button1)
    val saveloadListener = listener
    val cardView = itemView.CardView

    init {
        button1.setOnClickListener {

                var con = context as Status.IgetStatus
                adapter.loadStatus(adapterPosition)
                Log.d("test","loadmode actived")


        }
    }

    fun bind(s: Status){
        button1.text = s.name + " Week: " + s.Week + " Day: " + s.Day
    }
}