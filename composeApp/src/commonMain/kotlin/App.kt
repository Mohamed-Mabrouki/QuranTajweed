import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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

@Composable
@Preview
fun App() {
    MaterialTheme {
        val quranText =
            remember {
                "إِنَّ اَ۬لذِينَ يَخْشَوْنَ رَبَّهُم بِالْغَيْبِ لَهُم مَّغْفِرَةٞ وَأَجْرٞ كَبِيرٞۖ"
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

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = quranWithMeemSakinahIkhfaa,
                fontSize = 25.sp,
            )
        }
    }
}
