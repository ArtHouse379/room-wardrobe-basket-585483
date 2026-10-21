package decorationsave.appliances.roomwardrobebasket.di

import androidx.room.Room
import decorationsave.appliances.roomwardrobebasket.data.database.LLSORAppDatabase
import org.koin.dsl.module

private const val DB_NAME = "llsor_db"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = LLSORAppDatabase::class.java,
            name = DB_NAME
        ).build()
    }

    single { get<LLSORAppDatabase>().cartItemDao() }

    single { get<LLSORAppDatabase>().orderDao() }
}