package myfan.data.models;
// Generated Jun 17, 2016 12:28:37 AM by Hibernate Tools 5.1.0.Alpha1

import java.util.HashSet;
import java.util.Set;

/**
 * UsersRoles generated by hbm2java
 */
public class UsersRoles implements java.io.Serializable {

  private Integer usersRolesId;
  private String roleName;
  private Set<Users> userses = new HashSet<Users>(0);

  public UsersRoles() {
  }

  public UsersRoles(String roleName) {
    this.roleName = roleName;
  }

  public UsersRoles(String roleName, Set<Users> userses) {
    this.roleName = roleName;
    this.userses = userses;
  }

  public Integer getUsersRolesId() {
    return this.usersRolesId;
  }

  public void setUsersRolesId(Integer usersRolesId) {
    this.usersRolesId = usersRolesId;
  }

  public String getRoleName() {
    return this.roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public Set<Users> getUserses() {
    return this.userses;
  }

  public void setUserses(Set<Users> userses) {
    this.userses = userses;
  }

}
