package io.sununiq.goo.ioc.io

class ResourceLoader {

    fun getResource(location:String): Resource {
        val resource = this.javaClass.classLoader.getResource(location)
        return UrlResource(resource)
    }
}