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
 * ResponseUser
 */
@Validated



public class ResponseUser  implements Serializable  {
  private static final long serialVersionUID = 1L;

  @JsonProperty("display_name")
  private String displayName = null;

  @JsonProperty("login")
  private String login = null;

  public ResponseUser displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

  /**
   * ФИО пользователя
   * @return displayName
   **/
  @Schema(example = "Тестов Тест Тестович", description = "ФИО пользователя")
      @NotNull

    public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public ResponseUser login(String login) {
    this.login = login;
    return this;
  }

  /**
   * Логин пользователя
   * @return login
   **/
  @Schema(example = "198213", description = "Логин пользователя")
      @NotNull

    public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseUser responseUser = (ResponseUser) o;
    return Objects.equals(this.displayName, responseUser.displayName) &&
        Objects.equals(this.login, responseUser.login);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, login);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseUser {\n");
    
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
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
