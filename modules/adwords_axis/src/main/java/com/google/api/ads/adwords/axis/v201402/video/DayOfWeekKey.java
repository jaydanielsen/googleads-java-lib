/**
 * DayOfWeekKey.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Mar 02, 2009 (07:08:06 PST) WSDL2Java emitter.
 */

package com.google.api.ads.adwords.axis.v201402.video;


/**
 * Segment key for segmenting by day of week.
 */
public class DayOfWeekKey  implements java.io.Serializable {
    private com.google.api.ads.adwords.axis.v201402.video.DayOfWeek dayOfWeek;

    public DayOfWeekKey() {
    }

    public DayOfWeekKey(
           com.google.api.ads.adwords.axis.v201402.video.DayOfWeek dayOfWeek) {
           this.dayOfWeek = dayOfWeek;
    }


    /**
     * Gets the dayOfWeek value for this DayOfWeekKey.
     * 
     * @return dayOfWeek
     */
    public com.google.api.ads.adwords.axis.v201402.video.DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }


    /**
     * Sets the dayOfWeek value for this DayOfWeekKey.
     * 
     * @param dayOfWeek
     */
    public void setDayOfWeek(com.google.api.ads.adwords.axis.v201402.video.DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DayOfWeekKey)) return false;
        DayOfWeekKey other = (DayOfWeekKey) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dayOfWeek==null && other.getDayOfWeek()==null) || 
             (this.dayOfWeek!=null &&
              this.dayOfWeek.equals(other.getDayOfWeek())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDayOfWeek() != null) {
            _hashCode += getDayOfWeek().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DayOfWeekKey.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adwords.google.com/api/adwords/video/v201402", "DayOfWeekKey"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dayOfWeek");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adwords.google.com/api/adwords/video/v201402", "dayOfWeek"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adwords.google.com/api/adwords/video/v201402", "DayOfWeek"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
