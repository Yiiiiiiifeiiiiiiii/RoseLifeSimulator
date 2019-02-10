package rose.cheny16.projectfragment

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.story_fragment.view.*
import rose.cheny16.projectfragment.models.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [fragment_story.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [fragment_story.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class fragment_story : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var listener: OnFragmentInteractionListener? = null
    lateinit var mp: MediaPlayer

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
        // Inflate the layout for this fragment
        mp = MediaPlayer.create(context,R.raw.background3)

        mp.start()
        mp.isLooping = true
        var view = inflater.inflate(R.layout.story_fragment, container, false)
        lateinit var e: Event
        if(param1.equals("BobEvent1")){
            e = BobEvent1(context!!) as Event
        }else if(param1.equals("BobAtClub1")){
            e = BobAtClub1(context!!) as Event
        }else if(param1.equals("drBevent1")){
            e = drBevent1(context!!)
        }else if(param1.equals("drBevent2")){
            e = drBevent2(context!!)
        }else if(param1.equals("drBevent3")){
            e = drBevent3(context!!)
        }else if(param1.equals("drBevent4")){
            e = drBevent4(context!!)
        }else if(param1.equals("GirlfriendEvent1")){
            e = GirlfriendEvent1(context!!)
        }else if(param1.equals("GirlfriendEvent2")){
            e = GirlfriendEvent2(context!!)
        }else if(param1.equals("GirlfriendEvent3")){
            e = GirlfriendEvent3(context!!)
        }else if(param1.equals("GirlfriendEvent4")){
            e = GirlfriendEvent4(context!!)
        }else if(param1.equals("GirlfriendEvent5")){
            e = GirlfriendEvent5(context!!)
        }else if(param1.equals("RH131event1")){
            e = RH131event1(context!!)
        }else if(param1.equals("CHEM111event1")){
            e = CHEM111event1(context!!)
        }else if(param1.equals("CHEM111event2")){
            e = CHEM111event2(context!!)
        }else if(param1.equals("FinalExamEvent1")){
            e = FinalExamEvent1(context!!)
        }else if(param1.equals("EndEvent1")){
            e = EndEvent1(context!!)
        }
        view.imageView.setImageResource(e.place)

        view.choice1.setOnClickListener {
            e.makeChoice(1)
            view.choice1.text = ""
            view.choice2.text = "click next"
            view.choice2.setOnClickListener(null)
            view.choice1.setOnClickListener(null)
            view.next_button.isEnabled = true

        }

        view.choice2.setOnClickListener {
            e.makeChoice(2)
            view.choice1.text = ""
            view.choice2.text = "click next"
            view.choice2.setOnClickListener(null)
            view.choice1.setOnClickListener(null)
            view.next_button.isEnabled = true

        }

        view.next_button.setOnClickListener {
            if(e.hasNext()){
                var w = e.next()
                if(w.speaker.equals("switch")){
                    view.imageView.setImageResource(e.place2)
                }
                else if(w.speaker.equals("choice")){
                    view.choice1.text = w.txt
                    view.choice2.text = e.next().txt
                    view.talk.text = ""
                    view.next_button.isEnabled = false
                }else{
                    view.choice1.text = ""
                    view.choice2.text = ""
                    view.people1.text = w.speaker
                    view.talk.text = w.txt
                    view.head.setImageResource(Util.npcToDrawable.get(w.speaker)!!)
                }

            }else if(param1.equals("FinalExamEvent1")){
                var con = context as fragment_mainpage.IgetFt
                var ft = con.getFt()
                ft.replace(R.id.fragment_container,fragment_story.newInstance("EndEvent1"),"detail")
                ft.addToBackStack("list")
                ft.commit()
            }
            else{
                var con = context as fragment_mainpage.IgetFt
                var ft = con.getFt()
                ft.replace(R.id.fragment_container,fragment_mainpage(),"detail")
                ft.addToBackStack("list")
                ft.commit()
            }

        }
        return view;
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
            // throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
    override fun onDestroyView() {
        super.onDestroyView()
        mp.release()

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
         * @return A new instance of fragment fragment_story.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            fragment_story().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}
