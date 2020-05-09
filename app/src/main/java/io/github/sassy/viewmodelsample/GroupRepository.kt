package io.github.sassy.viewmodelsample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData

class GroupRepository {
    lateinit var groupName: String
    lateinit var members : List<Member>

    init {
        loadData()
    }

    private fun loadData() {
        groupName = "CROWN POP"
        members = listOf(
            Member("三田美吹"),
            Member("田中咲帆"),
            Member("山本花織"),
            Member("里菜"),
            Member("藤田愛理"),
            Member("雪月心愛")
        )
    }

    companion object Factory {
        val instance: GroupRepository
            @Synchronized get() {
                return GroupRepository()
            }
    }
}