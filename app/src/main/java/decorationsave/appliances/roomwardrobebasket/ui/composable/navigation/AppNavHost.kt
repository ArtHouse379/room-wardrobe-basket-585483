package decorationsave.appliances.roomwardrobebasket.ui.composable.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import decorationsave.appliances.roomwardrobebasket.ui.composable.screen.cart.LLSORCartScreen
import decorationsave.appliances.roomwardrobebasket.ui.composable.screen.checkout.LLSORCheckoutScreen
import decorationsave.appliances.roomwardrobebasket.ui.composable.screen.home.LLSORHomeScreen
import decorationsave.appliances.roomwardrobebasket.ui.composable.screen.onboarding.LLSOROnboardingScreen
import decorationsave.appliances.roomwardrobebasket.ui.composable.screen.order.LLSOROrdersScreen
import decorationsave.appliances.roomwardrobebasket.ui.composable.screen.productdetails.LLSORProductDetailsScreen
import decorationsave.appliances.roomwardrobebasket.ui.composable.screen.settings.LLSORSettingsScreen
import decorationsave.appliances.roomwardrobebasket.ui.composable.screen.splash.LLSORSplashScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Splash,
        modifier = modifier,
    ) {
        composable<NavRoute.Splash> {
            LLSORSplashScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(route = NavRoute.Home) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onNavigateToOnboarding = {
                    navController.navigate(route = NavRoute.Onboarding) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Onboarding> {
            LLSOROnboardingScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(NavRoute.Home) {
                        popUpTo(NavRoute.Onboarding) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Home> {
            LLSORHomeScreen(
                onNavigateToProductDetails = { id: Int ->
                    navController.navigate(
                        route = NavRoute.ProductDetails(id = id)
                    )
                }
            )
        }

        composable<NavRoute.ProductDetails> { backStackEntry ->
            val productDetails: NavRoute.ProductDetails = backStackEntry.toRoute()
            LLSORProductDetailsScreen(
                productId = productDetails.id,
            )
        }

        composable<NavRoute.Cart> {
            LLSORCartScreen(
                onNavigateToCheckoutScreen = {
                    navController.navigate(NavRoute.Checkout)
                }
            )
        }

        composable<NavRoute.Checkout> {
            LLSORCheckoutScreen(
                onNavigateToOrdersScreen = {
                    navController.navigate(NavRoute.Orders) {
                        popUpTo(NavRoute.Home) { inclusive = false }
                    }
                }
            )
        }

        composable<NavRoute.Orders> {
            LLSOROrdersScreen()
        }

        composable<NavRoute.Settings> {
            LLSORSettingsScreen()
        }
    }
}