package rose.cheny16.projectfragment

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper

class ItemSwipeCallback(a: SaveLoadAdapter) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
    var adapter:SaveLoadAdapter = a
    override fun onSwiped(p0: RecyclerView.ViewHolder, p1: Int) {
        adapter.delete(p0.adapterPosition)

    }

    override fun onMove(p0: RecyclerView, p1: RecyclerView.ViewHolder, p2: RecyclerView.ViewHolder): Boolean {
        return false
    }







}