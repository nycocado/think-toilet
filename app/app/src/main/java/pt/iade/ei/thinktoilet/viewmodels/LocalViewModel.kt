package pt.iade.ei.thinktoilet.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pt.iade.ei.thinktoilet.models.Toilet
import pt.iade.ei.thinktoilet.models.User
import pt.iade.ei.thinktoilet.models.UserMain
import pt.iade.ei.thinktoilet.tests.generateRandomToilets
import pt.iade.ei.thinktoilet.tests.generateUserMain
import pt.iade.ei.thinktoilet.tests.generateUsers

class LocalViewModel : ViewModel() {
    private val _user = MutableLiveData<UserMain>()
    val user: LiveData<UserMain> get() = _user

    private val _users = MutableLiveData<HashMap<Int, User>>()
    val users: LiveData<HashMap<Int, User>> get() = _users

    private val _toilets = MutableLiveData<HashMap<Int, Toilet>>()
    val toilets: LiveData<HashMap<Int, Toilet>> get() = _toilets

    init {
        _user.value = generateUserMain()
        _users.value = generateUsers(10)
        _toilets.value = generateRandomToilets(20)
    }

    fun getUserMain(): UserMain {
        return _user.value!!
    }

    fun getUser(id: Int): User? {
        return _users.value?.get(id)
    }

    fun getToilet(id: Int): Toilet? {
        return _toilets.value?.get(id)
    }

    fun getToilets(): List<Toilet> {
        return _toilets.value?.values?.toList() ?: emptyList()
    }

    fun setUser(user: UserMain) {
        _user.value = user
    }

    fun setUsers(users: HashMap<Int, User>) {
        _users.value = users
    }

    fun setToilet(toilet: Toilet) {
        _toilets.value?.set(toilet.id!!, toilet)
    }

    fun setToilets(toilets: HashMap<Int, Toilet>) {
        _toilets.value = toilets
    }
}
