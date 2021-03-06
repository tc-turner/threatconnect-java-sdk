package com.threatconnect.sdk.client.writer.associate;

import com.threatconnect.sdk.client.response.WriteListResponse;
import com.threatconnect.sdk.exception.FailedResponseException;
import com.threatconnect.sdk.server.entity.Attribute;
import com.threatconnect.sdk.server.response.entity.ApiEntitySingleResponse;

import java.io.IOException;
import java.util.List;

public interface AttributeAssociateWritable<P> {

    public WriteListResponse<Attribute> addAttributes(P uniqueId, List<Attribute> attributes)
        throws IOException;

    public WriteListResponse<Attribute> addAttributes(P uniqueId, List<Attribute> attribute, String ownerName)
        throws IOException;

    public ApiEntitySingleResponse addAttribute(P uniqueId, Attribute attribute) throws IOException, FailedResponseException;

    public ApiEntitySingleResponse addAttribute(P uniqueId, Attribute attribute, String ownerName)
        throws IOException, FailedResponseException;

    public WriteListResponse<String> addAttributeSecurityLabels(P uniqueId, Integer attributeId, List<String> securityLabels) throws IOException;

    public WriteListResponse<String> addAttributeSecurityLabels(P uniqueId, Integer attributeId, List<String> securityLabels, String ownerName)
        throws IOException;

    public ApiEntitySingleResponse addAttributeSecurityLabel(P uniqueId, Integer attributeId, String securityLabel) throws IOException, FailedResponseException;

    public ApiEntitySingleResponse addAttributeSecurityLabel(P uniqueId, Integer attributeId, String securityLabel, String ownerName)
        throws IOException, FailedResponseException;

    public WriteListResponse<Attribute> updateAttributes(P uniqueId, List<Attribute> attributes)
        throws IOException;

    public WriteListResponse<Attribute> updateAttributes(P uniqueId, List<Attribute> attribute, String ownerName)
        throws IOException;

    public ApiEntitySingleResponse updateAttribute(P uniqueId, Attribute attribute) throws IOException, FailedResponseException;

    public ApiEntitySingleResponse updateAttribute(P uniqueId, Attribute attribute, String ownerName)
        throws IOException, FailedResponseException;

    public WriteListResponse<Integer> deleteAttributes(P uniqueId, List<Integer> attributes)
        throws IOException;

    public WriteListResponse<Integer> deleteAttributes(P uniqueId, List<Integer> attribute, String ownerName)
        throws IOException;

    public ApiEntitySingleResponse deleteAttribute(P uniqueId, Integer attribute) throws IOException, FailedResponseException;

    public ApiEntitySingleResponse deleteAttribute(P uniqueId, Integer attribute, String ownerName)
        throws IOException, FailedResponseException;

    public WriteListResponse<String> deleteAttributeSecurityLabels(P uniqueId, Integer attributeId, List<String> securityLabels) throws IOException, FailedResponseException;

    public WriteListResponse<String> deleteAttributeSecurityLabels(P uniqueId, Integer attributeId, List<String> securityLabels, String ownerName)
        throws IOException, FailedResponseException;

    public ApiEntitySingleResponse deleteAttributeSecurityLabel(P uniqueId, Integer attributeId, String securityLabel) throws IOException, FailedResponseException;

    public ApiEntitySingleResponse deleteAttributeSecurityLabel(P uniqueId, Integer attributeId, String securityLabel, String ownerName)
        throws IOException, FailedResponseException;

}
