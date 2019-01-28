package rose.cheny16.projectfragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.mainpage_fragment.view.*
import org.w3c.dom.Text
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [fragment_mainpage.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [fragment_mainpage.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class fragment_mainpage : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var week: Int = 1
    private var day: Int = 1
//    private var date: Date = Date(2019,9,1)
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
        var view = inflater.inflate(R.layout.mainpage_fragment, container, false)
        var con = context as IgetFt
        var ft = con.getFt()

        view.nextDay_button.setOnClickListener {
            day += 1
            if(day==8){
                day =1
                week += 1
            }
//            date = Date(2019,9,day)
            var message_week = getString(R.string.week_format, week)
            var message_day = getString(R.string.day_format, day)
            view.findViewById<TextView>(R.id.weekNumberTextView).text = message_week
            view.findViewById<TextView>(R.id.dayNumber).text = message_day
        }

        view.club_button.setOnClickListener {

            ft.replace(R.id.fragment_container,fragment_story(),"detail")
            ft.addToBackStack("list")
            ft.commit()

        }
        view.class_button.setOnClickListener {
            ft.replace(R.id.fragment_container,fragment_story(),"detail")
            ft.addToBackStack("list")
            ft.commit()

        }
        view.people_button.setOnClickListener {
            ft.replace(R.id.fragment_container,fragment_people(),"detail")
            ft.addToBackStack("list")
            ft.commit()

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
         * @return A new instance of fragment fragment_mainpage.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment_mainpage().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    interface IgetFt{
        fun getFt():FragmentTransaction
    }
}
