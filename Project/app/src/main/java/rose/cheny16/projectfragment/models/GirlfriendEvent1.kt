package rose.cheny16.projectfragment.models

import android.content.Context
import rose.cheny16.projectfragment.R

class GirlfriendEvent1(context: Context) : Event(context) {
    override var place: Int = R.drawable.whitechapel

    override var place2: Int = R.drawable.whitechapel

    var con = context as Status.IgetStatus
    var sta = con.getStatus()
    override var state = 0;

    override var textContent0: ArrayList<Word>
            = ArrayList()

    override var textContent1: ArrayList<Word>
            =ArrayList()

    override var textContent2: ArrayList<Word>
            =ArrayList()

    override var choice1: Word = Word("choice", "1. Give another suggestion");

    override var choice2: Word = Word("choice", "2. Silence");

    override var eventName = "GirlfriendEvent1"

    override lateinit var ite0: Iterator<Word>

    override lateinit var ite1: Iterator<Word>

    override lateinit var ite2: Iterator<Word>

    init{
        textContent0.add(Word("You", "Hey! I remember you from CSSE120, you are…"));
        textContent0.add(Word("Girl", "I’m Tina."));
        textContent0.add(Word("You", "Yes! I’m " + sta.name +" Nice to meet you."));
        textContent0.add(Word("Girl", "Nice to meet you too! "));
        textContent0.add(Word("You", "What are you doing here?"));
        textContent0.add(Word("Girl", "I’m watching the white chapel, it’s beautiful."));
        textContent0.add(Word("You", "Agreed. But it was locked when I go there last time."));
        textContent0.add(Word("Girl", "Yes me too. Maybe next time at weekend."));
        textContent0.add(Word("You", "Sure. Shall we go there together?"));
        textContent0.add(Word("Girl", "Hmm. I’m not sure. It’s quite cold these days. "));
        textContent0.add(Word("You", "Oh. OK. "));
        textContent0.add(choice1)
        textContent0.add(choice2)
        textContent1.add(Word("You", "How about go to subway on campus."));
        textContent1.add(Word("Girl", "Sure! I like sandwiches. "));

        textContent2.add(Word("You", "......"));
        textContent2.add(Word("Girl", "…Well, maybe we can try subway on campus. "));
        textContent2.add(Word("You", "Yes we have subway on campus! Sure why not? "));

        ite0 = textContent0.iterator()
        ite1 = textContent1.iterator()
        ite2 = textContent2.iterator()
        sta.actionPoint = sta.actionPoint - 10;



    }

    override fun makeChoice(c: Int) {
        state = c
        if(c == 1){
            sta.GirlFriendR = sta.GirlFriendR + 5
        }else{
            sta.GirlFriendR = sta.GirlFriendR - 5
        }
    }





}