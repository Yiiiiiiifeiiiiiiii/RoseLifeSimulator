package rose.cheny16.projectfragment.models

import android.content.Context
import rose.cheny16.projectfragment.R
import java.util.*

class CHEM111event1(context: Context) : Event(context) {
    override var place: Int = R.drawable.classroom

    override var place2: Int = R.drawable.classroom

    private val correct = (1..2).random()

    var con = context as Status.IgetStatus
    var sta = con.getStatus()
    override var state = 0

    override var textContent0: ArrayList<Word>
            = ArrayList()

    override var textContent1: ArrayList<Word>
            =ArrayList()

    override var textContent2: ArrayList<Word>
            =ArrayList()

    override var choice1: Word = Word("choice", "A: Green and Blue")

    override var choice2: Word = Word("choice", "B: Red and Yellow")

    override var eventName = "CHEM111event1"

    override lateinit var ite0: Iterator<Word>

    override lateinit var ite1: Iterator<Word>

    override lateinit var ite2: Iterator<Word>

    init{
        textContent0.add(Word("You", "This is a lab…"))
        textContent0.add(Word("You", "Which 2 solutions you want to put together?"))

        textContent0.add(choice1)
        textContent0.add(choice2)

        if(correct==1){
            textContent2.add(Word("You", "Boom!"))
            textContent2.add(Word("You", "OMG I made the wrong choice."))

            textContent1.add(Word("You", "Yeah! I made the correct choice!"))
        }else{
            textContent1.add(Word("You", "Boom!"))
            textContent1.add(Word("You", "OMG I made the wrong choice."))

            textContent2.add(Word("You", "Yeah! I made the correct choice!"))
        }

        ite0 = textContent0.iterator()
        ite1 = textContent1.iterator()
        ite2 = textContent2.iterator()

        sta.happiness = sta.happiness + 1

        sta.actionPoint = sta.actionPoint - 10

    }

    override fun makeChoice(c: Int) {
        state = c
        if(c == 1){
            if(correct==1){
                sta.CHEM111GPA = sta.CHEM111GPA + 0.1f
                sta.GPA = (sta.GPA * 5 + 0.1f) / 5
            }else{
                sta.CHEM111GPA = sta.CHEM111GPA - 0.1f
                sta.GPA = (sta.GPA * 5 - 0.1f) / 5
            }
        }else{
            if(correct==1){
                sta.CHEM111GPA = sta.CHEM111GPA - 0.1f
                sta.GPA = (sta.GPA * 5 - 0.1f) / 5
            }else{
                sta.CHEM111GPA = sta.CHEM111GPA + 0.1f
                sta.GPA = (sta.GPA * 5 + 0.1f) / 5
            }
        }
    }

    fun IntRange.random() = Random().nextInt((endInclusive + 1) - start) +  start
}