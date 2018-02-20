package io.sununiq.goo.ioc.domain

import java.util.*

data class BeanDefinition(
        var bean: Any?,
        val beanClassName: String,
        val propertyValues: PropertyValues
){
    val clazz: Class<*> = Class.forName(beanClassName)
}

class PropertyValues {
    val propertyValues = LinkedList<PropertyValue>()

    fun addPropertyValue(propertyValue: PropertyValue) = propertyValues.add(propertyValue)
}

data class PropertyValue(val name: String, val value: String)

