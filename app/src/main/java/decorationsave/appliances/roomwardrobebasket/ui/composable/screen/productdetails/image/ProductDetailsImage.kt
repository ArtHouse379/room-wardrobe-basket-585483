package decorationsave.appliances.roomwardrobebasket.ui.composable.screen.productdetails.image

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import decorationsave.appliances.roomwardrobebasket.ui.composable.screen.shared.ProductImage
import decorationsave.appliances.roomwardrobebasket.ui.theme.LocalDimens
import decorationsave.appliances.roomwardrobebasket.ui.theme.imageBorder

private const val ImageAspectRatio = 4f / 3f

@Composable
fun ProductDetailsImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current
    val shape = RoundedCornerShape(dimens.cardCornerRadius)

    ProductImage(
        imageUrl = imageUrl,
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(ImageAspectRatio)
            .clip(shape)
            .imageBorder(shape),
    )
}
