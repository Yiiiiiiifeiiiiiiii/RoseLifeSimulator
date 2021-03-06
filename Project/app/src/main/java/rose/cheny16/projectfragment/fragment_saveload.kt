package rose.cheny16.projectfragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import rose.cheny16.projectfragment.R.layout.activity_main
import rose.cheny16.projectfragment.models.Status

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [fragment_saveload.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [fragment_saveload.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class fragment_saveload : Fragment() {
    // TODO: Rename and change types of parameters
    private var uid: String? = null
    private var param2: String? = null
    public var listener: OnFragmentInteractionListener? = null
    public var SLMode: Boolean? = true //true = save; false = load
    public var adapter: SaveLoadAdapter? = null
    public var SLViewHolder : SaveLoadViewHolder? = null
    var view : RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            uid = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.list_view,container,false) as RecyclerView
        adapter = SaveLoadAdapter(context!!, context as fragment_saveload.OnFragmentInteractionListener?, uid!!)

        adapter!!.addSnapshotListener(param2!!)

        view!!.layoutManager = LinearLayoutManager(context)
        //var lm = view!!.layoutManager
        view!!.setHasFixedSize(true)
        view!!.adapter=adapter

        var callback = ItemSwipeCallback(adapter!!)
        var ith = ItemTouchHelper(callback)
        ith.attachToRecyclerView(view)



        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Int) {
        listener?.onFragmentInteraction(uri)
    }

    fun setSLMode(mode: Boolean ){
        this.SLMode = mode
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
          //  throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(saveSlotID: Int)



    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragment_saveload.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment_saveload().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
