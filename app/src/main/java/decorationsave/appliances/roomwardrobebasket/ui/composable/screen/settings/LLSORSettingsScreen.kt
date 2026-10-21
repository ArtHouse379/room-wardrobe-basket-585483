package decorationsave.appliances.roomwardrobebasket.ui.composable.screen.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import decorationsave.appliances.roomwardrobebasket.R
import decorationsave.appliances.roomwardrobebasket.ui.composable.approot.LocalContentBottomPadding
import decorationsave.appliances.roomwardrobebasket.ui.composable.screen.settings.card.AppInfoCard
import decorationsave.appliances.roomwardrobebasket.ui.theme.LocalDimens

@Composable
fun LLSORSettingsScreen(modifier: Modifier = Modifier) {
    val dimens = LocalDimens.current
    val supportLink = stringResource(R.string.llsor_customer_support_link)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(dimens.screenPadding)
            .padding(bottom = LocalContentBottomPadding.current),
    ) {
        AppInfoCard()

        if (supportLink.isNotBlank()) {
            Spacer(modifier = Modifier.height(dimens.contentSpacing))

            CustomerSupportCard()
        }
    }
}
