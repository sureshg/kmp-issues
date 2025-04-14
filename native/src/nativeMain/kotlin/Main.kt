import io.ktor.client.HttpClient
import io.ktor.client.engine.curl.Curl
import io.ktor.client.request.request
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>): Unit = runBlocking {
    println("Making an HTTPS request...")
    val client = HttpClient(Curl) { engine { sslVerify = true } }
    val res = client.request("https://httpbin.org/get")
    println(res.bodyAsText())
}
