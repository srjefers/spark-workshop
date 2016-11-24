import org.apache.spark.ml.UnaryTransformer
import org.apache.spark.ml.util.Identifiable
import org.apache.spark.sql.types.{DataType, StringType}

class UpperTransformer(override val uid: String)
  extends UnaryTransformer[String, String, UpperTransformer] {

  def this() = this(Identifiable.randomUID("upp"))

  override protected def createTransformFunc: String => String = {
    _.toUpperCase
  }

  override protected def outputDataType: DataType = StringType
}
