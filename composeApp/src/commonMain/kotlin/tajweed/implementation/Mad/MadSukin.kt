package tajweed.implementation.Mad

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import tajweed.abstraction.TajweedRule

class MadSukun(
    override val color: Color,
    override val characterVariation: List<Char>,
    override val followingNormalCharacters: List<Char>,
    override val followingChaklCharacters: List<Char>,
    override val numberOfCharactersToColor: Int,
) : TajweedRule {
    override fun highlightQuranText(quranText: AnnotatedString): AnnotatedString {
        TODO("Not yet implemented")
    }
}
