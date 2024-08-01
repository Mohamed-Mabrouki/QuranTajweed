package chakl

import arabicLetters.arabicNormalLetters

// TODO: add a list of all chakl characters

/**
 * Returns true if the next chakl character is not a normal arabic letter
 * and is in the following normal characters list.
 * @param followingChaklCharacters
 * the chakl characters that nextChaklCharacter should be in.
 * @param nextChaklCharacter
 *
 * the next chakl character to check if it's valid.
 */
fun isNextChaklCharacterValid(
    nextChaklCharacter: Char,
    followingChaklCharacters: List<Char>,
) = nextChaklCharacter !in arabicNormalLetters &&
    nextChaklCharacter in followingChaklCharacters
