/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.specifications;

import com.comunidad.ad2.comunidad.entity.CommunityPost;
import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.service.enums.CommunityPostState;
import com.comunidad.ad2.comunidad.service.enums.TipoValoracion;
import static com.comunidad.ad2.comunidad.service.enums.TipoValoracion.MAS_VALORACION;
import static com.comunidad.ad2.comunidad.service.enums.TipoValoracion.MENOS_VALORACION;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.persistence.criteria.Join;
import org.mockito.ArgumentMatchers;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author jpmazate
 */
public class EspecificacionesPersonalizadas {

    public static Specification<CommunityPost> contieneUsuario(String usuario) {
        return (root, query, builder) -> {
                Join<CommunityPost, User> resultado = root.join("user");
                return builder.like(resultado.get("nombreCompleto"), contains(usuario));
                
                
        };
    }

    public static Specification<CommunityPost> contieneFechaInicial(String fechaInicial) {
        return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get("createdAt"), convertirFecha(fechaInicial));
    }

    public static Specification<CommunityPost> contieneFechaFinal(String fechaFinal) {
        return (root, query, builder) -> builder.lessThanOrEqualTo(root.get("createdAt"), convertirFecha(fechaFinal));
    }

    public static Specification<CommunityPost> contieneIdComunidad(Integer id, String val) {
        return (root, query, builder) -> {
            if (null == val) {
                Join<CommunityPost, Comunity> resultado = root.join("comunity");
                query.orderBy(builder.desc(root.get("createdAt")));
                return builder.equal(resultado.get("id"), id);
            } else {
                Join<CommunityPost, Comunity> resultado;
                switch (val) {
                    case "MAS_VALORACION":
                        resultado = root.join("comunity");
                        query.orderBy(builder.desc(root.get("rated")), builder.desc(root.get("createdAt")));
                        return builder.equal(resultado.get("id"), id);
                    case "MENOS_VALORACION":
                        resultado = root.join("comunity");
                        query.orderBy(builder.asc(root.get("rated")), builder.desc(root.get("createdAt")));
                        return builder.equal(resultado.get("id"), id);
                    default:
                        resultado = root.join("comunity");
                        query.orderBy(builder.desc(root.get("createdAt")));
                        return builder.equal(resultado.get("id"), id);
                }
            }
        };
    }

    public static Specification<CommunityPost> esComunidadActiva() {
        return (root, query, builder) -> builder.equal(root.get("state"), CommunityPostState.ACTIVE);
    }

    public static Specification<CommunityPost> esComunidadPrivada() {
        return (root, query, builder) -> builder.equal(root.get("state"), CommunityPostState.PRIVATE);
    }


    public static LocalDateTime convertirFecha(String date) {
        try {
            SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
            Date f = d.parse(date);
            LocalDateTime r = f.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
            return r;
        } catch (Exception e) {
            return LocalDateTime.now();
        }
    }

    public static String contains(String expression) {
        return MessageFormat.format("%{0}%", expression);
    }
}
