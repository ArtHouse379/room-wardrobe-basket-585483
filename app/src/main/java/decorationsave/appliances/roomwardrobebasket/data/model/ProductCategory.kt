package decorationsave.appliances.roomwardrobebasket.data.model

import androidx.annotation.StringRes
import decorationsave.appliances.roomwardrobebasket.R

enum class ProductCategory(@field:StringRes val titleRes: Int) {
    APPLIANCES(R.string.product_category_appliances_title),
    FURNITURE(R.string.product_category_furniture_title),
    LIGHTING(R.string.product_category_lighting_title),
    CLOTHING(R.string.product_category_clothing_title),
}
