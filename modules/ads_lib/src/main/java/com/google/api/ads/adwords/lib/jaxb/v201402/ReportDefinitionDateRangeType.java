//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.05.23 at 05:11:42 AM PDT 
//


package com.google.api.ads.adwords.lib.jaxb.v201402;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportDefinition.DateRangeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReportDefinition.DateRangeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TODAY"/>
 *     &lt;enumeration value="YESTERDAY"/>
 *     &lt;enumeration value="LAST_7_DAYS"/>
 *     &lt;enumeration value="LAST_WEEK"/>
 *     &lt;enumeration value="LAST_BUSINESS_WEEK"/>
 *     &lt;enumeration value="THIS_MONTH"/>
 *     &lt;enumeration value="LAST_MONTH"/>
 *     &lt;enumeration value="ALL_TIME"/>
 *     &lt;enumeration value="CUSTOM_DATE"/>
 *     &lt;enumeration value="LAST_14_DAYS"/>
 *     &lt;enumeration value="LAST_30_DAYS"/>
 *     &lt;enumeration value="THIS_WEEK_SUN_TODAY"/>
 *     &lt;enumeration value="THIS_WEEK_MON_TODAY"/>
 *     &lt;enumeration value="LAST_WEEK_SUN_SAT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReportDefinition.DateRangeType")
@XmlEnum
public enum ReportDefinitionDateRangeType {

    TODAY,
    YESTERDAY,
    LAST_7_DAYS,
    LAST_WEEK,
    LAST_BUSINESS_WEEK,
    THIS_MONTH,
    LAST_MONTH,
    ALL_TIME,
    CUSTOM_DATE,
    LAST_14_DAYS,
    LAST_30_DAYS,
    THIS_WEEK_SUN_TODAY,
    THIS_WEEK_MON_TODAY,
    LAST_WEEK_SUN_SAT;

    public String value() {
        return name();
    }

    public static ReportDefinitionDateRangeType fromValue(String v) {
        return valueOf(v);
    }

}
