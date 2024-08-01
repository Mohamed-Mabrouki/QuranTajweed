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
                "قَالَ يَٰـَٔادَمُ أَنۢبِئْهُم بِأَسْمَآئِهِمْۖ فَلَمَّا أَنۢبَأَهُم بِأَسْمَآئِهِمْ قَالَ أَلَمْ أَقُل لَّكُمْ إِنِّيَ أَعْلَمُ غَيْبَ اَ۬لسَّمَٰوَٰتِ وَالْأَرْضِ وَأَعْلَمُ مَا تُبْدُونَ وَمَا كُنتُمْ تَكْتُمُونََۖۖ"
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
