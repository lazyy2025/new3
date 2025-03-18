package ru.x.generated.swagger.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EtcdModelHeader
 */
@Validated



public class EtcdModelHeader  implements Serializable  {
  private static final long serialVersionUID = 1L;

  @JsonProperty("cluster_id")
  private String clusterId = null;

  @JsonProperty("member_id")
  private String memberId = null;

  @JsonProperty("revision")
  private String revision = null;

  @JsonProperty("raft_term")
  private String raftTerm = null;

  public EtcdModelHeader clusterId(String clusterId) {
    this.clusterId = clusterId;
    return this;
  }

  /**
   * Get clusterId
   * @return clusterId
   **/
  @Schema(description = "")
      @NotNull

    public String getClusterId() {
    return clusterId;
  }

  public void setClusterId(String clusterId) {
    this.clusterId = clusterId;
  }

  public EtcdModelHeader memberId(String memberId) {
    this.memberId = memberId;
    return this;
  }

  /**
   * Get memberId
   * @return memberId
   **/
  @Schema(description = "")
      @NotNull

    public String getMemberId() {
    return memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }

  public EtcdModelHeader revision(String revision) {
    this.revision = revision;
    return this;
  }

  /**
   * Get revision
   * @return revision
   **/
  @Schema(description = "")
      @NotNull

    public String getRevision() {
    return revision;
  }

  public void setRevision(String revision) {
    this.revision = revision;
  }

  public EtcdModelHeader raftTerm(String raftTerm) {
    this.raftTerm = raftTerm;
    return this;
  }

  /**
   * Get raftTerm
   * @return raftTerm
   **/
  @Schema(description = "")
      @NotNull

    public String getRaftTerm() {
    return raftTerm;
  }

  public void setRaftTerm(String raftTerm) {
    this.raftTerm = raftTerm;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EtcdModelHeader etcdModelHeader = (EtcdModelHeader) o;
    return Objects.equals(this.clusterId, etcdModelHeader.clusterId) &&
        Objects.equals(this.memberId, etcdModelHeader.memberId) &&
        Objects.equals(this.revision, etcdModelHeader.revision) &&
        Objects.equals(this.raftTerm, etcdModelHeader.raftTerm);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clusterId, memberId, revision, raftTerm);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EtcdModelHeader {\n");
    
    sb.append("    clusterId: ").append(toIndentedString(clusterId)).append("\n");
    sb.append("    memberId: ").append(toIndentedString(memberId)).append("\n");
    sb.append("    revision: ").append(toIndentedString(revision)).append("\n");
    sb.append("    raftTerm: ").append(toIndentedString(raftTerm)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
