package decorationsave.appliances.roomwardrobebasket.di

import decorationsave.appliances.roomwardrobebasket.ui.viewmodel.AppViewModel
import decorationsave.appliances.roomwardrobebasket.ui.viewmodel.CartViewModel
import decorationsave.appliances.roomwardrobebasket.ui.viewmodel.CheckoutViewModel
import decorationsave.appliances.roomwardrobebasket.ui.viewmodel.OnboardingViewModel
import decorationsave.appliances.roomwardrobebasket.ui.viewmodel.OrderViewModel
import decorationsave.appliances.roomwardrobebasket.ui.viewmodel.ProductDetailsViewModel
import decorationsave.appliances.roomwardrobebasket.ui.viewmodel.ProductViewModel
import decorationsave.appliances.roomwardrobebasket.ui.viewmodel.SplashViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel {
        AppViewModel(
            cartRepository = get()
        )
    }

    viewModel {
        SplashViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        OnboardingViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        ProductViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        ProductDetailsViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        CheckoutViewModel(
            cartRepository = get(),
            productRepository = get(),
            orderRepository = get(),
        )
    }

    viewModel {
        CartViewModel(
            cartRepository = get(),
            productRepository = get(),
        )
    }

    viewModel {
        OrderViewModel(
            orderRepository = get(),
        )
    }
}