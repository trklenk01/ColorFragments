package edu.msudenver.cs3013.colorfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.content.Context
import android.util.Log


class ChoiceFragment : Fragment() {

    private var choiceListener: ChoiceListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is ChoiceListener) choiceListener = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choice, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var redT = view.findViewById<TextView>(R.id.redText)
        var blueT = view.findViewById<TextView>(R.id.blueText)

        redT.setOnClickListener(){
            Log.d("Choice fragment","Red clicked")
            var choice: Int = 1
            choiceListener?.onSelected(choice)
        }
        blueT.setOnClickListener(){
            var choice: Int = 2
            choiceListener?.onSelected(choice)
        }
    }

}