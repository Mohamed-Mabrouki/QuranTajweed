
package utils.annotatedString

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import arabicLetters.getNextNormalCharacter
import arabicLetters.isNextNormalCharacterValid
import chakl.isNextChaklCharacterValid
import kotlin.time.measureTime

/**
 * This function is used to build an annotated string that highlights the text based on the
 * followingChaklCharacters and followingNormalCharacters lists.
 * it's used for all the tajweedRules  whether they depends only on chakl or normal characters or even
 * both of them at the same time.
 *
 */

fun buildQuranTajweedAnnotatedString(
    quranText: AnnotatedString,
    characterVariation: List<Char>,
    followingChaklCharacters: List<Char>? = null,
    followingNormalCharacters: List<Char>? = null,
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
                        val nextNormalCharacter =
                            getNextNormalCharacter(
                                arabicText = quranText.substring(charIndex + 1),
                            )
                        val isNextChaklCharacterValid =
                            followingChaklCharacters?.let {
                                isNextChaklCharacterValid(
                                    nextChaklCharacter = quranText[charIndex + 1],
                                    followingChaklCharacters = it,
                                )
                            }
                        val isNextNormalCharacterValid =
                            followingNormalCharacters?.let {
                                isNextNormalCharacterValid(
                                    nextNormalCharacter = nextNormalCharacter,
                                    followingNormalCharacters = it,
                                )
                            }

                        if (
                            isNextChaklCharacterValid != false &&
                            isNextNormalCharacterValid != false
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
