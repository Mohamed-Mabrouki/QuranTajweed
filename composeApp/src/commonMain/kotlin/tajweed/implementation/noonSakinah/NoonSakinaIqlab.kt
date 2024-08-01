package tajweed.implementation.noonSakinah

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import tajweed.abstraction.TajweedRule

class NoonSakinaIqlab(
    override val color: Color = Color.Magenta,
    override val characterVariation: List<Char> = listOf('ن'),
    override val followingNormalCharacters: List<Char>,
    override val followingChaklCharacters: List<Char>,
    override val numberOfCharactersToColor: Int,
) : TajweedRule {
    override fun highlightQuranText(quranText: AnnotatedString): AnnotatedString {
        TODO("Not yet implemented")
    }
}
