package rose.cheny16.projectfragment

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.mainpage_fragment.view.*
import org.w3c.dom.Text
import rose.cheny16.projectfragment.models.Status
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
    var isClassed = false
    lateinit var mp: MediaPlayer



//    private var date: Date = Date(2019,9,1)
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mp = MediaPlayer.create(context,R.raw.background1)

        mp.start()
        mp.isLooping = true
        var view = inflater.inflate(R.layout.mainpage_fragment, container, false)
        var con = context as IgetFt
        var ft = con.getFt()
        var consta = context as Status.IgetStatus
        var sta = consta.getStatus()
        var isClassed = false
        
        var message_week = getString(R.string.week_format, sta.Week)
        var message_day = getString(R.string.day_format, sta.Day)
        view.findViewById<TextView>(R.id.weekNumberTextView).text = message_week
        view.findViewById<TextView>(R.id.dayNumber).text = message_day
        view.happinessTextView.text = getString(R.string.happiness_format,sta.happiness)
        view.actionPointTextView.text = getString(R.string.actionPoint_format, sta.actionPoint)
        view.currentGPAtitle.text = getString(R.string.gpa_format, sta.GPA)
        view.nameTexgtView.text = getString(R.string.name_format, sta.name)


        view.nextDay_button.setOnClickListener {
            sta.Day += 1
            if(sta.Day==8){
                sta.Day =1
                sta.Week += 1
            }
            val rnds = (0..10).random() //[0,9]

            if(rnds == 1) {
                Toast.makeText(context,"Wait a minute!", Toast.LENGTH_SHORT).show()
                ft.replace(R.id.fragment_container,fragment_story.newInstance("RandomEvent1"),"detail")
                ft.addToBackStack("list")
                ft.commit()
            }else if(rnds == 2)  {
                Toast.makeText(context,"Bob comes to your dorm", Toast.LENGTH_SHORT).show()
                ft.replace(R.id.fragment_container,fragment_story.newInstance("RandomEvent2"),"detail")
                ft.addToBackStack("list")
                ft.commit()
            }

            if(sta.Week >= 11){
                // TODO: go to end
                Toast.makeText(context,"Final Exam time!", Toast.LENGTH_SHORT).show()

                val rnds2 = (0..1).random() //[0,1]
                if(rnds2 == 0){
                    ft.replace(R.id.fragment_container,fragment_story.newInstance("FinalExamEvent1"),"detail")
                }
                else{
                    ft.replace(R.id.fragment_container,fragment_story.newInstance("FinalExamEvent2"),"detail")
                }
                //ft.replace(R.id.fragment_container,fragment_story.newInstance("FinalExamEvent1"),"detail")
                ft.addToBackStack("list")
                ft.commit()


            }



            if(!isClassed){
                sta.GPA = sta.GPA-0.01f
                view.currentGPAtitle.text = getString(R.string.gpa_format, sta.GPA)
            }
            if(sta.GPA > 4){
                sta.GPA = 4f
                view.currentGPAtitle.text = getString(R.string.gpa_format, sta.GPA)
            }
            isClassed = false
            sta.actionPoint = 30
//            date = Date(2019,9,day)
            var message_week = getString(R.string.week_format, sta.Week)
            var message_day = getString(R.string.day_format, sta.Day)
            view.findViewById<TextView>(R.id.weekNumberTextView).text = message_week
            view.findViewById<TextView>(R.id.dayNumber).text = message_day
            view.actionPointTextView.text = getString(R.string.actionPoint_format, sta.actionPoint)
        }

        view.club_button.setOnClickListener {
            if(sta.actionPoint == 0){
                Toast.makeText(context,"You don't have action point", Toast.LENGTH_SHORT).show()
            }else{
                ft.replace(R.id.fragment_container,fragment_story.newInstance("BobAtClub1"),"detail")
                ft.addToBackStack("list")
                ft.commit()
            }


        }
        view.class_button.setOnClickListener {
            if(sta.actionPoint == 0){
                Toast.makeText(context,"You don't have action point", Toast.LENGTH_SHORT).show()
            }else {
                isClassed = true;
                ft.replace(R.id.fragment_container, fragment_class(), "detail")
                ft.addToBackStack("list")
                ft.commit()
            }

        }
        view.people_button.setOnClickListener {
            if(sta.actionPoint == 0){
                Toast.makeText(context,"You don't have action point", Toast.LENGTH_SHORT).show()
            }else {
                ft.replace(R.id.fragment_container, fragment_people(), "detail")
                ft.addToBackStack("list")
                ft.commit()
            }

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

    override fun onDestroyView() {
        super.onDestroyView()
        mp.release()

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
        fun newInstance(param1: String) =
            fragment_mainpage().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)

                }
            }
    }

    interface IgetFt{
        fun getFt():FragmentTransaction
    }
}
