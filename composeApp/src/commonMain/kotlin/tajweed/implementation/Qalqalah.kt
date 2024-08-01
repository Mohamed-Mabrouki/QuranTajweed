package tajweed.implementation

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import chakl.Chakl
import tajweed.abstraction.TajweedRule
import utils.annotatedString.buildQuranTajweedAnnotatedString

class Qalqalah(
    override val color: Color = Color.Blue,
    override val characterVariation: List<Char> = listOf('ق', 'ط', 'ب', 'ج', 'د'),
    override val followingNormalCharacters: List<Char> = emptyList(),
    override val followingChaklCharacters: List<Char> = listOf(Chakl.SUKUN.value),
    override val numberOfCharactersToColor: Int = 2,
) : TajweedRule {
    override fun highlightQuranText(quranText: AnnotatedString): AnnotatedString {
        val quranAnnotatedStringWithQalqalah =
            buildQuranTajweedAnnotatedString(
                quranText,
                characterVariation = characterVariation,
                followingChaklCharacters = followingChaklCharacters,
                numberOfCharactersToColor = numberOfCharactersToColor,
                color = color,
            )

        return quranAnnotatedStringWithQalqalah
    }
}
