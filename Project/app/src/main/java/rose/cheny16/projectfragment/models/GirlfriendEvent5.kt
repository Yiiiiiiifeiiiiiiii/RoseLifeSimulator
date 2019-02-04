package rose.cheny16.projectfragment.models

import android.content.Context

class GirlfriendEvent5(context: Context): Event(context) {
    var con = context as Status.IgetStatus
    var sta = con.getStatus()
    override var state = 0;

    override var textContent0: ArrayList<Word>
            = ArrayList()

    override var textContent1: ArrayList<Word>
            =ArrayList()

    override var textContent2: ArrayList<Word>
            =ArrayList()

    override var choice1: Word = Word("choice", "1. talk");

    override var choice2: Word = Word("choice", "2. hug");

    override var eventName = "GirlfriendEvent5"

    override lateinit var ite0: Iterator<Word>

    override lateinit var ite1: Iterator<Word>

    override lateinit var ite2: Iterator<Word>

    init{
        if(sta.GirlFriendR > 500){
            textContent0.add(Word("You", "What you want to do with your girlfriend?"));
            textContent0.add(choice1)
            textContent0.add(choice2)

            textContent1.add(Word("Girl", " I like your hairstyle!"));
            textContent2.add(Word("Girl", " Sweet."));

        }else{
            textContent0.add(Word("You", "Can't find her anywhere..."));
        }




        ite0 = textContent0.iterator()
        ite1 = textContent1.iterator()
        ite2 = textContent2.iterator()

        sta.actionPoint = sta.actionPoint - 10;

    }

    override fun makeChoice(c: Int) {
        state = c
        if(c == 1){
            sta.GirlFriendR = sta.GirlFriendR + 5
            sta.happiness = sta.happiness + 5
        }else{
            sta.GirlFriendR = sta.GirlFriendR + 10
        }
    }





}