package decorationsave.appliances.roomwardrobebasket.data.repository

import decorationsave.appliances.roomwardrobebasket.data.model.Product
import decorationsave.appliances.roomwardrobebasket.data.model.ProductCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ProductRepository {
    private val products = listOf<Product>(
        Product(
            id = 1,
            title = "Electric Kettle",
            description = "This electric kettle brings water to the boil quickly for tea, coffee, and cooking. Its compact footprint suits busy kitchens and smaller countertops. A simple handle and pouring spout make everyday use comfortable.",
            category = ProductCategory.APPLIANCES,
            price = 49.99,
            imageUrl = "https://images.pexels.com/photos/3847567/pexels-photo-3847567.jpeg",
        ),
        Product(
            id = 2,
            title = "Toaster",
            description = "This two-slot toaster prepares evenly browned bread for quick breakfasts. Adjustable browning controls make it easy to choose a lighter or crisper finish. Its removable crumb tray helps keep the kitchen counter tidy.",
            category = ProductCategory.APPLIANCES,
            price = 39.99,
            imageUrl = "https://images.pexels.com/photos/9696590/pexels-photo-9696590.jpeg",
        ),
        Product(
            id = 3,
            title = "Armchair",
            description = "This upholstered armchair offers a comfortable seat for reading or relaxing. The neutral fabric works naturally with modern and classic room schemes. Its supportive back and generous cushion make it suitable for daily use.",
            category = ProductCategory.FURNITURE,
            price = 279.00,
            imageUrl = "https://images.pexels.com/photos/25857376/pexels-photo-25857376.jpeg",
        ),
        Product(
            id = 4,
            title = "Coffee Table",
            description = "This coffee table provides an accessible surface for books, drinks, and small decor. Its clean shape fits comfortably into compact or open-plan living rooms. The sturdy construction is designed for dependable everyday use.",
            category = ProductCategory.FURNITURE,
            price = 149.00,
            imageUrl = "https://images.pexels.com/photos/16625884/pexels-photo-16625884.jpeg",
        ),
        Product(
            id = 5,
            title = "Table Lamp",
            description = "This table lamp adds focused light beside a bed, sofa, or desk. Its understated shade softens the glow for a calm evening atmosphere. The compact design is easy to position without taking over the surface.",
            category = ProductCategory.LIGHTING,
            price = 44.99,
            imageUrl = "https://images.pexels.com/photos/4612402/pexels-photo-4612402.jpeg",
        ),
        Product(
            id = 6,
            title = "Pendant Light",
            description = "This pendant light creates a useful pool of illumination above a table or counter. The exposed form gives dining spaces and kitchens a clean industrial accent. It works well as a single feature or grouped with matching fittings.",
            category = ProductCategory.LIGHTING,
            price = 69.99,
            imageUrl = "https://images.pexels.com/photos/390659/pexels-photo-390659.jpeg",
        ),
        Product(
            id = 7,
            title = "Denim Jacket",
            description = "This denim jacket is a versatile layer for mild days and cool evenings. Durable cotton denim develops a softer feel through regular wear. Classic pockets and button fastening keep the design practical and easy to style.",
            category = ProductCategory.CLOTHING,
            price = 64.99,
            imageUrl = "https://images.pexels.com/photos/6843241/pexels-photo-6843241.jpeg",
        ),
        Product(
            id = 8,
            title = "Wool Sweater",
            description = "This wool sweater provides warm, breathable comfort during colder weather. The knitted texture layers neatly over a shirt or under a coat. A timeless cut makes it a reliable part of an everyday wardrobe.",
            category = ProductCategory.CLOTHING,
            price = 79.99,
            imageUrl = "https://images.pexels.com/photos/5603269/pexels-photo-5603269.jpeg",
        ),
    )

    fun observeById(id: Int): Flow<Product?> {
        val item = products.find { it.id == id }
        return flowOf(item)
    }

    fun getById(id: Int): Product? {
        return products.find { it.id == id }
    }

    fun observeAll(): Flow<List<Product>> {
        return flowOf(products)
    }
}
