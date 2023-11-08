import scala.io.StdIn

object InventoryManagementSystem {
  // Define a type for Product ID
  type ProductId = String

  // Define a case class for Product information
  case class Product(name: String, price: Double, quantityInStock: Int)

  // Initialize an empty inventory
  var inventory: Map[ProductId, Product] = Map()

  // Function to add a product to the inventory
  def addProduct(productId: ProductId, product: Product): Unit = {
    inventory = inventory + (productId -> product)
  }

  // Function to remove a product from the inventory
  def removeProduct(productId: ProductId): Unit = {
    inventory = inventory - productId
  }

  // Function to list all products in the inventory
  def listProducts: Seq[Product] = inventory.values.toSeq

  // Main function to interact with the user
  def main(args: Array[String]): Unit = {
    var exit = false

    while (!exit) {
      println("\nInventory Management System")
      println("1. Add a product")
      println("2. Remove a product")
      println("3. List all products")
      println("4. Exit")
      print("Enter your choice: ")

      val choice = StdIn.readInt()

      choice match {
        case 1 =>
          println("Enter Product ID: ")
          val productId = StdIn.readLine()
          println("Enter Product Name: ")
          val name = StdIn.readLine()
          println("Enter Product Price: ")
          val price = StdIn.readDouble()
          println("Enter Quantity in Stock: ")
          val quantityInStock = StdIn.readInt()
          addProduct(productId, Product(name, price, quantityInStock))
          println("Product added to the inventory.")

        case 2 =>
          println("Enter the Product ID to remove: ")
          val productIdToRemove = StdIn.readLine()
          removeProduct(productIdToRemove)
          println("Product removed from the inventory.")

        case 3 =>
          val allProducts = listProducts
          println("\nAll products in the inventory:")
          allProducts.foreach(product =>
            println(s"${product.name}, Price: ${product.price}, Quantity in Stock: ${product.quantityInStock}")
          )

        case 4 =>
          exit = true

        case _ =>
          println("Invalid choice. Please enter a valid option (1-4).")
      }
    }
  }
}
