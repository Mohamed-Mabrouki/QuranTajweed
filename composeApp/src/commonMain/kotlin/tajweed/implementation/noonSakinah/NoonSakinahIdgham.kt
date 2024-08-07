package tajweed.implementation.noonSakinah

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import chakl.Chakl
import tajweed.abstraction.TajweedRule
import utils.annotatedString.buildQuranTajweedAnnotatedString

class NoonSakinahIdgham(
    override val color: Color = Color.Yellow,
    override val characterVariation: List<Char> = listOf('ن'),
    override val followingNormalCharacters: List<Char> = listOf('ن', 'و', 'ر', 'ل', 'م', 'ي'),
    override val followingChaklCharacters: List<Char> =
        listOf(
            Chakl.SUKUN.value,
            Chakl.NO_CHAKL.value,
        ),
    override val numberOfCharactersToColor: Int = 1,
) : TajweedRule {
    override fun highlightQuranText(quranText: AnnotatedString): AnnotatedString {
        val quranAnnotatedStringWithNoonSakinahIdgham =
            buildQuranTajweedAnnotatedString(
                quranText = quranText,
                characterVariation = characterVariation,
                followingNormalCharacters = followingNormalCharacters,
                followingChaklCharacters = followingChaklCharacters,
                numberOfCharactersToColor = numberOfCharactersToColor,
                color = color,
            )

        return quranAnnotatedStringWithNoonSakinahIdgham
    }
}
