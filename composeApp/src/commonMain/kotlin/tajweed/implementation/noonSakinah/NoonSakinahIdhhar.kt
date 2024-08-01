package tajweed.implementation.noonSakinah

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import chakl.Chakl
import tajweed.abstraction.TajweedRule

class NoonSakinahIdhhar(
    override val color: Color = Color.Yellow,
    override val characterVariation: List<Char> = listOf('ن'),
    override val followingNormalCharacters: List<Char> = listOf(),
    override val followingChaklCharacters: List<Char> =
        listOf(
            Chakl.SUKUN.value,
            Chakl.NO_CHAKL.value,
        ),
    override val numberOfCharactersToColor: Int,
) : TajweedRule {
    override fun highlightQuranText(quranText: AnnotatedString): AnnotatedString {
        TODO("Not yet implemented")
    }
}
