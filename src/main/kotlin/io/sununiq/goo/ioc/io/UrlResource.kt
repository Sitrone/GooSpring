package io.sununiq.goo.ioc.io

import java.io.InputStream
import java.net.URL

class UriResource(val url: URL) : Resource {

    override fun getResource(): InputStream {
        val urlConnection = url.openConnection()
        urlConnection.connect()
        return urlConnection.getInputStream()
    }

}