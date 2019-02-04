package rose.cheny16.projectfragment.models

import android.content.Context

class drBevent4 (context: Context): Event(context) {
    var con = context as Status.IgetStatus
    var sta = con.getStatus()
    override var state = 0;

    override var textContent0: ArrayList<Word>
            = ArrayList()

    override var textContent1: ArrayList<Word>
            =ArrayList()

    override var textContent2: ArrayList<Word>
            =ArrayList()

    override var choice1: Word = Word("choice", "1. Draw Card");

    override var choice2: Word = Word("choice", "2. Check mysterious link");

    override var eventName = "drBevent4"

    override lateinit var ite0: Iterator<Word>

    override lateinit var ite1: Iterator<Word>

    override lateinit var ite2: Iterator<Word>

    init{
        textContent0.add(Word("Dr. Boutell", "How can I help you today?"));
        textContent0.add(choice1)
        textContent0.add(choice2)
        textContent1.add(Word("You", "drawing cards..."));
        textContent1.add(Word("You", "Some status changed"));

        textContent2.add(Word("Dr. Boutell", "This is the link"));
        textContent2.add(Word("Dr. Boutell", "linkkkk"));


        ite0 = textContent0.iterator()
        ite1 = textContent1.iterator()
        ite2 = textContent2.iterator()
        sta.actionPoint = sta.actionPoint - 10;



    }

    override fun makeChoice(c: Int) {
        state = c
        if(c == 1){
            sta.CSSE120GPA = sta.CSSE120GPA + 0.2f
            sta.GPA = (sta.GPA * 5 + 0.2f) / 5
            sta.happiness = sta.happiness + 5;
        }
    }





}