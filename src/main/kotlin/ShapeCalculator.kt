interface ShapeCalculator<T> where T : Shape {
    fun area(): Double
    fun perimeter(): Double
    fun changeShape(shape: T): Unit
    fun shape(): T
}
