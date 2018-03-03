package io.sununiq.goo.ioc.io

import java.io.InputStream

interface Resource {

    fun getResource(): InputStream
}