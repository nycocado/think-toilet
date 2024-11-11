package pt.iade.ei.thinktoilet.viewmodels

import androidx.lifecycle.ViewModel
import pt.iade.ei.thinktoilet.models.Toilet
import pt.iade.ei.thinktoilet.models.ToiletDetailed
import pt.iade.ei.thinktoilet.models.User
import pt.iade.ei.thinktoilet.models.UserMain
import pt.iade.ei.thinktoilet.tests.generateRandomToiletsDetailed
import pt.iade.ei.thinktoilet.tests.generateUserMain
import pt.iade.ei.thinktoilet.tests.generateUsers

class LocalViewModel: ViewModel() {
    private val user: UserMain = generateUserMain()
    private val users: HashMap<Int, User> = generateUsers(10)
    private val toiletsDetailed: HashMap<Int, ToiletDetailed> = generateRandomToiletsDetailed(20)
    private var selectedToiletDetailedId: Int? = null

    fun getUser(): UserMain {
        return user
    }

    fun getUserById(id: Int): User? {
        return users[id]
    }

    fun getToiletDetailedById(id: Int): ToiletDetailed? {
        return toiletsDetailed[id]
    }

    fun getToiletById(id: Int): Toilet? {
        return toiletsDetailed[id]?.toilet
    }

    fun getToiletsDetailed(): List<ToiletDetailed> {
        return toiletsDetailed.values.toList()
    }

    fun getSelectedToilet(): ToiletDetailed? {
        return selectedToiletDetailedId?.let { getToiletDetailedById(it) }
    }

    fun setSelectedToiletDetailed(toiletDetailedId: Int) {
        selectedToiletDetailedId = toiletDetailedId
    }

    fun clearSelectedToilet() {
        selectedToiletDetailedId = null
    }
}