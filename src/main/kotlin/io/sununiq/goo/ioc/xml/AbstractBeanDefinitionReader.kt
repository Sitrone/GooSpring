package io.sununiq.goo.ioc.xml

import io.sununiq.goo.ioc.domain.BeanDefinition
import io.sununiq.goo.ioc.io.ResourceLoader

abstract class AbstractBeanDefinitionReader(val resourceLoader: ResourceLoader) : BeanDefinitionReader {
    val registry : MutableMap<String, BeanDefinition> = HashMap()
}