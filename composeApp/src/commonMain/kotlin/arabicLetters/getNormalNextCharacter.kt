package arabicLetters

/**
 * Returns the next normal character in an arabicText.
 *
 * example: getNextNormalCharacter("سلام عليكم=ç") returns 'س'
 */
fun getNextNormalCharacter(arabicText: String): Char? {
    if (arabicText.isNotEmpty()) {
        arabicText.forEach {
            if (it in arabicNormalLetters) {
                return it
            }
        }
    }
    return null
}
