package com.qz.zframe.tally.vo;

import com.qz.zframe.common.entity.UserDto;

import java.util.List;

public class ArchitectureAndMenberVO {

    //private String architectureName;

    private List<UserDto> membersList;

 /*   public String getArchitectureName() {
        return architectureName;
    }

    public void setArchitectureName(String architectureName) {
        this.architectureName = architectureName;
    }*/

    public List<UserDto> getMembersList() {
        return membersList;
    }

    public void setMembersList(List<UserDto> membersList) {
        this.membersList = membersList;
    }
}
