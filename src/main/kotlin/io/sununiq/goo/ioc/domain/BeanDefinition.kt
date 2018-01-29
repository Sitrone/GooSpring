package io.sununiq.goo.ioc.domain

data class BeanDefinition(
        val bean: Any,
        val clazz: Class<*>,
        val beanClassName: String,
        val isSingleton: Boolean,
        val propertyValues: List<PropertyValue>
)

data class PropertyValue(val name: String, val value: String)
