package io.github.sassy.viewmodelsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {

    val groupName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val members: MutableLiveData<List<Member>> by lazy {
        MutableLiveData<List<Member>>()
    }

    fun loadData() {
        groupName.postValue("CROWN POP")
        members.postValue(listOf(
            Member("三田美吹"),
            Member("田中咲帆"),
            Member("山本花織"),
            Member("里菜"),
            Member("藤田愛理"),
            Member("雪月心愛")
        ))
    }
}
