package rose.cheny16.projectfragment.models

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Context
import rose.cheny16.projectfragment.MainActivity

class BobEvent1(context:Context): Event(context) {
    var con = context as Status.IgetStatus
    var sta  =con.getStatus()
    override var textContent0: ArrayList<Word>
            = ArrayList()
    override var state = 0;

    override var textContent1: ArrayList<Word>
            =ArrayList()

    override var textContent2: ArrayList<Word>
            =ArrayList()

    override var choice1: Word = Word("choice", "");

    override var choice2: Word = Word("choice", "");

    override var eventName = "BobEvent1"

    override lateinit var ite0: Iterator<Word>

    override lateinit var ite1: Iterator<Word>

    override lateinit var ite2: Iterator<Word>

    init{
        textContent0.add(Word("Bob", "Hey I'm Bob,"));
        textContent0.add(Word("Bob", "a CS freshman at Rose just like you "));
        textContent0.add(Word("Bob", "What's your name?"));
        textContent0.add(Word("You", "I'm " + con.getStatus().name + " . Nice to meet you Bob."  ));
        textContent0.add(Word("Bob", "Nice to meet you, too!"));
        textContent0.add(Word("Bob", "Do you know how to survive at Rose?"));
        textContent0.add(Word("You", "Hmm, never thought about that."));
        textContent0.add(Word("Bob", "Let me tell you buddy,"));
        textContent0.add(Word("Bob", "At beginning of each day you can do 3 things,"));
        textContent0.add(Word("Bob", "Take class, join a club activity or talk to someone. "));
        textContent0.add(Word("Bob", "Just press those buttons. They will lead you to the right place. "));
        textContent0.add(Word("Bob", "You are a student you know, so make sure you go to class."));
        textContent0.add(Word("Bob", "You have been registered taking CSSE120, CLSK100, JP111, RH131 and CHEM111."));
        textContent0.add(Word("Bob", "You can choose from those. Meet with different professors out there!"));
        textContent0.add(Word("You", "Sure"));
        textContent0.add(Word("Bob", "I’m joining the Robotics club. You should definitely try that too. "));
        textContent0.add(Word("Bob", "So go to club and you can find me there. "));
        textContent0.add(Word("Bob", "If you want to meet people other than me, press the people button."));
        textContent0.add(Word("You", "Aha."));
        textContent0.add(Word("Bob", "At the end of the day, just press next day and it will refresh you action point for another day!"));
        textContent0.add(Word("You", "Nice."));
        textContent0.add(Word("Bob", "Make sure you are happy enough to continue your life buddy. "));
        textContent0.add(Word("Bob", "Just check your happiness point. "));
        textContent0.add(Word("Bob", "If it’s below 5, than you will probably give up Rose life."));
        textContent0.add(Word("You", "I know. I’m quite positive so don’t worry, friend."));
        textContent0.add(Word("Bob", "I believe you."));
        textContent0.add(Word("Bob", "But also make sure your average GPA is over 2.0. Otherwise you will go Home."));
        textContent0.add(Word("You", "I’m quite smart too, Bob."));
        textContent0.add(Word("Bob", "OK. I think that’s it."));
        textContent0.add(Word("Bob", "By the end of this quarter, you will see your grade and your relationship with various of people."));
        textContent0.add(Word("You", "Nice. Thank you for the advice Bob. "));
        textContent0.add(Word("Bob", "You’re welcome. "));

        ite0 = textContent0.iterator()
        ite1 = textContent1.iterator()
        ite2 = textContent2.iterator()
        sta.actionPoint = sta.actionPoint - 10;



    }

    override fun makeChoice(c: Int) {
        state = c
    }



}