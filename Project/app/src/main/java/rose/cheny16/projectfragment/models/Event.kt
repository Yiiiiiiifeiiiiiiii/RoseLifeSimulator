package rose.cheny16.projectfragment.models

import android.os.Parcelable

abstract class Event: Iterator<Word> {

    abstract var eventName: String;
    abstract var textContent0: ArrayList<Word>// Tai Ci
    abstract var textContent1: ArrayList<Word>
    abstract var textContent2: ArrayList<Word>
    abstract var ite0: Iterator<Word>
    abstract var ite1 : Iterator<Word>
    abstract var ite2: Iterator<Word>
    var state = 0;
    abstract var  choice1: Word;
    abstract var choice2:Word;



    override fun next(): Word{
        if(state == 0){
            return ite0.next();
        }else if(state == 1){
            return ite1.next();
        }else{
            return ite2.next();
        }

    }

    fun makeChoice(c: Int){
        state = c;
    }

    override fun hasNext(): Boolean {
        if(state == 0){
            return ite0.hasNext();
        }else if(state == 1){
            return ite1.hasNext();
        }else{
            return ite2.hasNext();
        }
    }
}
