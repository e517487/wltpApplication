
package com.inetpsa.pct00.application.service.wltp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConfigFeatureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfigFeatureType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ContextRequest" type="{http://inetpsa.com/cfg}ContextRequest"/>
 *         &lt;element name="ConfigCriteria" type="{http://inetpsa.com/cfg}ConfigCriteriaFeature"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfigFeatureType", propOrder = {
    "contextRequest",
    "configCriteria"
})
public class ConfigFeatureType {

    @XmlElement(name = "ContextRequest", required = true)
    protected ContextRequest contextRequest;
    @XmlElement(name = "ConfigCriteria", required = true)
    protected ConfigCriteriaFeature configCriteria;

    /**
     * Gets the value of the contextRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ContextRequest }
     *     
     */
    public ContextRequest getContextRequest() {
        return contextRequest;
    }

    /**
     * Sets the value of the contextRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContextRequest }
     *     
     */
    public void setContextRequest(ContextRequest value) {
        this.contextRequest = value;
    }

    /**
     * Gets the value of the configCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link ConfigCriteriaFeature }
     *     
     */
    public ConfigCriteriaFeature getConfigCriteria() {
        return configCriteria;
    }

    /**
     * Sets the value of the configCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfigCriteriaFeature }
     *     
     */
    public void setConfigCriteria(ConfigCriteriaFeature value) {
        this.configCriteria = value;
    }

}
