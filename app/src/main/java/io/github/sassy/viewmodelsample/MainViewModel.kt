package io.github.sassy.viewmodelsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel: ViewModel() {
    private val repository = GroupRepository.instance

    private val groupName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    private val members: MutableLiveData<List<Member>> by lazy {
        MutableLiveData<List<Member>>()
    }

    fun getGroupName() : LiveData<String> {
        if (groupName.value == null) {
            loadGroupName()
        }
        return groupName
    }

    fun getMembers(): LiveData<List<Member>> {
        if (members.value == null) {
            loadMembers()
        }
        return members
    }

    private fun loadGroupName() {
        groupName.postValue(repository.groupName)
    }

    private fun loadMembers() {
        members.postValue(repository.members)
    }
}
