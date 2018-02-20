package io.sununiq.goo.ioc.factory

import io.sununiq.goo.ioc.domain.BeanDefinition
import java.lang.IllegalArgumentException
import java.util.concurrent.ConcurrentHashMap

interface BeanFactory {

    fun getBean(name: String): Any?

    fun registerBeanDefinition(name: String, beanDefinition: BeanDefinition): Unit
}