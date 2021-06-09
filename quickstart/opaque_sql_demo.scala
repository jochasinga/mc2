import edu.berkeley.cs.rise.opaque.implicits._
import org.apache.spark.sql.types._

val df = spark.read.format("edu.berkeley.cs.rise.opaque.EncryptedSource").load("/mc2/data/opaquesql.csv.enc")
val result = df.filter($"Age" < lit(30))
// This will save the result DataFrame to the result directory on the cloud
result.write.format("edu.berkeley.cs.rise.opaque.EncryptedSource").save("/mc2/opaque-sql/opaque_sql_result")


