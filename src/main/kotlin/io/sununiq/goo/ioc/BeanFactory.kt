package io.sununiq.goo.ioc

import io.sununiq.goo.ioc.domain.BeanDefinition
import java.util.concurrent.ConcurrentHashMap

interface BeanFactory {

    fun getBean(name: String): Any
}


class AbstractBeanFactory : BeanFactory {

    private val beanDefinitionMap = ConcurrentHashMap<String, BeanDefinition>()



    override fun getBean(name: String): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}