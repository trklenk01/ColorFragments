package edu.msudenver.cs3013.colorfragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ColorFragment : Fragment(R.layout.fragment_color) {


    companion object {
        var fragmentCount:Int = 0
        fun newInstance(choice:Int) =
            ColorFragment().apply{
                arguments = Bundle().apply {
                    Log.d("ColorFragment","newInstance called with choice $choice")
                    putInt("COLOR_CHOICE",choice)
                }
            }
        }


    var myIndex:Int=0

    override fun onCreate(savedInstanceState: Bundle?){
        Log.d("ColorFragment","onCreate called")
        super.onCreate(savedInstanceState)
        if(savedInstanceState == null){
            fragmentCount += 1
            this.myIndex = fragmentCount
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("ColorFragment","onViewCreated called")
        val chosenColorTV:TextView? = view?.findViewById(R.id.mycolor)
        val choiceId = arguments?.getInt("COLOR_CHOICE",0)?:0
        if(choiceId == 1) {
            chosenColorTV?.text = "GENERIC RED FRAGMENT - UID $myIndex"
            chosenColorTV?.setBackgroundColor(Color.rgb(255,150,150))
        }
        else{
            chosenColorTV?.text = "GENERIC BLUE FRAGMENT - UID $myIndex"
            chosenColorTV?.setBackgroundColor(Color.rgb(150,150,255))
        }
    }
}
