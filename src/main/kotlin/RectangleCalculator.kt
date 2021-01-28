class RectangleCalculator: ShapeCalculator<Rectangle> {
    private var shapeState: Rectangle = Rectangle(0.0, 0.0)

    override fun area(): Double = shapeState.length * shapeState.width
    override fun perimeter(): Double = 2 * (shapeState.length + shapeState.width)
    override fun shape(): Rectangle = shapeState

    override fun changeShape(shape: Rectangle) {
        shapeState = shape
    }
}
