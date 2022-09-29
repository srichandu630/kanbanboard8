package com.kanbanboard.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @NotNull
	@Size(max=30)
	@Pattern(regexp = "^[A-Za-z 0-9]+$")
    private String roleName;
    
    @NotNull
	@Size(max=500)
    private String roleDescription;

    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
    
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
    
    @Override
	public String toString() {
		return "RoleEntity [id=" + id + ", roleName=" + roleName + ", roleDescription=" + roleDescription + "]";
	}
}
