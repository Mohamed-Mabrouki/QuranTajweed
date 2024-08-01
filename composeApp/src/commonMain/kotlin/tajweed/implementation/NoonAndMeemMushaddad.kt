package tajweed.implementation

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import chakl.Chakl
import tajweed.abstraction.TajweedRule
import tajweed.utils.buildQuranTajweedAnnotatedStringBasedOnChakl

class NoonAndMeemMushaddad(
    override val color: Color = Color.Red,
    override val characterVariation: List<Char> = listOf('ن', 'م'),
    override val followingChaklCharacters: List<Char> = listOf(Chakl.CHADDAH.value),
    override val followingNormalCharacters: List<Char> = emptyList(),
    override val numberOfCharactersToColor: Int = 1,
) : TajweedRule {
    override fun highlightQuranText(quranText: AnnotatedString): AnnotatedString {
        val quranAnnotatedStringWithNoonAndMeemMushaddad =
            buildQuranTajweedAnnotatedStringBasedOnChakl(
                quranText,
                characterVariation = characterVariation,
                followingChaklCharacters = followingChaklCharacters,
                numberOfCharactersToColor = numberOfCharactersToColor,
                color = color,
            )

        return quranAnnotatedStringWithNoonAndMeemMushaddad
    }
}
