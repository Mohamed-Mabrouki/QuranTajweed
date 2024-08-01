package tajweed.abstraction

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString

/**
 * superclass for all tajweed rules.
 * @param color the color that will be used to highlight the text.
 * @param followingChaklCharacters the list of chakl characters that triggers that type of tajweed
 *
 * @param followingNormalCharacters the list of normal arabic
 * characters(chakl not included) that triggers that type of tajweed
 * if it occurs after one of the character variation.
 * @param characterVariation the list of characters that triggers the tajweed.
 *
 */
interface TajweedRule {
    val color: Color
    val characterVariation: List<Char>
    val followingNormalCharacters: List<Char>
    val followingChaklCharacters: List<Char>
    val numberOfCharactersToColor: Int
    fun highlightQuranText(quranText: AnnotatedString): AnnotatedString
}
