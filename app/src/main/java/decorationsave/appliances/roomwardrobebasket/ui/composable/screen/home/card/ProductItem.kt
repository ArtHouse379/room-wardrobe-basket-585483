package decorationsave.appliances.roomwardrobebasket.ui.composable.screen.home.card

import androidx.compose.foundation.clickable
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import decorationsave.appliances.roomwardrobebasket.R
import decorationsave.appliances.roomwardrobebasket.data.model.Product
import decorationsave.appliances.roomwardrobebasket.ui.composable.screen.shared.ProductImage
import decorationsave.appliances.roomwardrobebasket.ui.theme.LocalDimens
import decorationsave.appliances.roomwardrobebasket.ui.theme.cardBorderStroke
import decorationsave.appliances.roomwardrobebasket.ui.theme.imageBorder

@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    onAddToCartClick: () -> Unit,
) {
    val dimens = LocalDimens.current
    val imageShape = RoundedCornerShape(dimens.cornerRadius)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
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
            ProductImage(
                imageUrl = product.imageUrl,
                modifier = Modifier
                    .size(72.dp)
                    .clip(imageShape)
                    .imageBorder(imageShape),
            )

            Spacer(modifier = Modifier.width(dimens.contentSpacing))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = product.title,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                Text(
                    text = stringResource(product.category.titleRes),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodySmall,
                )

                Spacer(modifier = Modifier.height(dimens.tightSpacing))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(R.string.price, product.price),
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodyMedium,
                    )

                    TextButton(
                        onClick = onAddToCartClick,
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = MaterialTheme.colorScheme.primary,
                        ),
                    ) {
                        Text(text = stringResource(R.string.button_add_to_cart_label))
                    }
                }
            }
        }
    }
}
