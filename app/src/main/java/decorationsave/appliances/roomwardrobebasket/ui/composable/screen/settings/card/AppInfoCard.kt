package decorationsave.appliances.roomwardrobebasket.ui.composable.screen.settings.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import decorationsave.appliances.roomwardrobebasket.R
import decorationsave.appliances.roomwardrobebasket.ui.theme.LocalDimens
import decorationsave.appliances.roomwardrobebasket.ui.theme.cardBorderStroke
import decorationsave.appliances.roomwardrobebasket.ui.theme.imageBorder

private val LogoSize = 56.dp

@Composable
fun AppInfoCard(modifier: Modifier = Modifier) {
    val dimens = LocalDimens.current
    val companyName = stringResource(R.string.llsor_company_name)
    val logoShape = RoundedCornerShape(dimens.cornerRadius)

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(dimens.cardCornerRadius),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ),
        border = cardBorderStroke(),
    ) {
        Row(
            modifier = Modifier.padding(dimens.cardPadding),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.icon),
                contentDescription = stringResource(R.string.llsor_app_logo_description),
                modifier = Modifier
                    .size(LogoSize)
                    .clip(logoShape)
                    .background(MaterialTheme.colorScheme.surfaceContainerHighest)
                    .imageBorder(logoShape),
            )

            Spacer(modifier = Modifier.width(dimens.contentSpacing))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(R.string.app_name),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleMedium,
                )

                Spacer(modifier = Modifier.height(dimens.tightSpacing))

                Row(horizontalArrangement = Arrangement.spacedBy(dimens.tightSpacing)) {
                    Text(
                        text = stringResource(R.string.settings_screen_version_label),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodySmall,
                    )

                    Text(
                        text = stringResource(R.string.llsor_app_version),
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.bodySmall,
                    )
                }

                if (companyName.isNotBlank()) {
                    Spacer(modifier = Modifier.height(dimens.contentSpacing))

                    Text(
                        text = companyName,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}
