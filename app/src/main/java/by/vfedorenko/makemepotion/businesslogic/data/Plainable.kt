package by.vfedorenko.makemepotion.businesslogic.data

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 06.03.17.
 */
interface Plainable<P> {
    fun toPlainObject(): P
}
