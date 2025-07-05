package com.cognizant.orm_learn_query.service;

import com.cognizant.orm_learn_query.model.Product;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Product> getFilteredProducts(String cpu, Integer ram, String os) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();

        if (cpu != null && !cpu.isEmpty()) {
            predicates.add(cb.equal(root.get("cpu"), cpu));
        }
        if (ram != null) {
            predicates.add(cb.equal(root.get("ram"), ram));
        }
        if (os != null && !os.isEmpty()) {
            predicates.add(cb.equal(root.get("os"), os));
        }

        cq.select(root).where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();
    }
}
