
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloControllers {

    @RequestMapping("/hello")
    fun hello():String {
        println("Hello Testing")
        return "Hello WOrld"
    }

}

