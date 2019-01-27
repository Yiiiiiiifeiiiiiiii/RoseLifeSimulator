package rose.cheny16.projectfragment

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class SaveLoadAdapter(val context: Context,var listener: fragment_saveload.OnFragmentInteractionListener?) : RecyclerView.Adapter<SaveLoadViewHolder>(){
    override fun onBindViewHolder(p0: SaveLoadViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SaveLoadViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.save_load2, p0, false)
        return SaveLoadViewHolder(view, this)
    }

    fun onCardClicked(position: Int) {
        listener?.onFragmentInteraction(position)
    }
}