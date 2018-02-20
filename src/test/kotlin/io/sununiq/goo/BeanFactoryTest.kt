package io.sununiq.goo

import io.sununiq.goo.ioc.domain.BeanDefinition
import io.sununiq.goo.ioc.domain.PropertyValue
import io.sununiq.goo.ioc.domain.PropertyValues
import io.sununiq.goo.ioc.factory.AutowireCapableBeanFactory
import org.junit.Test

class BeanFactoryTest {

    private val beanName = "io.sununiq.goo.HelloWorldService"
    private val name = "helloWorldService"

    @Test
    fun testBeanFactory() {
        val beanFactory = AutowireCapableBeanFactory()

        val propertyValue = PropertyValue("text", "Hello world!")
        val propertyValues = PropertyValues()
        propertyValues.addPropertyValue(propertyValue)

        val beanDefinition = BeanDefinition(bean = null, beanClassName = beanName, propertyValues = propertyValues)
        beanFactory.registerBeanDefinition(name, beanDefinition)

        val helloWorldService = beanFactory.getBean(name) as HelloWorldService
        helloWorldService.helloWorld()
    }
}