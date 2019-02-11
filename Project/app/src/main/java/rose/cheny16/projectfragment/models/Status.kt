package rose.cheny16.projectfragment.models

import android.support.design.widget.FloatingActionButton
import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.ServerTimestamp

data class Status(
    var CSSE120GPA: Float = 3.00f
    ,var MA113GPA: Float= 3.00f
    ,var CLSK100GPA: Float= 3.00f
,var JP111GPA: Float= 3.00f
,var CHEM111GPA: Float= 3.00f
    ,var RH131GPA: Float= 3.00f
, var name: String = "John"
, var happiness: Int = 50
    , var GPA: Float = (RH131GPA + CSSE120GPA + JP111GPA + CHEM111GPA) /4
    , var actionPoint: Int = 30
, var BobR: Int  = 0    //Bob's relation
, var GirlFriendR: Int = 0 // GF's relation
    ,var BobEventProgress: Int  = 0//Bob's event progress
, var GirlFriendEventProgress: Int  = 0//GF's event progress
    , var DrBEventProgress: Int = 0//DrB's event progress
    , var RH131EventProgress: Int = 0
    , var CHEM111EventProgress: Int = 0
    , var JP111EventProgress: Int = 0
    , var CSSE120EventProgress: Int = 0
, var Day: Int  = 1// 7 days per week
, var Week: Int = 1// 10 week
    ) {
    @get:Exclude
    var id = ""
    @ServerTimestamp
    var lastTouched: Timestamp? = null

    companion object {
        const val LAST_TOUCHED_KEY = "lastTouched"

        fun fromSnapshot(snapshot: DocumentSnapshot): Status {
            val status = snapshot.toObject(Status::class.java)!!
            status.id = snapshot.id
            return status
        }
    }
    interface IgetStatus{
        fun getStatus():Status
        fun setStatus(s: Status)
    }

}