//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.06 at 02:06:15 PM EEST 
//


package io.mpa.orm.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 			
 * 
 * <p>Java class for element-collection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="element-collection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="map-key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="column" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;choice maxOccurs="2" minOccurs="0">
 *           &lt;element name="converter" type="{http://mpa.io/orm/schema}converter"/>
 *           &lt;element name="struct-converter" type="{http://mpa.io/orm/schema}struct-converter"/>
 *         &lt;/choice>
 *         &lt;choice>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="attribute-type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "element-collection", propOrder = {
    "mapKey",
    "column",
    "converterOrStructConverter"
})
public class ElementCollection {

    @XmlElement(name = "map-key")
    protected String mapKey;
    protected String column;
    @XmlElements({
        @XmlElement(name = "converter", type = Converter.class),
        @XmlElement(name = "struct-converter", type = StructConverter.class)
    })
    protected List<Object> converterOrStructConverter;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "attribute-type")
    protected String attributeType;

    /**
     * Gets the value of the mapKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMapKey() {
        return mapKey;
    }

    /**
     * Sets the value of the mapKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMapKey(String value) {
        this.mapKey = value;
    }

    /**
     * Gets the value of the column property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColumn() {
        return column;
    }

    /**
     * Sets the value of the column property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColumn(String value) {
        this.column = value;
    }

    /**
     * Gets the value of the converterOrStructConverter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the converterOrStructConverter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConverterOrStructConverter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Converter }
     * {@link StructConverter }
     * 
     * 
     */
    public List<Object> getConverterOrStructConverter() {
        if (converterOrStructConverter == null) {
            converterOrStructConverter = new ArrayList<Object>();
        }
        return this.converterOrStructConverter;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the attributeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeType() {
        return attributeType;
    }

    /**
     * Sets the value of the attributeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeType(String value) {
        this.attributeType = value;
    }

}
