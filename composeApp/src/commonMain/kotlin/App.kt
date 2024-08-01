import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview
import tajweed.implementation.NoonAndMeemMushaddad
import tajweed.implementation.Qalqalah
import tajweed.implementation.meemSakinhah.MeemSakinahIdgham
import tajweed.implementation.meemSakinhah.MeemSakinahIkhfaa
import tajweed.implementation.noonSakinah.NoonSakinahIdgham

@Composable
@Preview
fun App() {
    MaterialTheme {
        val quranText =
            remember {
                "۞يَٰأَيُّهَا اَ۬لذِينَ ءَامَنُواْ إِذَا تَدَايَنتُم بِدَيْنٍ إِلَيٰ أَجَلٖ مُّسَمّيٗ فَاكْتُبُوهُۖ وَلْيَكْتُب بَّيْنَكُمْ كَاتِبُۢ بِالْعَدْلِۖ وَلَا يَأْبَ كَاتِبٌ أَنْ يَّكْتُبَۖ كَمَا عَلَّمَهُ اُ۬للَّهُ فَلْيَكْتُبْۖ وَلْيُمْلِلِ اِ۬لذِے عَلَيْهِ اِ۬لْحَقُّ وَلْيَتَّقِ اِ۬للَّهَ رَبَّهُۥ وَلَا يَبْخَسْ مِنْهُ شَيْـٔاٗۖ فَإِن كَانَ اَ۬لذِے عَلَيْهِ اِ۬لْحَقُّ سَفِيهاً أَوْ ضَعِيفاً أَوْ لَا يَسْتَطِيعُ أَنْ يُّمِلَّ هُوَ فَلْيُمْلِلْ وَلِيُّهُۥ بِالْعَدْلِۖ وَاسْتَشْهِدُواْ شَهِيدَيْنِ مِن رِّجَالِكُمْۖ فَإِن لَّمْ يَكُونَا رَجُلَيْنِ فَرَجُلٞ وَامْرَأَتَٰنِ مِمَّن تَرْضَوْنَ مِنَ اَ۬لشُّهَدَآءِ اَ۬ن تَضِلَّ إِحْدَيٰهُمَا فَتُذَكِّرَ إِحْدَيٰهُمَا اَ۬لْأُخْرَيٰۖ وَلَا يَأْبَ اَ۬لشُّهَدَآءُ اِ۪ذَا مَا دُعُواْۖ وَلَا تَسْـَٔمُواْ أَن تَكْتُبُوهُ صَغِيراً أَوْ كَبِيراً إِلَيٰ أَجَلِهِۦۖ ذَٰلِكُمْ أَقْسَطُ عِندَ اَ۬للَّهِ وَأَقْوَمُ لِلشَّهَٰدَةِ وَأَدْنَيٰ أَلَّا تَرْتَابُواْ إِلَّا أَن تَكُونَ تِجَٰرَةٌ حَاضِرَةٞ تُدِيرُونَهَا بَيْنَكُمْ فَلَيْسَ عَلَيْكُمْ جُنَاحٌ أَلَّا تَكْتُبُوهَاۖ وَأَشْهِدُواْ إِذَا تَبَايَعْتُمْۖ وَلَا يُضَآرَّ كَاتِبٞ وَلَا شَهِيدٞۖ وَإِن تَفْعَلُواْ فَإِنَّهُۥ فُسُوقُۢ بِكُمْۖ وَاتَّقُواْ اُ۬للَّهَۖ وَيُعَلِّمُكُمُ اُ۬للَّهُۖ وَاللَّهُ بِكُلِّ شَےْءٍ عَلِيمٞۖ"
            }
        val quranWithNoonAndMeemMushaddad =
            remember(quranText) {
                NoonAndMeemMushaddad()
                    .highlightQuranText(
                        quranText = buildAnnotatedString { append(quranText) },
                    )
            }
        val quranWithQalqalah =
            remember(quranWithNoonAndMeemMushaddad) {
                Qalqalah()
                    .highlightQuranText(
                        quranText = quranWithNoonAndMeemMushaddad,
                    )
            }
        val quranWithMeemSakinahIdgham =
            remember(quranWithQalqalah) {
                MeemSakinahIdgham()
                    .highlightQuranText(
                        quranText = quranWithQalqalah,
                    )
            }
        val quranWithMeemSakinahIkhfaa =
            remember(quranWithMeemSakinahIdgham) {
                MeemSakinahIkhfaa().highlightQuranText(
                    quranText = quranWithMeemSakinahIdgham,
                )
            }
        val quranWithNoonSakinahIdgham =
            remember(quranWithMeemSakinahIkhfaa) {
                NoonSakinahIdgham().highlightQuranText(
                    quranText = quranWithMeemSakinahIkhfaa,
                )
            }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = quranWithNoonSakinahIdgham,
                fontSize = 25.sp,
            )
        }
    }
}
