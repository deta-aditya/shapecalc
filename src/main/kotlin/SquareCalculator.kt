class SquareCalculator: ShapeCalculator<Square> {
    private var shapeState: Square = Square(0.0)

    override fun area(): Double = shapeState.length * shapeState.length
    override fun perimeter(): Double = shapeState.length * 4
    override fun shape(): Square = shapeState

    override fun changeShape(shape: Square) {
        shapeState = shape
    }
}
