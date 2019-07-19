package com.navigation.component.sample.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.navigation.component.sample.R
import com.navigation.component.sample.data.MyParcelableDataArgs


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MyHomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MyHomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MyHomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view?.findViewById<Button>(R.id.button).setOnClickListener(View.OnClickListener {
            val arg1 = 2
            val arg3 = "Screen 2"
            val data1=1
            val arg2=MyParcelableDataArgs(data1)
            arg2.data2=2
            arg2.data3="Welcome to Screen 2"
            arg2.data4=1
            val action =
                MyHomeFragmentDirections.actionMyHomeFragmentToMySecondFragment(
                    arg1,
                    arg2,
                    arg3
                )
            findNavController().navigate(action)
           // findNavController().navigate(R.id.action_myHomeFragment_to_mySecondFragment)
        })
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    @Suppress("DEPRECATION")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.settings_dest -> {
                val options = navOptions {
                    anim {
                        enter = R.anim.slide_in_right
                        exit = R.anim.slide_out_left
                        popEnter = R.anim.slide_in_left
                        popExit = R.anim.slide_out_right
                    }
                }
                findNavController().navigate(R.id.settingsFragment,null,options)

                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyHomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyHomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
