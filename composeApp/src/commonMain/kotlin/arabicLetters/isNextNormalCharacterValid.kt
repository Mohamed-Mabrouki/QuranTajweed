package arabicLetters

/**
 * Returns true if the next normal character is a normal arabic letter
 * and is in the following normal characters list.
 * @param followingNormalCharacters
 * the normal characters that nextNormalCharacter should be in.
 * @param nextNormalCharacter
 * the next normal character to check if it's valid.
 */
fun isNextNormalCharacterValid(
    nextNormalCharacter: Char?,
    followingNormalCharacters: List<Char>,
) = nextNormalCharacter in arabicNormalLetters &&
    nextNormalCharacter in followingNormalCharacters
//    followingNormalCharacters.contains(nextNormalCharacter)
