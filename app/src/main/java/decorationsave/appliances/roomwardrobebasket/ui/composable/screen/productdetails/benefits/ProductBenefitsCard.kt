package decorationsave.appliances.roomwardrobebasket.ui.composable.screen.productdetails.benefits

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import decorationsave.appliances.roomwardrobebasket.data.model.Benefit
import decorationsave.appliances.roomwardrobebasket.ui.theme.LocalDimens
import decorationsave.appliances.roomwardrobebasket.ui.theme.cardBorderStroke

/** Сторона иконки пункта — заметно мельче ведущих иконок полей, подпись рядом важнее. */
private val BenefitIconSize = 22.dp

/**
 * Раскладка третьего варианта — своя строка на каждый довод — под той же
 * подложкой `primaryContainer` → `tertiaryContainer`, что и у пятого. Пара с
 * рядным градиентным вариантом: то же сочетание «раскладка + фактура
 * подложки», раскладка просто сменилась на вертикальную. Градиент здесь
 * горизонтальный, а не вдоль строк, — иначе на трёх узких рядах он читался бы
 * тремя разными полосами, а не одной связной подложкой.
 *
 * Готовые Container-токены выбраны вместо прозрачных `primary`/`tertiary`
 * не случайно: на альфе переход исчезал в палитрах, где оба акцента лежат в
 * одном тоне (как активная `v_cp4026` — оба тёмно-зелёные), а Container-пара
 * всегда заметно светлее нейтральной поверхности, потому что так её
 * подбирает сама палитра, а не потому что расчёт на альфу угадал.
 */
@Composable
fun ProductBenefitsCard(benefits: List<Benefit>, modifier: Modifier = Modifier) {
    val dimens = LocalDimens.current
    val shape = RoundedCornerShape(dimens.cardCornerRadius)

    Card(
        modifier = modifier,
        shape = shape,
        colors = CardDefaults.cardColors(
            // Заливка непрозрачным градиентом полностью перекрывает контейнер
            // карточки — значение здесь не рисуется никогда, но обязано быть
            // валидным цветом.
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ),
        border = cardBorderStroke(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primaryContainer,
                            MaterialTheme.colorScheme.tertiaryContainer,
                        ),
                    ),
                ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimens.cardPadding),
                verticalArrangement = Arrangement.spacedBy(dimens.contentSpacing),
            ) {
                benefits.forEach { benefit ->
                    ProductBenefitRow(benefit = benefit)
                }
            }
        }
    }
}

@Composable
private fun ProductBenefitRow(benefit: Benefit) {
    val dimens = LocalDimens.current

    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = benefit.icon,
            // Подпись рядом называет пункт сама — иконка для TalkBack
            // декоративна.
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(BenefitIconSize),
        )

        Spacer(modifier = Modifier.width(dimens.itemSpacing))

        Text(
            text = benefit.text,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.labelSmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}
