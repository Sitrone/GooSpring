package io.sununiq.goo.ioc.xml

interface BeanDefinitionReader {

    fun loadBeanDefinitions(location: String)
}