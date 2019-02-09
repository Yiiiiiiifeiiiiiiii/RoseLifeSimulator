package rose.cheny16.projectfragment

import android.content.Context
import android.net.Uri
import android.os.Bundle

import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import kotlinx.android.synthetic.main.introduction_view.view.*
import kotlinx.android.synthetic.main.login.view.*

private const val ARG_UID = "uid"


class fragment_introduction : Fragment() {

    private var uid: String? = null

    private var listener: fragment_login.OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            uid = it.getString(ARG_UID)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.introduction_view, container, false)
        var con = context as fragment_login.IgetFt
        var ft = con.getFt()
        val path = "android.resource://" + getActivity()!!.getPackageName()+  "/"+R.raw.rose_video
        view.vv?.setVideoURI(Uri.parse(path))
        view.intro_video_button.setOnClickListener {
            view.intro_text.visibility =  View.INVISIBLE
            view.vv.start()
        }

        view.intro_login.setOnClickListener {
            if(uid.equals("no id")){
                Toast.makeText(context,"You have to Login!" ,Toast.LENGTH_LONG).show()
                ft.replace(R.id.fragment_container,fragment_login(),"login")
                ft.addToBackStack("intro")
                ft.commit()
            }else{
                ft.replace(R.id.fragment_container,fragment_mainpage.newInstance(uid!!),"main")
                ft.addToBackStack("intro")
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
        if (context is fragment_login.OnFragmentInteractionListener) {
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
         * @return A new instance of fragment fragment_login.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(uid: String) =
            fragment_introduction().apply {
                arguments = Bundle().apply {
                    putString(ARG_UID, uid)

                }
            }
    }

}