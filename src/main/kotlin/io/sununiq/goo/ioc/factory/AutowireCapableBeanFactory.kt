package io.sununiq.goo.ioc.factory

import io.sununiq.goo.ioc.domain.BeanDefinition

class AutowireCapableBeanFactory : AbstractBeanFactory() {

    override fun doCreateBean(beanDefinition: BeanDefinition): Any {
        val bean = createBeanInstance(beanDefinition)
        applyPropertyValues(bean, beanDefinition)
        return bean
    }

    protected fun createBeanInstance(beanDefinition: BeanDefinition) = beanDefinition.clazz.newInstance()

    protected fun applyPropertyValues(bean: Any, beanDefinition: BeanDefinition) {
        beanDefinition.propertyValues.propertyValues.forEach {
            val declaredField = bean::javaClass.get().getDeclaredField(it.name)
            declaredField.isAccessible = true
            declaredField.set(bean, it.value)
        }
    }

}