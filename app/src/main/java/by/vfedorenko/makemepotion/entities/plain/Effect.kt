package by.vfedorenko.makemepotion.entities.plain

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 06.03.17.
 */
class Effect(val name: String,
             var isKnown: Boolean) {

    override fun equals(other: Any?): Boolean {
        if (other is Effect) {
            return name == other.name
        }

        return false
    }
}
