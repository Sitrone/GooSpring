package io.sununiq.goo

class HelloWorldService {
    var text: String? = null

    var outputService: OutputService? = null

    fun helloWorld(): Unit {
        outputService!!.output(text!!)
    }

}