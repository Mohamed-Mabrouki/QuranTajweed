package utils.annotatedString

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import arabicLetters.arabicNormalLetters
import arabicLetters.getNextNormalCharacter
import kotlin.time.measureTime

/**
 * Builds an AnnotatedString with the given color for the characters in the characterVariation list
 * that are followed by a character in the followingNormalCharacters list.
 *  it's used  for the tajweedRules that only depends on the next normal character.
 */
fun buildQuranTajweedAnnotatedStringBasedOnNormalCharacters(
    quranText: AnnotatedString,
    characterVariation: List<Char>,
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
                            nextNormalCharacter in arabicNormalLetters &&
                            followingNormalCharacters.contains(nextNormalCharacter)
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

            println("time taken : $time")
        }
    return annotatedString
}
