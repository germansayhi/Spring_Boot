package com.vti.springframework.specification;

import com.vti.springframework.entity.Post;
import com.vti.springframework.form.PostFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class PostSpecification {
    public static Specification<Post> buildSpec(PostFilterForm form){
        return form == null ? null : new Specification<Post>() {
            @Override
            public Predicate toPredicate(
                    Root<Post> root,
                    CriteriaQuery<?> query,
                    CriteriaBuilder builder
            ){
               var predicates = new ArrayList<Predicate>();

                // select * from where title like '%search%'
               var search = form.getSearch();
               if(StringUtils.hasText(search)){
                   var pattern = "%" + search + "%";
                   var predicate = builder.like(root.get("title"), pattern);
                   predicates.add(predicate);
               }

               // Select * From where create_at >= ?
               var  minCreateDate = form.getMinCreateDate();
               if (minCreateDate != null){
                   var minCreateAt = LocalDateTime.of(minCreateDate, LocalTime.MIN);
                   var predicate = builder.greaterThanOrEqualTo(
                           root.get("createdAt"),
                           minCreateAt
                   );
                   predicates.add(predicate);
               }

               // ... Where createAt =< ?
                var  maxCreateDate = form.getMaxCreateDate();
                if (maxCreateDate != null){
                    var maxCreateAt = LocalDateTime.of(maxCreateDate, LocalTime.MAX);
                    var predicate = builder.lessThanOrEqualTo(
                            root.get("createdAt"),
                            maxCreateAt
                    );
                    predicates.add(predicate);
                }

               return builder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}