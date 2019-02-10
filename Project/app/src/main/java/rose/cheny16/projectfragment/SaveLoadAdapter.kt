package rose.cheny16.projectfragment

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.QuerySnapshot
import rose.cheny16.projectfragment.Constants.STATUS_COLLECTION
import rose.cheny16.projectfragment.models.Status

class SaveLoadAdapter(val context: Context,var listener: fragment_saveload.OnFragmentInteractionListener?,
                      val uid: String) : RecyclerView.Adapter<SaveLoadViewHolder>(){

    var statuss= ArrayList<Status>()
    var con = context as Status.IgetStatus




    private val statusRef1 = FirebaseFirestore
        .getInstance()
        .collection(Constants.USERS_COLLECTION)
        .document(uid)
        .collection(Constants.STATUS_COLLECTION)

    private lateinit var listenerRegistration: ListenerRegistration



    override fun onBindViewHolder(p0: SaveLoadViewHolder, p1: Int) {
        Log.d("test","vieholder binded from adapter")
        p0.bind(statuss[p1])
    }

    fun addSnapshotListener(){
        listenerRegistration = statusRef1
            .addSnapshotListener { querySnapshot, e ->
            if(e != null){
                Log.d("ERROR??",e.toString())
            }else{
                processSnapshotChanges(querySnapshot!!)
            }
        }
        var con = context as Status.IgetStatus


        statusRef1.add(con.getStatus())
    }

    fun processSnapshotChanges(querySnapshot: QuerySnapshot) {
        for (documentChange in querySnapshot.documentChanges) {
            val s = Status.fromSnapshot(documentChange.document)
            when (documentChange.type) {
                DocumentChange.Type.ADDED -> {
                    statuss.add(0,s)

                    notifyItemInserted(0)
                }
                DocumentChange.Type.REMOVED -> {
                    val index = statuss.indexOfFirst { it.id == s.id }
                        statuss.removeAt(index)
                    notifyItemRemoved(index)

                }
            }
        }
    }

    override fun getItemCount(): Int {
        return statuss.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SaveLoadViewHolder {
        Log.d("test","vieholder created from adapter")
        val view = LayoutInflater.from(context).inflate(R.layout.save_load2, p0, false)
        //return SaveLoadViewHolder("save",view, this,context as fragment_saveload.OnFragmentInteractionListener)

        return SaveLoadViewHolder(true,view,listener,this,context)
    }

    fun onCardClicked(position: Int) {
        listener?.onFragmentInteraction(position)
    }

    fun saveStatus(s: Status) {
        statusRef1.add(Status)
    }

    fun delete(position: Int){
        statusRef1.document(statuss[position].id).delete()
    }

    fun loadStatus(adapterPosition: Int) {
        var con = context as Status.IgetStatus
        con.setStatus(statuss[adapterPosition])

    }
}