//package jwtauth;
//
//
//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import io.micronaut.data.annotation.MappedEntity;
//import io.micronaut.http.annotation.Get;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//
//@MappedEntity
//public class RefreshTokenEntity {
//
//    @Id
//    @GeneratedValue
//    @NotNull
//    private long id ;
//
//    @NotNull
//    @NotBlank
//    private String username ;
//
//    @NotNull
//    @NotBlank
//    private String refreshToken ;
//
//    @NotNull
//    @NotBlank
//    private Boolean revoked ;
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getRefreshToken() {
//        return refreshToken;
//    }
//
//    public void setRefreshToken(String refreshToken) {
//        this.refreshToken = refreshToken;
//    }
//
//    public Boolean getRevoked() {
//        return revoked;
//    }
//
//    public void setRevoked(Boolean revoked) {
//        this.revoked = revoked;
//    }
//}
