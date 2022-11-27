package com.example.fragmentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SimpleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SimpleFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    val YES = 0
    val NO = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_simple, container, false)

//        val radioGroup = rootView.findViewById<RadioGroup>(R.id.radio_group)
//        val ratingBar = rootView.findViewById<RatingBar>(R.id.ratingBar)
//        radioGroup.setOnCheckedChangeListener { _, isChecked ->
//            val index = radioGroup.indexOfChild(radioGroup)
//            val textView: TextView = rootView.findViewById(R.id.fragment_header)
//
//            when (index) {
//                YES -> textView.setText(R.string.yes_message)
//                NO -> textView.setText(R.string.no_message)
//                else -> {}
//            }
//        }        // Set the rating bar onCheckedChanged listener.
//        // Set the rating bar onCheckedChanged listener.
//        ratingBar.setOnRatingBarChangeListener(RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser -> // Get rating and show Toast with rating.
//            val myRating = getString(R.string.my_rating) + ratingBar.rating.toString()
//            Toast.makeText(
//                context, myRating,
//                Toast.LENGTH_SHORT
//            ).show()
//        })

        return rootView
    }


}