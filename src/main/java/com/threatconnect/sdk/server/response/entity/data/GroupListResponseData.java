/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.threatconnect.sdk.server.response.entity.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.threatconnect.sdk.server.entity.Group;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 *
 * @author James
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class GroupListResponseData extends ApiEntityListResponseData<Group>
{
    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    @XmlElement(name = "Group", required = false)
    private List<Group> group;
    
    public List<Group> getGroup()
    {
        return group;
    }

    public void setGroup(List<Group> group)
    {
        this.group = group;
    }

    @Override
    @JsonIgnore
    public List<Group> getData()
    {
        return getGroup();
    }

    @Override
    public void setData(List<Group> data)
    {
        setGroup(data);
    }
}
