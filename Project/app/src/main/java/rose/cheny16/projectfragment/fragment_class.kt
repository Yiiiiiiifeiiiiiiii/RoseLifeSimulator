package rose.cheny16.projectfragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.class_fragment.view.*
import kotlinx.android.synthetic.main.people_fragment.view.*
import rose.cheny16.projectfragment.models.Status


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [fragment_people.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [fragment_people.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class fragment_class : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var con = context as fragment_mainpage.IgetFt
        var ft = con.getFt()
        var consta = context as Status.IgetStatus
        var sta = consta.getStatus()
        var view = inflater.inflate(R.layout.class_fragment, container, false)
        view.rh131_button.setOnClickListener{
            //if(sta.RH131EventProgress == 0){
                sta.RH131EventProgress ++
                ft.replace(R.id.fragment_container,fragment_story.newInstance("RH131event1"),"detail")
                ft.addToBackStack("list")
                ft.commit()
            //}


        }
        view.chem111_button.setOnClickListener{
            if(sta.CHEM111EventProgress == 0){
                sta.CHEM111EventProgress ++
                ft.replace(R.id.fragment_container,fragment_story.newInstance("CHEM111event1"),"detail")
                ft.addToBackStack("list")
                ft.commit()
            }else if(sta.CHEM111EventProgress == 1){
                sta.CHEM111EventProgress ++
                ft.replace(R.id.fragment_container,fragment_story.newInstance("CHEM111event2"),"detail")
                ft.addToBackStack("list")
                ft.commit()
            }

        }
        view.jp111_button.setOnClickListener {
            Toast.makeText(context, "This part is till in progress!", Toast.LENGTH_SHORT).show()
        }
        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
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
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragment_people.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment_people().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
