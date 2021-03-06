/**
 * RelatedToQuerySearchParameter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Mar 02, 2009 (07:08:06 PST) WSDL2Java emitter.
 */

package com.google.api.ads.adwords.axis.v201506.o;


/**
 * A {@link SearchParameter} for a query of {@code String}s.
 *             <p>This element is supported by following {@link IdeaType}s:
 * KEYWORD, PLACEMENT.
 *             <p>This element is supported by following {@link RequestType}s:
 * IDEAS, STATS.
 */
public class RelatedToQuerySearchParameter  extends com.google.api.ads.adwords.axis.v201506.o.SearchParameter  implements java.io.Serializable {
    /* A list of exact keyword match query {@link String}s that the
     * search result
     *                     should be related to.
     *                     <span class="constraint ContentsDistinct">This
     * field must contain distinct elements.</span>
     *                     <span class="constraint ContentsNotNull">This
     * field must not contain {@code null} elements.</span>
     *                     <span class="constraint NotEmpty">This field must
     * contain at least one element.</span>
     *                     <span class="constraint Required">This field is
     * required and should not be {@code null}.</span> */
    private java.lang.String[] queries;

    public RelatedToQuerySearchParameter() {
    }

    public RelatedToQuerySearchParameter(
           java.lang.String searchParameterType,
           java.lang.String[] queries) {
        super(
            searchParameterType);
        this.queries = queries;
    }


    /**
     * Gets the queries value for this RelatedToQuerySearchParameter.
     * 
     * @return queries   * A list of exact keyword match query {@link String}s that the
     * search result
     *                     should be related to.
     *                     <span class="constraint ContentsDistinct">This
     * field must contain distinct elements.</span>
     *                     <span class="constraint ContentsNotNull">This
     * field must not contain {@code null} elements.</span>
     *                     <span class="constraint NotEmpty">This field must
     * contain at least one element.</span>
     *                     <span class="constraint Required">This field is
     * required and should not be {@code null}.</span>
     */
    public java.lang.String[] getQueries() {
        return queries;
    }


    /**
     * Sets the queries value for this RelatedToQuerySearchParameter.
     * 
     * @param queries   * A list of exact keyword match query {@link String}s that the
     * search result
     *                     should be related to.
     *                     <span class="constraint ContentsDistinct">This
     * field must contain distinct elements.</span>
     *                     <span class="constraint ContentsNotNull">This
     * field must not contain {@code null} elements.</span>
     *                     <span class="constraint NotEmpty">This field must
     * contain at least one element.</span>
     *                     <span class="constraint Required">This field is
     * required and should not be {@code null}.</span>
     */
    public void setQueries(java.lang.String[] queries) {
        this.queries = queries;
    }

    public java.lang.String getQueries(int i) {
        return this.queries[i];
    }

    public void setQueries(int i, java.lang.String _value) {
        this.queries[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RelatedToQuerySearchParameter)) return false;
        RelatedToQuerySearchParameter other = (RelatedToQuerySearchParameter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.queries==null && other.getQueries()==null) || 
             (this.queries!=null &&
              java.util.Arrays.equals(this.queries, other.getQueries())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getQueries() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getQueries());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getQueries(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RelatedToQuerySearchParameter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adwords.google.com/api/adwords/o/v201506", "RelatedToQuerySearchParameter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("queries");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adwords.google.com/api/adwords/o/v201506", "queries"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
