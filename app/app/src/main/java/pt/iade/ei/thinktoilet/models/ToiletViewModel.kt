package pt.iade.ei.thinktoilet.models

import androidx.lifecycle.ViewModel
import pt.iade.ei.thinktoilet.test.generateRandomToiletsWithComments

class ToiletViewModel: ViewModel() {
    val toilets: List<Toilet> = generateRandomToiletsWithComments(numToilets = 5)

    fun getToiletById(id: Int): Toilet? {
        return toilets.find { it.id == id }
    }
}