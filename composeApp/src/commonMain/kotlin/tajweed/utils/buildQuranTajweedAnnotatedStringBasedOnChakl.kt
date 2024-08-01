package tajweed.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import chakl.isNextChaklCharacterValid
import kotlin.time.measureTime

/**
 * Builds an AnnotatedString with the given color for the characters in the characterVariation list
 * that are followed by a character in the followingChaklCharacters list.
 *  it's used  for the tajweedRules that only depends on the character chakl of a certain character.
 */
fun buildQuranTajweedAnnotatedStringBasedOnChakl(
    quranText: AnnotatedString,
    characterVariation: List<Char>,
    followingChaklCharacters: List<Char>,
    numberOfCharactersToColor: Int,
    color: Color,
): AnnotatedString {
    val annotatedString =
        buildAnnotatedString {
            append(quranText)
            val time =
                measureTime {
                    quranText.forEachCharacterInCharactersVariation(
                        characterVariation = characterVariation,
                    ) { charIndex ->
                        if (
                            isNextChaklCharacterValid(
                                nextChaklCharacter = quranText[charIndex + 1],
                                followingChaklCharacters = followingChaklCharacters,
                            )
//                            &&
//                            charIndex + 1 < quranText.length
//                    charIndex + 1 < quranText.length
//                    &&
//                    quranText[charIndex + 1] in followingChaklCharacters
                        ) {
                            addStyle(
                                style =
                                    SpanStyle(
                                        color = color,
                                    ),
                                start = charIndex,
                                end = charIndex + numberOfCharactersToColor,
                            )
                        }
                    }
                }
            println("time taken to calculate: $time")
        }
    return annotatedString
}
