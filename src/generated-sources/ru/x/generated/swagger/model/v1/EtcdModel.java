package ru.x.generated.swagger.model.v1;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import ru.x.generated.swagger.model.v1.EtcdModelHeader;
import ru.x.generated.swagger.model.v1.KvsModel;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EtcdModel
 */
@Validated



public class EtcdModel  implements Serializable  {
  private static final long serialVersionUID = 1L;

  @JsonProperty("count")
  private String count = null;

  @JsonProperty("header")
  private EtcdModelHeader header = null;

  @JsonProperty("kvs")
  @Valid
  private List<KvsModel> kvs = null;

  public EtcdModel count(String count) {
    this.count = count;
    return this;
  }

  /**
   * Get count
   * @return count
   **/
  @Schema(example = "1", description = "")
      @NotNull

    public String getCount() {
    return count;
  }

  public void setCount(String count) {
    this.count = count;
  }

  public EtcdModel header(EtcdModelHeader header) {
    this.header = header;
    return this;
  }

  /**
   * Get header
   * @return header
   **/
  @Schema(description = "")
      @NotNull

    @Valid
    public EtcdModelHeader getHeader() {
    return header;
  }

  public void setHeader(EtcdModelHeader header) {
    this.header = header;
  }

  public EtcdModel kvs(List<KvsModel> kvs) {
    this.kvs = kvs;
    return this;
  }

  public EtcdModel addKvsItem(KvsModel kvsItem) {
    if (this.kvs == null) {
      this.kvs = new ArrayList<KvsModel>();
    }
    this.kvs.add(kvsItem);
    return this;
  }

  /**
   * Get kvs
   * @return kvs
   **/
  @Schema(description = "")
      @NotNull
    @Valid
    public List<KvsModel> getKvs() {
    return kvs;
  }

  public void setKvs(List<KvsModel> kvs) {
    this.kvs = kvs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EtcdModel etcdModel = (EtcdModel) o;
    return Objects.equals(this.count, etcdModel.count) &&
        Objects.equals(this.header, etcdModel.header) &&
        Objects.equals(this.kvs, etcdModel.kvs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, header, kvs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EtcdModel {\n");
    
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    kvs: ").append(toIndentedString(kvs)).append("\n");
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
