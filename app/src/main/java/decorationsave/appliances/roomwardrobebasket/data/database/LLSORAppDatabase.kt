package decorationsave.appliances.roomwardrobebasket.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import decorationsave.appliances.roomwardrobebasket.data.database.dao.CartItemDao
import decorationsave.appliances.roomwardrobebasket.data.database.dao.OrderDao
import decorationsave.appliances.roomwardrobebasket.data.database.converter.Converters
import decorationsave.appliances.roomwardrobebasket.data.entity.CartItemEntity
import decorationsave.appliances.roomwardrobebasket.data.entity.OrderEntity

@Database(
    entities = [CartItemEntity::class, OrderEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class LLSORAppDatabase : RoomDatabase() {

    abstract fun cartItemDao(): CartItemDao

    abstract fun orderDao(): OrderDao
}