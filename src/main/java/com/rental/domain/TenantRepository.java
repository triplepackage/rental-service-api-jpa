package com.rental.domain;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by admin on 3/9/18.
 */
public interface TenantRepository extends CrudRepository<Tenant, Long> {

}
