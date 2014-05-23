//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.05.23 at 05:11:42 AM PDT 
//


package com.google.api.ads.adwords.lib.jaxb.v201402;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="selector" type="{https://adwords.google.com/api/adwords/cm/v201402}Selector"/>
 *         &lt;element name="reportName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reportType" type="{https://adwords.google.com/api/adwords/cm/v201402}ReportDefinition.ReportType"/>
 *         &lt;element name="dateRangeType" type="{https://adwords.google.com/api/adwords/cm/v201402}ReportDefinition.DateRangeType"/>
 *         &lt;element name="downloadFormat" type="{https://adwords.google.com/api/adwords/cm/v201402}DownloadFormat"/>
 *         &lt;element name="includeZeroImpressions" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "selector",
    "reportName",
    "reportType",
    "dateRangeType",
    "downloadFormat",
    "includeZeroImpressions"
})
@XmlRootElement(name = "reportDefinition")
public class ReportDefinition {

    protected Long id;
    @XmlElement(required = true)
    protected Selector selector;
    @XmlElement(required = true)
    protected String reportName;
    @XmlElement(required = true)
    protected ReportDefinitionReportType reportType;
    @XmlElement(required = true)
    protected ReportDefinitionDateRangeType dateRangeType;
    @XmlElement(required = true)
    protected DownloadFormat downloadFormat;
    protected Boolean includeZeroImpressions;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the selector property.
     * 
     * @return
     *     possible object is
     *     {@link Selector }
     *     
     */
    public Selector getSelector() {
        return selector;
    }

    /**
     * Sets the value of the selector property.
     * 
     * @param value
     *     allowed object is
     *     {@link Selector }
     *     
     */
    public void setSelector(Selector value) {
        this.selector = value;
    }

    /**
     * Gets the value of the reportName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * Sets the value of the reportName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportName(String value) {
        this.reportName = value;
    }

    /**
     * Gets the value of the reportType property.
     * 
     * @return
     *     possible object is
     *     {@link ReportDefinitionReportType }
     *     
     */
    public ReportDefinitionReportType getReportType() {
        return reportType;
    }

    /**
     * Sets the value of the reportType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportDefinitionReportType }
     *     
     */
    public void setReportType(ReportDefinitionReportType value) {
        this.reportType = value;
    }

    /**
     * Gets the value of the dateRangeType property.
     * 
     * @return
     *     possible object is
     *     {@link ReportDefinitionDateRangeType }
     *     
     */
    public ReportDefinitionDateRangeType getDateRangeType() {
        return dateRangeType;
    }

    /**
     * Sets the value of the dateRangeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportDefinitionDateRangeType }
     *     
     */
    public void setDateRangeType(ReportDefinitionDateRangeType value) {
        this.dateRangeType = value;
    }

    /**
     * Gets the value of the downloadFormat property.
     * 
     * @return
     *     possible object is
     *     {@link DownloadFormat }
     *     
     */
    public DownloadFormat getDownloadFormat() {
        return downloadFormat;
    }

    /**
     * Sets the value of the downloadFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link DownloadFormat }
     *     
     */
    public void setDownloadFormat(DownloadFormat value) {
        this.downloadFormat = value;
    }

    /**
     * Gets the value of the includeZeroImpressions property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeZeroImpressions() {
        return includeZeroImpressions;
    }

    /**
     * Sets the value of the includeZeroImpressions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeZeroImpressions(Boolean value) {
        this.includeZeroImpressions = value;
    }

}
