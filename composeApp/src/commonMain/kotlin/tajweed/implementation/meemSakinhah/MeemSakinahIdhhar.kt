package tajweed.implementation.meemSakinhah

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import arabicLetters.arabicNormalLetters
import chakl.Chakl
import tajweed.abstraction.TajweedRule
import utils.annotatedString.buildQuranTajweedAnnotatedStringBasedOnChaklAndNormalCharacters

class MeemSakinahIdhhar(
    override val color: Color = Color.Magenta,
    override val characterVariation: List<Char> = listOf('م'),
    override val followingNormalCharacters: List<Char> =
        arabicNormalLetters.filter {
            it != 'م' && it != 'ب'
        },
    override val followingChaklCharacters: List<Char> =
        listOf(
            Chakl.SUKUN.value,
            Chakl.NO_CHAKL.value,
        ),
    override val numberOfCharactersToColor: Int = 1,
) : TajweedRule {
    override fun highlightQuranText(quranText: AnnotatedString): AnnotatedString {
        val quranAnnotatedStringWithMeemSakinahIdhhar =
            buildQuranTajweedAnnotatedStringBasedOnChaklAndNormalCharacters(
                quranText = quranText,
                characterVariation = characterVariation,
                followingNormalCharacters = followingNormalCharacters,
                followingChaklCharacters = followingChaklCharacters,
                numberOfCharactersToColor = numberOfCharactersToColor,
                color = color,
            )

        return quranAnnotatedStringWithMeemSakinahIdhhar
    }
}
