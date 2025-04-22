//Thomas Klenk

package edu.msudenver.cs3013.colorfragments

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView

interface ChoiceListener{
    fun onSelected(choice:Int)
}
class MainActivity : AppCompatActivity(), ChoiceListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            var cfv = findViewById<FragmentContainerView>(R.id.upperfragment_container)
            val choiceFragment = ChoiceFragment()
            supportFragmentManager.beginTransaction().add(cfv.id, choiceFragment).commit()

        }
    }
    override fun onSelected(choice:Int){
        Log.d("MainActivity","onSelected called with choice $choice")
        val fcv = findViewById<FragmentContainerView>(R.id.lowerfragment_container)
        val colorFrag = ColorFragment.newInstance(choice)
        supportFragmentManager.beginTransaction().replace(fcv.id, colorFrag).addToBackStack(null).commit()

    }

}
