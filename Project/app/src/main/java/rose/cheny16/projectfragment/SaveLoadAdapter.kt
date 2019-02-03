package rose.cheny16.projectfragment

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.firebase.firestore.FirebaseFirestore
import rose.cheny16.projectfragment.Constants.STATUS_COLLECTION
import rose.cheny16.projectfragment.models.Status

class SaveLoadAdapter(val context: Context,var listener: fragment_saveload.OnFragmentInteractionListener?,
                      val uid: String) : RecyclerView.Adapter<SaveLoadViewHolder>(){

    lateinit var statusList: List<Status>

    private val statusRef = FirebaseFirestore
        .getInstance()
        .collection(Constants.USERS_COLLECTION)
        .document(uid)
        .collection(Constants.STATUS_COLLECTION)

    override fun onBindViewHolder(p0: SaveLoadViewHolder, p1: Int) {
        Log.d("test","vieholder binded from adapter")
        p0.bind()
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SaveLoadViewHolder {
        Log.d("test","vieholder created from adapter")
        val view = LayoutInflater.from(context).inflate(R.layout.save_load2, p0, false)
        return SaveLoadViewHolder("save",view, this,context as fragment_saveload.OnFragmentInteractionListener)
    }

    fun onCardClicked(position: Int) {
        listener?.onFragmentInteraction(position)
    }

    fun saveStatus(adapterPosition: Int) {

    }

    fun loadStatus(adapterPosition: Int) {

    }
}