
package com.google.api.ads.adwords.jaxws.v201402.video;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * 
 *       Service to create and manage VideoAds.
 *       <p class="note"><b>Note:</b> This is a Beta feature.</p>
 *     
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.1
 * 
 */
@WebService(name = "VideoAdServiceInterface", targetNamespace = "https://adwords.google.com/api/adwords/video/v201402")
@XmlSeeAlso({
    com.google.api.ads.adwords.jaxws.v201402.cm.ObjectFactory.class,
    com.google.api.ads.adwords.jaxws.v201402.video.ObjectFactory.class
})
public interface VideoAdServiceInterface {


    /**
     * 
     *         Returns a list of VideoAds that satisfy the filters of the given selector.
     *         
     *         @param selector Selector specifying filters for the desired ads.
     *         @return The list of VideoAds that satisfy the selector.
     *       
     * 
     * @param selector
     * @return
     *     returns com.google.api.ads.adwords.jaxws.v201402.video.VideoAdPage
     * @throws ApiException
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://adwords.google.com/api/adwords/video/v201402")
    @RequestWrapper(localName = "get", targetNamespace = "https://adwords.google.com/api/adwords/video/v201402", className = "com.google.api.ads.adwords.jaxws.v201402.video.VideoAdServiceInterfaceget")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "https://adwords.google.com/api/adwords/video/v201402", className = "com.google.api.ads.adwords.jaxws.v201402.video.VideoAdServiceInterfacegetResponse")
    public VideoAdPage get(
        @WebParam(name = "selector", targetNamespace = "https://adwords.google.com/api/adwords/video/v201402")
        VideoAdSelector selector)
        throws ApiException
    ;

    /**
     * 
     *         Applies the given list operations, i.e. Add or Set.
     *         ADD - Creates the given VideoAds.  Each VideoAd must reference the campaignId of
     *         an existing campaign.  Associations with one or more TargetingGroups must be
     *         specified before the ad can serve, but these can be optionally omitted and applied later.
     *         SET - Updates the VideoAds. Attributes of VideoAds are immutable, only statuses
     *         and TargetingGroupAssocations can be modified.
     *         
     *         @param operations The operations to apply.
     *         @return The VideoAds as they appear after the operations have been applied.
     *       
     * 
     * @param operations
     * @return
     *     returns com.google.api.ads.adwords.jaxws.v201402.video.VideoAdReturnValue
     * @throws ApiException
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://adwords.google.com/api/adwords/video/v201402")
    @RequestWrapper(localName = "mutate", targetNamespace = "https://adwords.google.com/api/adwords/video/v201402", className = "com.google.api.ads.adwords.jaxws.v201402.video.VideoAdServiceInterfacemutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "https://adwords.google.com/api/adwords/video/v201402", className = "com.google.api.ads.adwords.jaxws.v201402.video.VideoAdServiceInterfacemutateResponse")
    public VideoAdReturnValue mutate(
        @WebParam(name = "operations", targetNamespace = "https://adwords.google.com/api/adwords/video/v201402")
        List<VideoAdOperation> operations)
        throws ApiException
    ;

}
