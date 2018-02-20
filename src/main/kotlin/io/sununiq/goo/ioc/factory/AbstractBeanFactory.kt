package io.sununiq.goo.ioc.factory

import io.sununiq.goo.ioc.domain.BeanDefinition
import java.lang.IllegalArgumentException
import java.util.concurrent.ConcurrentHashMap

abstract class AbstractBeanFactory : BeanFactory {

    private val beanDefinitionMap = ConcurrentHashMap<String, BeanDefinition>()

    override fun getBean(name: String): Any? {
        val beanDefinition = beanDefinitionMap[name] ?: throw IllegalArgumentException("Failed to find $name bean.")

        return beanDefinition.bean
    }

    override fun registerBeanDefinition(name: String, beanDefinition: BeanDefinition) {
        val bean = doCreateBean(beanDefinition)
        beanDefinition.bean = bean
        beanDefinitionMap[name] = beanDefinition
    }


    abstract fun doCreateBean(beanDefinition: BeanDefinition): Any

}