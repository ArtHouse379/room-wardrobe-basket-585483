package decorationsave.appliances.roomwardrobebasket.di

import decorationsave.appliances.roomwardrobebasket.data.datastore.OnboardingDataStoreManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataStoreModule = module {
    single { OnboardingDataStoreManager(androidContext()) }
}