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
                "وَإِذْ قُلْتُمْ يَٰمُوسَيٰ لَن نَّصْبِرَ عَلَيٰ طَعَامٖ وَٰحِدٖ فَادْعُ لَنَا رَبَّكَ يُخْرِجْ لَنَا مِمَّا تُنۢبِتُ اُ۬لْأَرْضُ مِنۢ بَقْلِهَا وَقِثَّآئِهَا وَفُومِهَا وَعَدَسِهَا وَبَصَلِهَاۖ قَالَ أَتَسْتَبْدِلُونَ اَ۬لذِے هُوَ أَدْنَيٰ بِالذِے هُوَ خَيْرٌۖ اِ۪هْبِطُواْ مِصْراٗ فَإِنَّ لَكُم مَّا سَأَلْتُمْۖ وَضُرِبَتْ عَلَيْهِمُ اُ۬لذِّلَّةُ وَالْمَسْكَنَةُ وَبَآءُو بِغَضَبٖ مِّنَ اَ۬للَّهِۖ ذَٰلِكَ بِأَنَّهُمْ كَانُواْ يَكْفُرُونَ بِـَٔايَٰتِ اِ۬للَّهِ وَيَقْتُلُونَ اَ۬لنَّبِيٓـِٕۧنَ بِغَيْرِ اِ۬لْحَقِّۖ ذَٰلِكَ بِمَا عَصَواْ وَّكَانُواْ يَعْتَدُونَۖ"
            }
        val quranWithQalqalah =
            remember(quranText) {
                Qalqalah()
                    .highlightQuranText(
                        quranText = buildAnnotatedString { append(quranText) },
                    )
            }
        val quranWithNoonAndMeemMushaddad =
            remember(quranWithQalqalah) {
                NoonAndMeemMushaddad()
                    .highlightQuranText(
                        quranText = buildAnnotatedString { append(quranWithQalqalah) },
                    )
            }

        val quranWithMeemSakinahIdgham =
            remember(quranWithNoonAndMeemMushaddad) {
                MeemSakinahIdgham()
                    .highlightQuranText(
                        quranText = quranWithNoonAndMeemMushaddad,
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
