package io.github.sassy.viewmodelsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel: ViewModel() {
    private val repository = GroupRepository.instance

    val groupName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val members: MutableLiveData<List<Member>> by lazy {
        MutableLiveData<List<Member>>()
    }

    fun loadData() {
        groupName.postValue(repository.groupName)
        members.postValue(repository.members)
    }
}
