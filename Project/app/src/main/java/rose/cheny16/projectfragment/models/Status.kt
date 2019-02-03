package rose.cheny16.projectfragment.models

import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.ServerTimestamp

data class Status(
    var CSSE120GPA: Float
    ,var MA113GPA: Float
    ,var CLSK100GPA: Float
,var JP111GPA: Float
,var CHEM111GPA: Float
, var name: String
, var happiness: Int
, var health: Int
    , var GPA: Float
    , var actionPoint: Int
, var BobR: Int      //Bob's relation
, var GirlFriendR: Int // GF's relation
, var DrBR: Int, // Dr.B's relation
    var BobEventProgress: Int //Bob's event progress
, var GirlFriendEventProgress: Int //GF's event progress
    , var DrBEventProgress: Int//DrB's event progress
, var Day: Int  // 7 days per week
, var Week: Int // 10 week
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

}