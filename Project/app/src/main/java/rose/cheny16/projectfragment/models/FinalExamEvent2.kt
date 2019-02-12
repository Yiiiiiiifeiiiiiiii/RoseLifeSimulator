package rose.cheny16.projectfragment.models

import android.content.Context
import rose.cheny16.projectfragment.R
import java.math.RoundingMode
import java.text.DecimalFormat

class FinalExamEvent2(context: Context) : Event(context) {
    override var place: Int = R.drawable.classroom

    override var place2: Int = R.drawable.classroom

    var con = context as Status.IgetStatus
    var sta = con.getStatus()
    override var state = 0

    override var textContent0: ArrayList<Word>
            = ArrayList()

    override var textContent1: ArrayList<Word>
            =ArrayList()

    override var textContent2: ArrayList<Word>
            =ArrayList()

    override var choice1: Word = Word("choice", "1. Rem")

    override var choice2: Word = Word("choice", "2. Tina ")


    override var eventName = "FinalExamEvent2"

    override lateinit var ite0: Iterator<Word>

    override lateinit var ite1: Iterator<Word>

    override lateinit var ite2: Iterator<Word>

    init{
        textContent0.add(Word("You", "You are taking a final exam…"))
        textContent0.add(Word("Girl", "Question: Do you know this girl's name?"))

        textContent0.add(choice1)
        textContent0.add(choice2)
        textContent1.add(Word("Girl", ": )  "));
        textContent2.add(Word("Girl", "Hahaaa, of course you know"));

        textContent0.add(Word("You", "Some status changed"))

        ite0 = textContent0.iterator()
        ite1 = textContent1.iterator()
        ite2 = textContent2.iterator()

        sta.actionPoint = sta.actionPoint - 10
        
    }

    override fun makeChoice(c: Int) {
        val df = DecimalFormat("#.###")
        state = c
        if(c == 2){
            sta.GPA = "%.2f".format((sta.GPA +  (4 - sta.GPA)/5 )).toFloat()
        }else if(c == 1){
            sta.GPA = "%.2f".format((sta.GPA +  (3.5 - sta.GPA)/4 )).toFloat()

        }else{
            sta.GPA = "%.2f".format((sta.GPA +  (3 - sta.GPA)/5 )).toFloat()

        }
    }
}