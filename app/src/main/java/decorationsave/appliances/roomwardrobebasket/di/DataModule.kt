package decorationsave.appliances.roomwardrobebasket.di

import decorationsave.appliances.roomwardrobebasket.data.repository.CartRepository
import decorationsave.appliances.roomwardrobebasket.data.repository.OnboardingRepository
import decorationsave.appliances.roomwardrobebasket.data.repository.OrderRepository
import decorationsave.appliances.roomwardrobebasket.data.repository.ProductRepository

import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    includes(databaseModule, dataStoreModule)

    single {
        OnboardingRepository(
            onboardingDataStoreManager = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single { ProductRepository() }

    single {
        CartRepository(
            cartItemDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single {
        OrderRepository(
            orderDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }
}