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
 * KvsModel
 */
@Validated



public class KvsModel  implements Serializable  {
  private static final long serialVersionUID = 1L;

  @JsonProperty("key")
  private String key = null;

  @JsonProperty("create_revision")
  private String createRevision = null;

  @JsonProperty("mod_revision")
  private String modRevision = null;

  @JsonProperty("version")
  private String version = null;

  @JsonProperty("value")
  private String value = null;

  public KvsModel key(String key) {
    this.key = key;
    return this;
  }

  /**
   * Get key
   * @return key
   **/
  @Schema(description = "")
      @NotNull

    public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public KvsModel createRevision(String createRevision) {
    this.createRevision = createRevision;
    return this;
  }

  /**
   * Get createRevision
   * @return createRevision
   **/
  @Schema(description = "")
      @NotNull

    public String getCreateRevision() {
    return createRevision;
  }

  public void setCreateRevision(String createRevision) {
    this.createRevision = createRevision;
  }

  public KvsModel modRevision(String modRevision) {
    this.modRevision = modRevision;
    return this;
  }

  /**
   * Get modRevision
   * @return modRevision
   **/
  @Schema(description = "")
      @NotNull

    public String getModRevision() {
    return modRevision;
  }

  public void setModRevision(String modRevision) {
    this.modRevision = modRevision;
  }

  public KvsModel version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Get version
   * @return version
   **/
  @Schema(description = "")
      @NotNull

    public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public KvsModel value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
   **/
  @Schema(description = "")
      @NotNull

    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KvsModel kvsModel = (KvsModel) o;
    return Objects.equals(this.key, kvsModel.key) &&
        Objects.equals(this.createRevision, kvsModel.createRevision) &&
        Objects.equals(this.modRevision, kvsModel.modRevision) &&
        Objects.equals(this.version, kvsModel.version) &&
        Objects.equals(this.value, kvsModel.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, createRevision, modRevision, version, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KvsModel {\n");
    
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    createRevision: ").append(toIndentedString(createRevision)).append("\n");
    sb.append("    modRevision: ").append(toIndentedString(modRevision)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
