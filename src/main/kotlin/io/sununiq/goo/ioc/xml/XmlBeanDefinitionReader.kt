package io.sununiq.goo.ioc.xml

import io.sununiq.goo.ioc.domain.BeanDefinition
import io.sununiq.goo.ioc.domain.BeanReference
import io.sununiq.goo.ioc.domain.PropertyValue
import io.sununiq.goo.ioc.domain.PropertyValues
import io.sununiq.goo.ioc.io.ResourceLoader
import org.w3c.dom.Document
import org.w3c.dom.Element
import java.io.InputStream
import javax.xml.parsers.DocumentBuilderFactory


class XmlBeanDefinitionReader(resourceLoader: ResourceLoader) : AbstractBeanDefinitionReader(resourceLoader) {

    override fun loadBeanDefinitions(location: String) {
        val inputStream = super.resourceLoader.getResource(location).getResource()
        doLoadBeanDefinitions(inputStream)
    }

    private fun doLoadBeanDefinitions(inputStream: InputStream) {
        inputStream.use {
            val factory = DocumentBuilderFactory.newInstance()
            val documentBuilder = factory.newDocumentBuilder()
            val document = documentBuilder.parse(it)

            registerBeanDefinitions(document)
        }
    }

    private fun registerBeanDefinitions(document: Document) {
        val root = document.documentElement

        parseBeanDefinitions(root)
    }

    private fun parseBeanDefinitions(root: Element) {
        val nodeList = root.childNodes
        (0 until nodeList.length)
                .map {
                    nodeList.item(it)
                }
                .filterIsInstance<Element>()
                .forEach {
                    processBeanDefinition(it)
                }
    }

    private fun processBeanDefinition(ele: Element) {
        val name = ele.getAttribute("name")
        val className = ele.getAttribute("class")
        val propertyValues = processProperty(ele)
        val beanDefinition = BeanDefinition(null, className, propertyValues)

        registry[name] = beanDefinition
    }

    private fun processProperty(ele: Element): PropertyValues {
        val propertyValues = PropertyValues()

        val propertyNode = ele.getElementsByTagName("property")
        (0 until propertyNode.length)
                .map {
                    propertyNode.item(it)
                }
                .filterIsInstance<Element>()
                .forEach {
                    propertyValues.addPropertyValue(doProcessProperty(it))
                }

        return propertyValues
    }

    private fun doProcessProperty(ele: Element): PropertyValue {
        val name = ele.getAttribute("name")
        val value: String? = ele.getAttribute("value")
        return if (value != null && value.isNotEmpty()) {
            PropertyValue(name, value)
        } else {
            val ref = ele.getAttribute("ref")
            if (ref == null || ref.isBlank()) {
                throw IllegalArgumentException("")
            }
            val beanReference = BeanReference(ref, null)
            PropertyValue(name, beanReference)
        }

    }
}