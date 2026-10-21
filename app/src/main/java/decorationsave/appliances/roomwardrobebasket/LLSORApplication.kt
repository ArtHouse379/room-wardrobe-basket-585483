package decorationsave.appliances.roomwardrobebasket

import android.app.Application
import decorationsave.appliances.roomwardrobebasket.di.dataModule
import decorationsave.appliances.roomwardrobebasket.di.dispatcherModule
import decorationsave.appliances.roomwardrobebasket.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class LLSORApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val appModules = dataModule + viewModule + dispatcherModule

        startKoin {
            androidLogger()
            androidContext(this@LLSORApplication)
            modules(appModules)
        }
    }
}
