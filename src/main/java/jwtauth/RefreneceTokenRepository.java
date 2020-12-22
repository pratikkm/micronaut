//package jwtauth;
//
//import io.micronaut.data.model.query.builder.sql.Dialect;
//import io.micronaut.data.repository.CrudRepository;
//
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import java.util.Optional;
//
//
//public interface RefreneceTokenRepository extends CrudRepository<RefreshTokenEntity ,Long> {
//
//    RefreshTokenEntity save(@NotNull @NotBlank String username ,
//                            @NotNull @NotBlank String refreshToken ,
//                            @NotNull @NotNull Boolean revoked);
//
//    Optional<RefreshTokenEntity> findByRefreshToken(@NotNull @NotBlank String refreshToken);
//
//    long updateByUsername(@NotNull @NotBlank String username ,
//                          @NotNull @NotNull Boolean revoked);
//
//}
