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
 * TestData
 */
@Validated



public class TestData  implements Serializable  {
  private static final long serialVersionUID = 1L;

  @JsonProperty("value_etcd")
  private String valueEtcd = null;

  public TestData valueEtcd(String valueEtcd) {
    this.valueEtcd = valueEtcd;
    return this;
  }

  /**
   * Get valueEtcd
   * @return valueEtcd
   **/
  @Schema(example = "bar", description = "")
      @NotNull

    public String getValueEtcd() {
    return valueEtcd;
  }

  public void setValueEtcd(String valueEtcd) {
    this.valueEtcd = valueEtcd;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestData testData = (TestData) o;
    return Objects.equals(this.valueEtcd, testData.valueEtcd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueEtcd);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestData {\n");
    
    sb.append("    valueEtcd: ").append(toIndentedString(valueEtcd)).append("\n");
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
