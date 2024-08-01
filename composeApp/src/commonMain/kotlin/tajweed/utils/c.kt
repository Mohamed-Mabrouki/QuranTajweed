package tajweed.utils

import androidx.compose.ui.text.AnnotatedString

/**
 * Iterates over the characters in the AnnotatedString that are in the characterVariation list
 * and calls the action on each character.
 */
fun AnnotatedString.forEachCharacterInCharactersVariation(
    characterVariation: List<Char>,
    action: (Int) -> Unit,
) {
    for (i in indices) {
        if (get(i) in characterVariation) {
            action(i)
        }
    }
}
