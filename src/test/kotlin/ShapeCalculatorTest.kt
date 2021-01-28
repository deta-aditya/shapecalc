import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.reflect.KClass
import kotlin.test.assertEquals

typealias ShapeTestCase = Triple<Shape, Double, Double>

@RunWith(value = Parameterized::class)
class ShapeCalculatorTest(
    private val calculator: KClass<ShapeCalculator<Shape>>,
    private val testCases: Iterable<ShapeTestCase>
) {
    private lateinit var calculatorInstance: ShapeCalculator<Shape>

    @Before
    fun setUp() {
        calculatorInstance = calculator.constructors.first().call()
    }

    @Test
    fun `should have area and perimeter initial values of 0`() {
        testCases.forEach { _ ->
            val actualArea = calculatorInstance.area()
            val actualPerimeter = calculatorInstance.perimeter()

            assertEquals(0.0, actualArea)
            assertEquals(0.0, actualPerimeter)
        }
    }

    @Test
    fun `should have area and perimeter changed correctly when shape is changed`() {
        testCases.forEach {
            val (shape, area, perimeter) = it
            calculatorInstance.changeShape(shape)

            assertEquals(shape, calculatorInstance.shape())
            assertEquals(area, calculatorInstance.area())
            assertEquals(perimeter, calculatorInstance.perimeter())
        }
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(
                    SquareCalculator::class,
                    listOf<ShapeTestCase>(
                        Triple(Square(2.0), 4.0, 8.0),
                        Triple(Square(1.5), 2.25, 6.0),
                        Triple(Square(10.0), 100.0, 40.0),
                        Triple(Square(0.0), 0.0, 0.0),
                        Triple(Square(1.0), 1.0, 4.0),
                    )
                ),
                arrayOf(
                    RectangleCalculator::class,
                    listOf<ShapeTestCase>(
                        Triple(Rectangle(1.0, 2.0), 2.0, 6.0),
                        Triple(Rectangle(10.0, 70.0), 700.0, 160.0),
                        Triple(Rectangle(2.5, 1.25), 3.125, 7.5),
                        Triple(Rectangle(0.5, 0.25), 0.125, 1.5),
                    )
                )
            )
        }
    }
}