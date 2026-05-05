package com.github.gif26.izzy_financs.repository;

import com.github.gif26.izzy_financs.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {

}
