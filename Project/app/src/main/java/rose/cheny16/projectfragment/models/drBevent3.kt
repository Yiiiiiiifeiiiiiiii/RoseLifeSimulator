package rose.cheny16.projectfragment.models

import android.content.Context

class drBevent3(context: Context): Event(context) {
    var con = context as Status.IgetStatus
    var sta = con.getStatus()
    override var state = 0;

    override var textContent0: ArrayList<Word>
            = ArrayList()

    override var textContent1: ArrayList<Word>
            =ArrayList()

    override var textContent2: ArrayList<Word>
            =ArrayList()

    override var choice1: Word = Word("choice", "");

    override var choice2: Word = Word("choice", "");

    override var eventName = "drBevent3"

    override lateinit var ite0: Iterator<Word>

    override lateinit var ite1: Iterator<Word>

    override lateinit var ite2: Iterator<Word>

    init{
        textContent0.add(Word("Dr. Boutell", "You have been here 10 times and I’ll tell you the secret."));
        textContent0.add(Word("Dr. Boutell", "Go to this link.  "));
        textContent0.add(Word("Dr. Boutell", "You will find all the answers to the quizzes and exams for this game."));
        textContent0.add(Word("Dr. Boutell", "I won’t do this in reality! I’m doing this because this is a game!"));
        textContent0.add(Word("Dr. Boutell", "linkkk"));

        sta.CSSE120GPA = sta.CSSE120GPA + 0.2f
        sta.GPA = (sta.GPA * 5 + 0.2f) / 5
        sta.BobR = sta.BobR + 5
        sta.actionPoint = sta.actionPoint - 10;

        ite0 = textContent0.iterator()
        ite1 = textContent1.iterator()
        ite2 = textContent2.iterator()



    }
    override fun makeChoice(c: Int) {
        state = c
    }



}