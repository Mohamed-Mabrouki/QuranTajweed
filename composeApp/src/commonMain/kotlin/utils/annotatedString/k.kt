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
 * it's used for the tajweedRules that depends on the character chakl and the next normal character
 * at the same time for it to be highlighted.
 */

fun buildQuranTajweedAnnotatedStringBasedOnChaklAndNormalCharacters(
    quranText: AnnotatedString,
    characterVariation: List<Char>,
    followingChaklCharacters: List<Char>,
    followingNormalCharacters: List<Char>,
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
                        if (
                            isNextChaklCharacterValid(
                                nextChaklCharacter = quranText[charIndex + 1],
                                followingChaklCharacters = followingChaklCharacters,
                            ) &&
                            isNextNormalCharacterValid(
                                nextNormalCharacter = nextNormalCharacter,
                                followingNormalCharacters = followingNormalCharacters,
                            )
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
